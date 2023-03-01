package com.atractor.com.firstAOP.controller;


import com.atractor.com.firstAOP.interceptor.TransactionAudith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class PruebasController {

    @TransactionAudith(topicEndpoint = "/mitopico/kafka")
    @GetMapping
    public ResponseEntity<String> getCadena(){

        return new ResponseEntity<>("HOLA MUNDO", HttpStatus.OK);
    }

}
