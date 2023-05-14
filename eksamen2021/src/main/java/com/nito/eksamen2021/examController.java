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
    private Logger log = LoggerFactory.getLogger(examController.class); //logger, dene
    private JdbcTemplate db; //legger til i databasen
    @GetMapping("/lagre")
    public void lagre(Pakke nyPakke, String telefonnr){
        try{
            String sql = "select count(*) from Kunde where telefonnr = ?";
            int finnes = db.queryForObject(sql, Integer.class,telefonnr); //jeg gjorde en liten feil med bruk av denne under kurset, fikset nå slik at det er riktig ift eksamen
            if (finnes > 1) { //sjekker om det er ingen kunder eller ikke (mindre enn 1)
                System.out.println("pakken lagres ikke, brukeren eksister ikke "); //printer ut i konsollen
                log.error("feil i lagring av pakke"); //logger feilmeldingnen
            } else {
                try{
                    String sql2 = "insert into Pakke(KId, Volum, Vekt) values(?,?,?)"; //standard sql
                    db.update(sql2, nyPakke.getKid(), nyPakke.getVolum(), nyPakke.getVekt()); //denne lagrer med sql setningen i database
                }catch (Exception e){
                    log.error("feil i lagring av kunden"  + e);
                }
            }
        } catch (Exception e){
            log.error("feil i lagring " + e);
        }
    }
    public boolean vailderkunde(Kunde kunde){
        String regxepNavn = "[a-zæøåA-ZÆØÅ. \\-]{2,50}"; //regexp for fornavn
        String regexpadresse = "[a-zæøåA-ZÆØÅ. \\-]{2,46}[0-9]{0,3}"; //regexp for adresse
        String regexpPostnr =  "[0-9] {4}"; //regexp for postnr


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

        List<Poststed>poststeder = db.query(sql,  new BeanPropertyRowMapper<>(Poststed.class)); //lagrer alle postnr i en arraylist
        for (Poststed  p : poststeder){ //itererer gjennom hele
            if (pstnr.equals(p.getSted())){ //equals siden det er null safe
                System.out.println("Postnummeret eksister og hører til " + p.getSted());  //hvis postnummeret eksisterer og hører til et sted
                return true;
            }
            else {
                log.error("postestedet fantes ikke"); //postnummeret finnes ikke
                return false;
            }
        }
    return false;
    }
}
