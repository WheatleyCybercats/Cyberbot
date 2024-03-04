package dev.kouyang;

import dev.kouyang.Statbotics.StatAPI;
import dev.kouyang.TBA.TBAapi;

public class Main {

    public static TBAapi TBAapi;

    public static void main(String[] args){
        //initBot();
        //api = new API();
        StatAPI stat = new StatAPI();
        stat.getTeam();
    }

}
