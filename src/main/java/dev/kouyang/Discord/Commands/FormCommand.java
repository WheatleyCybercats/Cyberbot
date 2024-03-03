package dev.kouyang.Discord.Commands;

import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;

public class FormCommand {

    public static Modal pitForm(){


        TextInput team = TextInput.create("team", "Team", TextInputStyle.SHORT)
                .setPlaceholder("Team Number/ Team name")
                .build();

        TextInput region = TextInput.create("region", "Region - Smoky/Hofstra", TextInputStyle.SHORT)
                .setPlaceholder("Smoky")
                .setMinLength(1)
                .setMaxLength(50)
                .build();

        TextInput auto = TextInput.create("auto", "how many note auto/ if they are consistent", TextInputStyle.SHORT)
                .setPlaceholder("they have 4 note auto but not very consistent")
                .build();
        TextInput scoring = TextInput.create("scoring", "Scoring Mechanism / Consistency / Endgame", TextInputStyle.PARAGRAPH)
                .setPlaceholder("they don't seem like to be able to score speaker")
                .setMinLength(1)
                .build();

        TextInput other = TextInput.create("other", "Opinions/Thoughts", TextInputStyle.PARAGRAPH)
                .setPlaceholder("although it's not a good scoring bot but they seem to be a good fit for us")
                .build();


        Modal pit = Modal.create("pit", "Pit Scouting Form")
                .addComponents(ActionRow.of(team) , ActionRow.of(region), ActionRow.of(scoring) ,ActionRow.of(auto), ActionRow.of(other))
                .build();


        return pit;
    }

}
