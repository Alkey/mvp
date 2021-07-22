package com.example.mvp.converter.impl;

import com.example.mvp.converter.PlayerStatisticConverter;
import com.example.mvp.entity.PlayerStatistic;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class PlayerStatisticConverterImpl implements PlayerStatisticConverter {
    private final Map<String, Function<List<String[]>, List<PlayerStatistic>>> converters;

    public PlayerStatisticConverterImpl(BasketballPlayerStatisticConverterImpl basketballMatchConverter,
                                        HandballPlayerStatisticConverterImpl handballMatchConverter) {
        this.converters = Map.of("BASKETBALL", basketballMatchConverter::convert,
                "HANDBALL", handballMatchConverter::convert);
    }

    @Override
    public List<PlayerStatistic> convert(List<String[]> match) {
        if (match.size() > 0 && match.get(0).length == 1) {
            String sportType = match.get(0)[0];
            return converters.get(sportType).apply(match);
        }
        throw new RuntimeException("Unknown sport");
    }
}
