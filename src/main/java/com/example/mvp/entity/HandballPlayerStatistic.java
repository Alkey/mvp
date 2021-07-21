package com.example.mvp.entity;

import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public class HandballPlayerStatistic extends PlayerStatistic {
    int goalsMade;
    int goalsReceived;

    public HandballPlayerStatistic(String playerName, String nickname,
                                   int number, String teamName,
                                   int goalsMade, int goalsReceived) {
        super(playerName, nickname, number, teamName);
        this.goalsMade = goalsMade;
        this.goalsReceived = goalsReceived;
    }

    @Override
    public int countPoints() {
        return goalsMade * 2 - goalsReceived;
    }
}
