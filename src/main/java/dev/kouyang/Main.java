package dev.kouyang;

import dev.kouyang.APIs.API;
import dev.kouyang.APIs.Statbotics.StatAPI;
import dev.kouyang.APIs.TBA.TBAapi;
import dev.kouyang.Data.Database;

import javax.xml.crypto.Data;

import static dev.kouyang.Discord.Bot.initBot;

public class Main {

    public static void main(String[] args){
        Database.readIn();
        initBot();
    }

}
