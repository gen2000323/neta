package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.GameResult;
import com.example.demo.model.GameState;
import com.example.demo.service.GameService;

@Controller
public class ZombieController {

    @Autowired
    private GameService gameService;

    private GameState gameState = new GameState();
    private List<GameResult> resultHistory = new ArrayList<>();

    @GetMapping("/")
    public String title(Model model) {
        model.addAttribute("results", resultHistory);
        return "index";
    }

    @PostMapping("/start")
    @ResponseBody
    public String start(@RequestParam String playerName) {
        gameState = new GameState();
        gameState.setPlayerName(playerName);
        return "START";
    }

    @PostMapping("/select")
    @ResponseBody
    public String select(@RequestParam int index) {
        String result = gameService.select(gameState, index);

        if ("GAME_OVER".equals(result)) {
            addResult(gameState.getPlayerName(), gameState.getStage() + "回目で死亡");
        } else if ("HAPPY".equals(result)) {
            addResult(gameState.getPlayerName(), "ハッピーエンド");
        } else if ("RARE_BAD".equals(result)) {
            addResult(gameState.getPlayerName(), "レアバッドエンド");
        }
        return result;
    }

    private void addResult(String playerName, String result) {
        resultHistory.add(0, new GameResult(playerName, result));
        if (resultHistory.size() > 4) {
            resultHistory.remove(4);
        }
    }
}