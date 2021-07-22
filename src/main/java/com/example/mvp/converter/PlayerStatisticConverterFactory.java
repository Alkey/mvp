package com.example.mvp.converter;

import com.example.mvp.converter.impl.BasketballPlayerStatisticConverterImpl;
import com.example.mvp.converter.impl.HandballPlayerStatisticConverterImpl;

import java.util.Map;

public class PlayerStatisticConverterFactory {
    private final Map<String, PlayerStatisticConverter> converters;

    public PlayerStatisticConverterFactory(BasketballPlayerStatisticConverterImpl basketballMatchConverter,
                                           HandballPlayerStatisticConverterImpl handballMatchConverter) {
        this.converters = Map.of("BASKETBALL", basketballMatchConverter,
                "HANDBALL", handballMatchConverter);
    }

    public PlayerStatisticConverter get(String sportType) {
        return converters.get(sportType);
    }
}
