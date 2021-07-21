package com.example.mvp;

import com.example.mvp.converter.impl.BasketballPlayerStatisticConverterImpl;
import com.example.mvp.converter.impl.HandballPlayerStatisticConverterImpl;
import com.example.mvp.converter.impl.PlayerStatisticConverterImpl;
import com.example.mvp.service.impl.MostValuablePlayerServiceImpl;
import com.example.mvp.service.impl.PlayerScoreServiceImpl;

import java.io.IOException;
import java.util.List;

public class MvpApplication {
    private static final List<String> paths = List.of("basketball.csv", "handball.csv");

    public static void main(String[] args) throws IOException {
        MostValuablePlayerServiceImpl service = new MostValuablePlayerServiceImpl(
                new PlayerStatisticConverterImpl(new BasketballPlayerStatisticConverterImpl(), new HandballPlayerStatisticConverterImpl()),
                new PlayerScoreServiceImpl());
        System.out.println(service.calculateMostValuablePlayer(paths));
    }
}
