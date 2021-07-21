package com.example.mvp;

import com.example.mvp.converter.impl.BasketballPlayerStatisticConverterImpl;
import com.example.mvp.converter.impl.HandballPlayerStatisticConverterImpl;
import com.example.mvp.converter.impl.PlayerStatisticConverterImpl;
import com.example.mvp.service.impl.MostValuablePlayerService;
import com.example.mvp.service.impl.PlayerScoreServiceImpl;

import java.io.IOException;
import java.util.List;

public class MvpApplication {
    private static final List<String> paths = List.of("basketball.csv", "handball.csv");
    private static final MostValuablePlayerService service = new MostValuablePlayerService(
            new PlayerStatisticConverterImpl(new BasketballPlayerStatisticConverterImpl(), new HandballPlayerStatisticConverterImpl()),
            new PlayerScoreServiceImpl());

    public static void main(String[] args) throws IOException {
        service.calculateMostValuablePlayer(paths);
    }
}
