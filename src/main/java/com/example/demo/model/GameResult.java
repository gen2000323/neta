package com.example.demo.model;

public class GameResult {

    private String playerName;
    private String result;

    public GameResult() {
    }

    public GameResult(String playerName, String result) {
        this.playerName = playerName;
        this.result = result;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
