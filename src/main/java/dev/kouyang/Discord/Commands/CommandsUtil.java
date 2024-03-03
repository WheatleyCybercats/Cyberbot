package dev.kouyang.Discord.Commands;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.kouyang.Data.Database;
import dev.kouyang.Data.PitForm;

import java.io.*;
import java.util.ArrayList;

public class CommandsUtil {
    public static void toJson() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("info.txt"));
            ObjectMapper mapper = new ObjectMapper();
            bw.write(mapper.writeValueAsString(Database.pitForms));
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void toObject() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Read the JSON array from the file and convert it into an ArrayList of PitForm objects
            Database.pitForms = mapper.readValue(new File("info.txt"), new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
