package dev.kouyang.Discord;

import dev.kouyang.Discord.Commands.CommandManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.List;

public class Bot {

    public static JDA jda;

    public static void initBot(){
        jda = JDABuilder.createDefault("MTIwNzQxNDYwMzM0NTMwNTY3MA.G9PmVe.2MG_w4UVp9O0_WcavCyzhLjCzf3qjCViawrADI")
                .setActivity(Activity.watching("Cybercats"))
                .addEventListeners(new CommandManager()).build();

        List<CommandData> commandData = new ArrayList<>();
        OptionData ping = new OptionData(OptionType.STRING, "string", "what u want to say");
        OptionData team = new OptionData(OptionType.INTEGER, "number", "Team number you want info of");
        OptionData chat= new OptionData(OptionType.STRING, "prompt","What you want to ask");


        commandData.add(Commands.slash("ping", "Says back whatever").addOptions(ping));
        commandData.add(Commands.slash("teams","teams").addOptions(team));
        commandData.add(Commands.slash("chat","give you answers").addOptions(chat));

        jda.updateCommands().addCommands(commandData).queue();
    }
}
