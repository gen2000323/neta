package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.GameState;

@Service
public class GameService {

    public String select(GameState state, int index) {

        if (state.isGameOver()) {
            return "終了済み";
        }

        if (index == state.getZombieIndex()) {
            state.setGameOver(true);
            return "GAME_OVER";
        }

        if (state.getStage() >= 4) {
            return ending();
        }

        state.nextStage();
        return "SAFE";
    }

    private String ending() {
        if (Math.random() < 0.06) {
            return "RARE_BAD";
        }
        return "HAPPY";
    }
}