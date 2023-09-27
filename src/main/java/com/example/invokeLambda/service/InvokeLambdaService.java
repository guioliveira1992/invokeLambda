package com.example.invokeLambda.service;

import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class InvokeLambdaService {

    private final AWSLambda awsLambdaClient;

    @Value("${aws.function.lambda.test}")
    private String functionTestLambda;

    private ObjectMapper mapper;

    public String invoke() {
        String json = "{\"body\":\"{\\\"message\\\":\\\"AppJava invoking Lambda\\\"}\"}";

        InvokeResult result = awsLambdaClient.invoke(new InvokeRequest()
                .withFunctionName(functionTestLambda)
                .withPayload(json));

        return new String(result.getPayload().array(), StandardCharsets.UTF_8);

    }

}
