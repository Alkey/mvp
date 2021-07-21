package com.example.mvp.converter.impl;

import com.example.mvp.converter.PlayerStatisticConverter;
import com.example.mvp.entity.HandballPlayerStatistic;
import com.example.mvp.entity.PlayerStatistic;

import java.util.List;
import java.util.stream.Collectors;

public class HandballPlayerStatisticConverterImpl implements PlayerStatisticConverter {

    @Override
    public List<PlayerStatistic> convert(List<String[]> match) {
        return match.stream()
                .skip(1)
                .map(this::getPlayerStatistic)
                .collect(Collectors.toList());
    }

    private HandballPlayerStatistic getPlayerStatistic(String[] array) {
        if (array.length == 6) {
            return new HandballPlayerStatistic(array[0],
                    array[1],
                    Integer.parseInt(array[2]),
                    array[3],
                    Integer.parseInt(array[4]),
                    Integer.parseInt(array[5]));
        }
        throw new RuntimeException("Can't parse handball player");
    }
}
