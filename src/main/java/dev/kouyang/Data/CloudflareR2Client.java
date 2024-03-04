package dev.kouyang.Data;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Object;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

public class CloudflareR2Client {

    private static final S3Client s3 = S3Client.builder()
            .region(Region.US_EAST_1) // Region doesn't matter for R2, but required by the SDK
            .endpointOverride(URI.create("https://2b7f66ed0076a0d5d8f15b83db3aa706.r2.cloudflarestorage.com"))
            .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("a757e7b62d5d61d88a1324e8ede59afa", "67dc56ec89e56e231861eede09ba9f9a5e9d2abe2bdcf1275bc251f685cb9e1b")))
            .build();

    public static void uploadJsonFile(String objectKey, String filePath) {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket("cyberbot")
                .key(objectKey)
                .contentType("application/json")
                .build();

        s3.putObject(putObjectRequest, RequestBody.fromFile(Paths.get(filePath)));
    }

    public static String readJsonFile(String objectKey) {
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket("cyberbot")
                .key(objectKey)
                .build();

        ResponseInputStream<GetObjectResponse> objectPortStream = s3.getObject(getObjectRequest);

        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(objectPortStream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle exceptions appropriately
        }

        return stringBuilder.toString();
    }

    public static void saveCloud(String objectKey){
        CloudflareR2Client r2Client = new CloudflareR2Client();
        r2Client.uploadJsonFile(objectKey, System.getProperty("user.home") + "/pit_data.json");

        System.out.println("File uploaded successfully to Cloudflare R2.");
    }
}
