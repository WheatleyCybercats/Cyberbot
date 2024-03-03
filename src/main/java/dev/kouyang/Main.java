package dev.kouyang;

import dev.kouyang.TBA.API;

import java.io.IOException;

import static dev.kouyang.Discord.Bot.initBot;

public class Main {

    public static API api;

    public static void main(String[] args) /*throws IOException*/ {
        initBot();
        api = new API();

    }

}
