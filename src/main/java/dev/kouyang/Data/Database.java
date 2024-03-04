package dev.kouyang.Data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.kouyang.Data.Types.Team;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Database {
    public static ArrayList<PitForm> pitForms = new ArrayList<>();
    public static HashMap<String, PitForm> pitFormHashMap = new HashMap<>();
    public static ArrayList<Team> teams = new ArrayList<>();

    public static void readIn(){
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("info.txt"))) {
            String line;
            // Read each line from the file until the end is reached
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            // Parse the JSON string into an ArrayList of PitForm objects
            pitForms = mapper.readValue(sb.toString(), new TypeReference<ArrayList<PitForm>>(){});

            // Example: Print out the parsed objects
            for (PitForm form : pitForms) {
                System.out.println("Parsed Team: " + form.getTeamNumber());
                // Print other properties as needed
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        parseHashMap();
    }

    public static void save() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("info.txt"));
            ObjectMapper mapper = new ObjectMapper();
            bw.write(mapper.writeValueAsString(Database.pitForms));
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void parseHashMap(){
        for (PitForm pitForm : pitForms) {
            pitFormHashMap.put(pitForm.getTeamNumber(), pitForm);
        }
    }

}
