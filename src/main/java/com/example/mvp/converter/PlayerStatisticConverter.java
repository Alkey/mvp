package com.example.mvp.converter;

import com.example.mvp.entity.PlayerStatistic;

import java.util.List;

public interface PlayerStatisticConverter {
    List<PlayerStatistic> convert(List<String[]> match);
}
