package com.paradigmbookstore.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSConfigure {
    public static final String REGION = "us-east-1";
    public static final String ACCESS_KEY = "AKDOALMQOPAOAASDF";
    public static final String SECRET_KEY = "aekpqmxO+wmnkIf2dgmsckjwnfuropwsdf";

    @Bean
    public AmazonS3 s3Client() {
        return AmazonS3ClientBuilder.standard()
                .withRegion(REGION)
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY)))
                .build();
    }
}
