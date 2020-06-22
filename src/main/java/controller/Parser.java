package controller;

import model.User;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Parser {
    @RequestMapping("/getResult")
    public String parseData(){
        System.out.println("Parsing data ...");
        String url = "https://jsonplaceholder.typicode.com/users";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity< User[] > result = restTemplate.getForEntity(url,User[].class);

        return Arrays.asList(result.getBody()).stream().map(u -> u.toString()).collect(Collectors.joining("<br/>"));
    }
}
