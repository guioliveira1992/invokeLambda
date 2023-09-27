package com.example.invokeLambda.controller;

import com.example.invokeLambda.service.InvokeLambdaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/invoke")
public class InvokeController {

    private final InvokeLambdaService service;


    @GetMapping("/test")
    public ResponseEntity<String> doInvokeLambda(){

        return ResponseEntity.ok(service.invoke());
    }
}
