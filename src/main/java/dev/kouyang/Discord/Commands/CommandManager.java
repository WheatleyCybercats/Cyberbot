package dev.kouyang.Discord.Commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.kouyang.Data.Database;
import dev.kouyang.Data.PitForm;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.components.selections.SelectOption;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import org.jetbrains.annotations.NotNull;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class CommandManager extends ListenerAdapter {
    PitForm pf;

    ListTeamCommand LTC = new ListTeamCommand();
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("teams")) {
            TeamCommand teamCommand = new TeamCommand(event.getOption("number"));
            event.reply(teamCommand.getResult()).queue();
        }else if (event.getName().equals("scoutpit")) {
            String url = "null";
            if (!event.getOptions().isEmpty() && event.getOptions().getLast().getType().equals(OptionType.ATTACHMENT)) {
                url = event.getOptions().getLast().getAsAttachment().getProxyUrl();
            } else {
                System.out.println("No attachment found or the first option is not an attachment.");
            }
            pf = new PitForm(Objects.requireNonNull(event.getOption("number")).getAsString(), url);
            event.replyModal(FormCommand.pitForm()).queue();
        }else if(event.getName().equals("scouted")){
            event.reply(LTC.scouted()).queue();
        }else if(event.getName().equals("needscout")){
            event.reply("Choose the event").addActionRow(
                    StringSelectMenu.create("choose-event").addOptions(SelectOption.of("Smoky Mountain", "2024tktn")).build()).queue();
            //event.reply(LTC.notScouted(event.getOption("string").getAsString())).queue();
        }
        System.currentTimeMillis();
    }

    @Override
    public void onModalInteraction(@NotNull ModalInteractionEvent event){

            String region = event.getValue("region").getAsString();
            String robot = event.getValue("robot").getAsString();
            String auto = event.getValue("auto").getAsString();
            String scoring = event.getValue("scoring").getAsString();
            String other = event.getValue("other").getAsString();

            pf.setRegion(region);
            pf.setRobot(robot);
            pf.setAuto(auto);
            pf.setScoring(scoring);
            pf.setOther(other);

            Database.pitForms.add(pf);
            Database.save();

            event.reply("Thanks for your request!").setEphemeral(true).queue();

    }

    @Override
    public void onStringSelectInteraction(@NotNull StringSelectInteractionEvent event){
        if(event.getComponentId().equals("choose-event")){
            event.reply("You chose " + event.getValues().getFirst()).queue();
        }
    }
}
