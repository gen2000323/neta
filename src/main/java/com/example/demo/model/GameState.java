package com.example.demo.model;

public class GameState {

    private String playerName;
    private int stage;
    private int zombieIndex;
    private boolean gameOver;

    public GameState() {
        this.stage = 1;
        this.zombieIndex = generateZombie();
        this.gameOver = false;
    }

    private int generateZombie() {
        return (int) (Math.random() * 4);
    }

    public void nextStage() {
        this.stage++;
        this.zombieIndex = generateZombie();
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getStage() {
        return stage;
    }

    public int getZombieIndex() {
        return zombieIndex;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}