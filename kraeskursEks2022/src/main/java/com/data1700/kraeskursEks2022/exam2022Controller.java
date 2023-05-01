package com.data1700.kraeskursEks2022;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class exam2022Controller {

    //oppgave1
    @GetMapping("/sjekk")
    public String check(){
        return "ok";
    }

}
