package com.example.mvp.util;

import com.example.mvp.entity.BasketballPlayerStatistic;
import com.example.mvp.entity.HandballPlayerStatistic;
import com.example.mvp.entity.PlayerStatistic;

public class PointsCounter {
    private static final int SCORES_POINT_AND_GOAL_MADE_COEFFICIENT = 2;
    private static final int REBOUND_AND_ASSIST_COEFFICIENT = 1;
    private static final int GOAL_RECEIVED_COEFFICIENT = -1;

    public static int count(PlayerStatistic statistic) {
        if (statistic instanceof BasketballPlayerStatistic) {
            return countBasketballPlayersPoints(statistic);
        } else if (statistic instanceof HandballPlayerStatistic) {
            return countHandballPlayersPoints(statistic);
        }
        return 0;
    }

    private static int countBasketballPlayersPoints(PlayerStatistic playerStatistic) {
        BasketballPlayerStatistic basketballPlayerStatistic = (BasketballPlayerStatistic) playerStatistic;
        return basketballPlayerStatistic.getScoredPoints() * SCORES_POINT_AND_GOAL_MADE_COEFFICIENT
                + basketballPlayerStatistic.getRebounds() * REBOUND_AND_ASSIST_COEFFICIENT
                + basketballPlayerStatistic.getAssists() * REBOUND_AND_ASSIST_COEFFICIENT;
    }

    private static int countHandballPlayersPoints(PlayerStatistic playerStatistic) {
        HandballPlayerStatistic handballPlayerStatistic = (HandballPlayerStatistic) playerStatistic;
        return handballPlayerStatistic.getGoalsMade() * SCORES_POINT_AND_GOAL_MADE_COEFFICIENT
                + handballPlayerStatistic.getGoalsReceived() * GOAL_RECEIVED_COEFFICIENT;
    }
}
