package com.example.mvp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class PlayerStatistic {
    private final String playerName;
    private final String nickname;
    private final int number;
    private final String teamName;

    public abstract int countPoints();
}
