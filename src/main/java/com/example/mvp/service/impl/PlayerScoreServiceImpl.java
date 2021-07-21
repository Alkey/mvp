package com.example.mvp.service.impl;

import com.example.mvp.entity.Player;
import com.example.mvp.entity.PlayerStatistic;
import com.example.mvp.service.PlayerScoreService;
import com.example.mvp.util.PointsCounter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.mvp.util.PointsCounter.count;
import static java.util.Map.Entry.comparingByValue;

public class PlayerScoreServiceImpl implements PlayerScoreService {

    public List<Player> countPLayersScore(List<PlayerStatistic> playerStatistics) {
        Map<String, Integer> teamResult = playerStatistics.stream()
                .collect(Collectors.groupingBy(PlayerStatistic::getTeamName, Collectors.summingInt(PointsCounter::count)));
        int countPlayers = playerStatistics.stream()
                .map(PlayerStatistic::getNickname)
                .collect(Collectors.toSet()).size();
        if (playerStatistics.size() != countPlayers) {
            throw new RuntimeException("One player may play in different teams and positions in different games, but not in the same game.");
        }
        String winnerTeam = getWinnerTeam(teamResult);
        return playerStatistics.stream()
                .map(this::getPlayer)
                .peek(p -> addPointsIfTeamWin(p, winnerTeam))
                .collect(Collectors.toList());
    }

    private String getWinnerTeam(Map<String, Integer> teamResult) {
        return teamResult.entrySet()
                .stream()
                .max(comparingByValue())
                .orElseThrow()
                .getKey();
    }

    private Player getPlayer(PlayerStatistic handballPlayerStatistic) {
        Player player = new Player();
        player.setNickName(handballPlayerStatistic.getNickname());
        player.setTeam(handballPlayerStatistic.getTeamName());
        player.setScore(count(handballPlayerStatistic));
        return player;
    }

    private void addPointsIfTeamWin(Player player, String team) {
        if (player.getTeam().equals(team)) {
            int score = player.getScore() + 10;
            player.setScore(score);
        }
    }
}
