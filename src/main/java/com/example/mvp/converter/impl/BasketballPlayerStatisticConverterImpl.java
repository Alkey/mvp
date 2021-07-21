package com.example.mvp.converter.impl;

import com.example.mvp.converter.PlayerStatisticConverter;
import com.example.mvp.entity.BasketballPlayerStatistic;
import com.example.mvp.entity.PlayerStatistic;

import java.util.List;
import java.util.stream.Collectors;

public class BasketballPlayerStatisticConverterImpl implements PlayerStatisticConverter {

    @Override
    public List<PlayerStatistic> convert(List<String[]> match) {
        return match.stream()
                .skip(1)
                .map(this::getPlayerStatistic)
                .collect(Collectors.toList());
    }

    private BasketballPlayerStatistic getPlayerStatistic(String[] array) {
        if (array.length == 7) {
            return new BasketballPlayerStatistic(array[0],
                    array[1],
                    Integer.parseInt(array[2]),
                    array[3],
                    Integer.parseInt(array[4]),
                    Integer.parseInt(array[5]),
                    Integer.parseInt(array[6]));
        }
        throw new RuntimeException("Can't parse basketball player statistic");
    }
}
