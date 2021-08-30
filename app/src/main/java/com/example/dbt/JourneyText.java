package com.example.dbt;

public class JourneyText {
    public String name;

    public String toString(){
        return "Welcome " + this.name + ", A powerful demon lord has taken over our lands. Brave Hero will you defeat the demon lord and save us from his reign?";
    }

    public String playerName(){
        return this.name;
    }

}
