package com.example.mvp.service;

import com.example.mvp.entity.Player;
import com.example.mvp.entity.PlayerStatistic;

import java.util.List;

public interface PlayerScoreService {
    List<Player> countPLayersScore(List<PlayerStatistic> playerStatistics);
}
