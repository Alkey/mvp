package com.example.mvp.service.impl;

import com.example.mvp.entity.Player;
import com.example.mvp.entity.PlayerStatistic;
import com.example.mvp.service.PlayerScoreService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class PlayerScoreServiceImpl implements PlayerScoreService {

    public List<Player> countPLayersScore(List<PlayerStatistic> playerStatistics) {
        Map<String, Integer> teamResult = playerStatistics.stream()
                .collect(Collectors.groupingBy(PlayerStatistic::getTeamName, Collectors.summingInt(PlayerStatistic::countPoints)));
        if (playerStatistics.size() != countPlayers(playerStatistics)) {
            throw new RuntimeException("One player may play in different teams and positions in different games, but not in the same game.");
        }
        String winnerTeam = getWinnerTeam(teamResult);
        return playerStatistics.stream()
                .map(playerStatistic -> getPlayer(playerStatistic, winnerTeam))
                .collect(Collectors.toList());
    }

    private String getWinnerTeam(Map<String, Integer> teamResult) {
        return teamResult.entrySet()
                .stream()
                .max(comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow();
    }

    private Player getPlayer(PlayerStatistic playerStatistic, String winnerTeam) {
        if (playerStatistic.getTeamName().equals(winnerTeam)) {
            return new Player(playerStatistic.getNickname(), playerStatistic.getTeamName(), playerStatistic.countPoints() + 10);
        }
        return new Player(playerStatistic.getNickname(), playerStatistic.getTeamName(), playerStatistic.countPoints());
    }

    private long countPlayers(List<PlayerStatistic> playerStatistics) {
        return playerStatistics.stream()
                .map(PlayerStatistic::getNickname)
                .distinct()
                .count();
    }
}
