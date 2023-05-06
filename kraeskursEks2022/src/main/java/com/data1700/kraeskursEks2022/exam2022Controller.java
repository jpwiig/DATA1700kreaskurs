package com.data1700.kraeskursEks2022;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class exam2022Controller {

    //rep 1: bestilling table rep2: kunde rep3: vare
    @Autowired
    bestillingRepository rep;

    @Autowired
    Kunderepository rep2;

    @Autowired
    vareRepository rep3;

    //oppgave1
    @GetMapping("/sjekk")
    public String check(){
        return "ok";
    }


}
