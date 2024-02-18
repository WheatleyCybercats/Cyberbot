package dev.kouyang;

import dev.kouyang.OpenAI.GPT.GPT;
import dev.kouyang.TBA.API;

import static dev.kouyang.Discord.Bot.initBot;

public class Main {

    public static API api;
    public static GPT gpt;

    public static void main(String[] args){
        initBot();
        api = new API();
        gpt = new GPT();
        Config.API_KEY = "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";

    }

}
