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
        jda = JDABuilder.createDefault("MTIwNzQxNDYwMzM0NTMwNTY3MA.GNThei.RvYKl8ow2BsRd1HDz76bFcTY4afkwwWMq1eZFc")
                .setActivity(Activity.watching("Cybercats"))
                .addEventListeners(new CommandManager()).build();

        List<CommandData> commandData = new ArrayList<>();
        OptionData ping = new OptionData(OptionType.STRING, "string", "what u want to say");
        OptionData team = new OptionData(OptionType.INTEGER, "number", "Team number you want info of");
        OptionData form = new OptionData(OptionType.STRING, "string", "what do you want to scout");

        commandData.add(Commands.slash("ping", "Says back whatever").addOptions(ping));
        commandData.add(Commands.slash("teams","teams").addOptions(team));
        commandData.add(Commands.slash("form","give you answers").addOptions(form));

        jda.updateCommands().addCommands(commandData).queue();
    }
}
