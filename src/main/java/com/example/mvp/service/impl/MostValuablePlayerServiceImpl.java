package com.example.mvp.service.impl;

import com.example.mvp.converter.impl.PlayerStatisticConverterImpl;
import com.example.mvp.entity.Player;
import com.example.mvp.service.MostValuablePlayerService;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.mvp.util.CsvReaderUtil.read;
import static java.util.Map.Entry.comparingByValue;

@RequiredArgsConstructor
public class MostValuablePlayerServiceImpl implements MostValuablePlayerService {
    private final PlayerStatisticConverterImpl converter;
    private final PlayerScoreServiceImpl service;

    public String calculateMostValuablePlayer(List<String> paths) throws IOException {
        List<Player> players = paths.stream()
                .map(path -> converter.convert(read(path)))
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
}
