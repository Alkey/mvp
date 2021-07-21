package com.example.mvp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class PlayerStatistic {
    private String playerName;
    private String nickname;
    private int number;
    private String teamName;
}
