package dev.kouyang.Discord.Commands;

import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;

public class FormCommand {

    public static Modal pitForm(){


        TextInput team = TextInput.create("team", "Team", TextInputStyle.SHORT)
                .setPlaceholder("Team Number/ Team name")
                .setMinLength(4)
                .setMaxLength(20) // or setRequiredRange(10, 100)
                .build();




        TextInput region = TextInput.create("region", "Region - Smoky/Hofstra", TextInputStyle.SHORT)
                .setPlaceholder("Smoky")
                .setMinLength(1)
                .setMaxLength(100)
                .build();

        TextInput auto = TextInput.create("auto", "how many note auto/ if they are consistent", TextInputStyle.SHORT)
                .setPlaceholder("they have 4 note auto but not very consistent")
                .setMinLength(1)
                .setMaxLength(10)
                .build();
        TextInput scoring = TextInput.create("scoring", "do they score / seem likely to score speaker", TextInputStyle.PARAGRAPH)
                .setPlaceholder("they don't seem like to be able to score speaker ")
                .setMinLength(1)
                .setMaxLength(100)
                .build();

        TextInput other = TextInput.create("other", "other opinions / what you think of the bot", TextInputStyle.PARAGRAPH)
                .setPlaceholder("although it's not a good scoring bot but they seem to be a good fit for us")
                .setMinLength(10)
                .setMaxLength(100)
                .build();




        Modal pit = Modal.create("pit", "Pit Scouting Form")
                .addComponents(ActionRow.of(team) , ActionRow.of(region), ActionRow.of(scoring) ,ActionRow.of(auto), ActionRow.of(other))
                .build();

        return pit;
    }

}
