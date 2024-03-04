package dev.kouyang.TBA;

import dev.kouyang.TBA.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import static java.net.http.HttpClient.newHttpClient;

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
