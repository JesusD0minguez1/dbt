package com.example.dbt;

import org.json.JSONArray;

import java.util.HashMap;

public class Status
{
    private static int SimonScore = 0;
    private static int MemoryScore = 0;
    private static int TriviaScore = 0;
    private static int IsekaiScore = 0;
    private static int DumbScore = 0;

    private static int targetScore = 0;

    static boolean isItEasy = false;
    static boolean isItMedium = false;
    static boolean isItHard = false;

    static boolean isekaiEnd = false;
    static boolean memoryEnd = false;
    static boolean simonEnd = false;
    static boolean triviaEnd = false;
    static boolean targetEnd = false;
    static boolean dumbEnd = false;

    static boolean fromMemory = false;
    static boolean fromSimonGO = false;
    static boolean fromTrivia = false;
    static boolean fromTargetGame = false;
    static boolean fromIsekai = false;

    private static String PlayerName;

    HashMap<Integer, String> typeOfGame = new HashMap<>(5);

    public void game()
    {
        typeOfGame.put(1,"Simon Go");
        typeOfGame.put(2,"Memory Game");
        typeOfGame.put(3,"Target Game");
        typeOfGame.put(4,"My isekai");
        typeOfGame.put(5,"Trivia Game");

    }


    public static String getPlayerName() {
        return PlayerName;
    }

    public static void setPlayerName(String playerName) {
        PlayerName = playerName;
    }

    public static int getSimonScore() { return SimonScore; }

    public static void setSimonScore(int simonScore) {
        SimonScore = simonScore;
    }

    public static int getMemoryScore() {
        return MemoryScore;
    }

    public static void setMemoryScore(int memoryScore) {
        MemoryScore = memoryScore;
    }

    public static int getTriviaScore() {
        return TriviaScore;
    }

    public static void setTriviaScore(int triviaScore) {
        TriviaScore = triviaScore;
    }

    public static int getIsekaiScore() {
        return IsekaiScore;
    }

    public static void setIsekaiScore(int isekaiScore) {
        IsekaiScore = isekaiScore;
    }

    public static int getDumbScore() {
        return DumbScore;
    }

    public static void setDumbScore(int dumbScore) {
        DumbScore = dumbScore;
    }

    public static int getTargetScore() { return targetScore; }

    public static void setTargetScore(int targetScore) { Status.targetScore = targetScore; }
}
