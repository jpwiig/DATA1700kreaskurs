package com.nito.eksamen2021;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class examController {
    private Logger log = LoggerFactory.getLogger(examController.class);
    private JdbcTemplate db;
    @GetMapping("/lagre")
    public void lagre(Pakke nyPakke, String telefonnr){
        try{
            String sql = "select count(*) from Kunde where telefonnr = ?";
            int finnes = db.queryForObject(sql, telefonnr, new BeanPropertyRowMapper<T>(Pakke.class));
            if (finnes > 1) {
                System.out.println("pakken lagres ikke, brukeren eksister ikke ");
                log.error("feil i lagring av pakke");
            } else {
                try{
                    String sql2 = "insert into Pakke(KId, Volum, Vekt) values(?,?,?)";
                    db.update(sql2, nyPakke.getKid(), nyPakke.getVolum(), nyPakke.getVekt());
                }catch (Exception e){
                    log.error("feil i lagring av kunden"  + e);
                }
            }
        } catch (Exception e){
            log.error("feil i lagring " + e);
        }
    }
    public boolean vailderkunde(Kunde kunde){
        String regxepNavn = "[a-zæøåA-ZÆØÅ. \\-]{2,50}";
        String regexpadresse = "[a-zæøåA-ZÆØÅ. \\-]{2,46}[0-9]{0,3}";
        String regexpPostnr =  "[0-9] {4}";


        if (kunde.getFornavn().matches(regxepNavn) && kunde.getEtternavn().matches(regxepNavn) && kunde.getAdresse().matches(regexpadresse) && kunde.getPostnr().matches(regexpPostnr)){
            return true;
        } else {
            if (!kunde.getFornavn().matches(regxepNavn)){
                log.error("feil i navn regexp");
            }
            log.error("feil i rexep");
            return false;
        }
    }

    @GetMapping("/sjekkPostnr")
    public boolean gyldigpostnr(String pstnr){
        String sql = "Select * from Poststed";

        List<Poststed>poststeder = db.query(sql,  new BeanPropertyRowMapper<>(Poststed.class));
        for (Poststed  p : poststeder){
            if (pstnr.equals(p.getSted())){
                System.out.println("Postnummeret eksister og hører til " + p.getSted());
                return true;
            }
            else {
                log.error("postestedet fantes ikke");
                return false;
            }
        }
    return false;
    }
}
