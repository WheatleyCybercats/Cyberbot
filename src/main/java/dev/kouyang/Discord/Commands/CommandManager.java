package dev.kouyang.Discord.Commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.kouyang.Data.Database;
import dev.kouyang.Data.PitForm;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;

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
        }else if (event.getName().equals("TenTeams")) {
            TeamCommand teamCommand = new TeamCommand(event.getOption("number"));
            event.event.replyModal(FormCommand.pitForm()).queue();
        }
        System.currentTimeMillis();
    }

    @Override
    public void onModalInteraction(@NotNull ModalInteractionEvent event){

        TextInput otherT = TextInput.create("other", "other opinions / what you think of the bot", TextInputStyle.PARAGRAPH)
                .setPlaceholder("although it's not a good scoring bot but they seem to be a good fit for us")
                .build();




        if (event.getModalId().equals("pit")) {

            String team = event.getValue("team").getAsString();
            String region = event.getValue("region").getAsString();
            String auto = event.getValue("auto").getAsString();
            String scoring = event.getValue("scoring").getAsString();
            String other = event.getValue("other").getAsString();

            PitForm pf = new PitForm(team, region, auto, scoring, other);

            Database.pitForms.add(pf);
            CommandsUtil.toJson();

            event.reply("Thanks for your request!").setEphemeral(true).queue();

        }
    }
}
