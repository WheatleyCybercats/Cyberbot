package dev.kouyang.Discord.Commands;

import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class PingCommand {
    OptionMapping optionMapping;
    public PingCommand(OptionMapping optionMapping){
        this.optionMapping = optionMappingg;
    }

    public String getResult(){
        return optionMapping.getAsString();
    }
}
