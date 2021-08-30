package com.example.dbt;

public class Status
{
    private static int SimonScore = 0;
    private static int MemoryScore = 0;
    private static int TriviaScore = 0;
    private static int IsekaiScore = 0;
    private static int DumbScore = 0;

    public static int getSimonScore() {
        return SimonScore;
    }

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
}
