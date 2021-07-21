package com.example.mvp.entity;

import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public class BasketballPlayerStatistic extends PlayerStatistic {
     int scoredPoints;
     int rebounds;
     int assists;

    public BasketballPlayerStatistic(String playerName, String nickname,
                                     int number, String teamName,
                                     int scoredPoints, int rebounds, int assists) {
        super(playerName, nickname, number, teamName);
        this.scoredPoints = scoredPoints;
        this.rebounds = rebounds;
        this.assists = assists;
    }
}
