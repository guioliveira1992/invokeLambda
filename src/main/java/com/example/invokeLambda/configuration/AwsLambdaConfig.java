package com.example.invokeLambda.configuration;

import com.amazonaws.auth.*;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsLambdaConfig {

    @Bean
    public AWSLambda awsLambdaClient() {
        return AWSLambdaClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://0.0.0.0:4566",
                        Regions.US_WEST_2.getName()))
                .withCredentials(new DefaultAWSCredentialsProviderChain()).build();
    }


}
