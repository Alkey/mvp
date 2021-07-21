package com.example.mvp.service;

import java.io.IOException;
import java.util.List;

public interface MostValuablePlayerService {
    String calculateMostValuablePlayer(List<String> paths) throws IOException;
}
