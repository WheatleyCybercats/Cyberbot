package dev.kouyang.Discord.Commands;

import dev.kouyang.Main;
import dev.kouyang.OpenAI.GPT.GPT;
import dev.kouyang.OpenAI.GPT.Model;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class ChatCommand {
    OptionMapping optionMapping;
    public ChatCommand(OptionMapping optionMapping){
        this.optionMapping = optionMapping;
    }

    public String getResult(){
        return Main.gpt.chat("Give a very short answer to" + optionMapping.getAsString(), Model.GPT_3_5_TURBO).getResponse();
    }
}
