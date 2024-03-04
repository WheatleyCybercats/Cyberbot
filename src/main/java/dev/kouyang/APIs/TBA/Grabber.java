package dev.kouyang.APIs.TBA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Grabber {



    public static String json(String endPoint) throws IOException {
        String urlString = Constant.TBAAPIBase + endPoint + "?X-TBA-Auth-Key=" + Constant.API_KEY;
        //System.out.println(urlString);
        URL url = new URL(urlString);

        // Open connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set request method
        connection.setRequestMethod("GET");

        StringBuilder response;

        // Get input stream and read response
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } finally {
            // Disconnect the connection
            connection.disconnect();
        }

        return response.toString();
    }
}