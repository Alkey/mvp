package com.example.mvp.service.impl;

import com.example.mvp.converter.PlayerStatisticConverterFactory;
import com.example.mvp.entity.Player;
import com.example.mvp.entity.PlayerStatistic;
import com.example.mvp.service.MostValuablePlayerService;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.mvp.util.CsvReaderUtil.read;
import static java.util.Map.Entry.comparingByValue;

@RequiredArgsConstructor
public class MostValuablePlayerServiceImpl implements MostValuablePlayerService {
    private final PlayerStatisticConverterFactory converterFactory;
    private final PlayerScoreServiceImpl service;

    public String calculateMostValuablePlayer(List<String> paths) {
        List<Player> players = paths.stream()
                .map(path -> getPlayerStatistics(read(path)))
                .map(service::countPLayersScore)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return getMostValuablePlayer(players);
    }

    private String getMostValuablePlayer(List<Player> players) {
        return players.stream()
                .collect(Collectors.groupingBy(Player::getNickName, Collectors.summingInt(Player::getScore)))
                .entrySet()
                .stream()
                .max(comparingByValue())
                .map(e -> e.getKey() + " " + e.getValue())
                .orElseThrow(() -> new RuntimeException("Can't get most valuable player"));
    }

    private List<PlayerStatistic> getPlayerStatistics(List<String[]> match) {
        if (match.size() > 0 && match.get(0).length == 1) {
            return converterFactory.get(match.get(0)[0]).convert(match);
        }
        throw new RuntimeException("Unknown sport");
    }
}
