package com.data1700.kraeskursEks2022;

import com.data1700.kraeskursEks2022.pojo.bestilling;
import com.data1700.kraeskursEks2022.pojo.kunde;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@RestController("/exam2022")
public class exam2022Controller {

    private Logger log = LoggerFactory.getLogger(exam2022Controller.class);
    private HttpSession session;
    //rep 1: bestilling table rep2: kunde rep3: vare
    @Autowired
    bestillingRepository rep;

    @Autowired
    Kunderepository rep2;

    @Autowired
    vareRepository rep3;

    @Autowired
    EntityManager entityManager;
    //oppgave1
    @GetMapping("/sjekk")
    public String check() {
        return "ok";
    }

    //without transactional
    @PostMapping("/bestill")
    public void order(bestilling aorder, HttpServletResponse respone) throws IOException {
        try {
            rep.save(aorder);
        } catch (Exception e) {
            log.error("feil i lagring av bestilling");
            respone.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i lagring av bestilling");
        }

    }

    @Transactional
    public void placeorder(bestilling order) {
    rep.findAll().add(order);
    //TODO: Closer look @ this
    entityManager.persist(rep2.findAllById(order.getKid()));

    }
    //TODO: Add a user to the database

    //TODO: log in to an existing user with sessions
    @PostMapping("/login")
    public void login(kunde user, HttpServletResponse respone) throws IOException{
        try {
                if (user.getMail() == rep2.findBy(user.getMail())) {
                    if (rep2.findBy(password) == user.getPassword()) {
                        session.setAttribute("user", user);
                    }
                }
        }
    }
    public String crypt(String pw) {
        return BCrypt.hashpw(pw, BCrypt.gensalt(14));
    }
}

