package dev.kouyang.Discord.Commands;

import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.exceptions.ContextException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLOutput;

public class CommandManager extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("ping")) {
            PingCommand pingCommand = new PingCommand(event.getOption("string"));
            event.reply(pingCommand.getResult()).queue();
        }else if (event.getName().equals("teams")) {
            TeamCommand teamCommand = new TeamCommand(event.getOption("number"));
            event.reply(teamCommand.getResult()).queue();
        }else if (event.getName().equals("form")) {
            event.replyModal(FormCommand.pitForm()).queue();
        }
        System.currentTimeMillis();
    }

    @Override
    public void onModalInteraction(@NotNull ModalInteractionEvent event){
        if (event.getModalId().equals("pit")) {
            String team = event.getValue("team").getAsString();
            String rating = event.getValue("rating").getAsString();
            String region = event.getValue("region").getAsString();
            System.out.println(team);
            System.out.println(rating);
            System.out.println(region);

            event.reply("Thanks for your request!").setEphemeral(true).queue();
        }
    }
}
