
/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/
package org.example;

/* 
import com.example.s3.Handler;
import com.example.s3.util.MemoryLog4jAppender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
*/
import org.junit.jupiter.api.*;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3control.S3ControlClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HandlerTest {

    private static S3Client s3;
    private static S3Presigner presigner;
    private static S3ControlClient s3ControlClient;

    // Define the data members required for the tests.
    private static String bucketName = "bucket1685376732731";

    private static String images = "";
    private static String[] imageKeys;

    @BeforeAll
    public static void setUp() throws IOException {
        ProfileCredentialsProvider credentialsProvider = ProfileCredentialsProvider.create();
        s3 = S3Client.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(credentialsProvider)
                .build();

        presigner = S3Presigner.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(credentialsProvider)
                .build();

        s3ControlClient = S3ControlClient.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(credentialsProvider)
                .build();

        try (InputStream input = HandlerTest.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            prop.load(input);
            bucketName = prop.getProperty("bucketName");

            images = prop.getProperty("images");
            imageKeys = images.split("[,]", 0);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @Order(1)
    public void whenInitializingAWSS3Service_thenNotNull() {
        System.out.println("<<Test Init S3 start>>");
        assertNotNull(s3);
        System.out.println("<<Test Init S3 passed>>");
        System.out.println();
    }

    @Test
    @Order(3)
    public void deleteBucket() {
        System.out.println("<<Test deleteBucket start>>");
        Handler.deleteBucket(s3, bucketName);
        System.out.println("<<Test deleteBucket passed>>");
        System.out.println();
    }

    @Test
    @Order(2)
    public void createBucket() {
        System.out.println("<<Test createBucket start>>");
        Handler.createBucket(s3, bucketName);
        System.out.println("<<Test createBucket passed>>");
        System.out.println();
    }

}