package com.example.mvp.converter.impl;

import com.example.mvp.converter.PlayerStatisticConverter;
import com.example.mvp.entity.PlayerStatistic;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PlayerStatisticConverterImpl implements PlayerStatisticConverter {
    private final BasketballPlayerStatisticConverterImpl basketballMatchConverter;
    private final HandballPlayerStatisticConverterImpl handballMatchConverter;

    @Override
    public List<PlayerStatistic> convert(List<String[]> match) {
        if (isBasketball(match)) {
            return basketballMatchConverter.convert(match);
        } else if (isHandball(match)) {
            return handballMatchConverter.convert(match);
        }
        throw new RuntimeException("Unknown sport");
    }

    private boolean isBasketball(List<String[]> read) {
        return read.size() > 0
                && read.get(0).length == 1
                && read.get(0)[0].equals("BASKETBALL");
    }

    private boolean isHandball(List<String[]> read) {
        return read.size() > 0
                && read.get(0).length == 1
                && read.get(0)[0].equals("HANDBALL");
    }
}
