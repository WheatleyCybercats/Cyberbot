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
        OptionData team = new OptionData(OptionType.INTEGER, "number", "Team number you want info.txt of");
        OptionData formImage = new OptionData(OptionType.ATTACHMENT, "image", "picture of the bot");
        OptionData formField = new OptionData(OptionType.INTEGER, "number", "Team Number", true);
        OptionData scoutInfo = new OptionData(OptionType.INTEGER, "number", "Team number of the team you want to query for", true);

        commandData.add(Commands.slash("teams","teams").addOptions(team));
        commandData.add(Commands.slash("scoutpit","Scout Pits").addOptions(formField).addOptions(formImage));
        commandData.add(Commands.slash("scoutinfo", "Teams that we scouted").addOptions(scoutInfo));
        commandData.add(Commands.slash("needscout", "Teams that we need to scout"));
        commandData.add(Commands.slash("matchscout", "Scout matches"));
        commandData.add(Commands.slash("listscouted", "list the teams that we scouted"));


        jda.updateCommands().addCommands(commandData).queue();
    }
}
