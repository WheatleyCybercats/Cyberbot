package dev.kouyang.Discord.Commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.exceptions.ContextException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class CommandManager extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("ping")) {
            PingCommand pingCommand = new PingCommand(event.getOption("string"));
            event.reply(pingCommand.getResult()).queue();
        }else if (event.getName().equals("teams")) {
            TeamCommand teamCommand = new TeamCommand(event.getOption("number"));
            event.reply(teamCommand.getResult()).queue();
        }else if(event.getName().equals("chat")){
            ChatCommand chatCommand = new ChatCommand(event.getOption("prompt"));
            event.reply(chatCommand.getResult()).queue();
        }
        System.currentTimeMillis();
    }
}
