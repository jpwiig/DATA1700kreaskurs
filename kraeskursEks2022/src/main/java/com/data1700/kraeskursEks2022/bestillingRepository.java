package com.data1700.kraeskursEks2022;

import com.data1700.kraeskursEks2022.pojo.bestilling;
import com.data1700.kraeskursEks2022.pojo.kunde;
import com.data1700.kraeskursEks2022.pojo.vare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
*
*  NOTE: This is with using ORM, we will do live coding with the jdbc :)
 */

//just the different interfaces
@Repository
public interface bestillingRepository extends JpaRepository<bestilling, Integer>{
}
@Repository
interface Kunderepository extends JpaRepository<kunde, Integer>{

int countbymail(String mail);
    @Query("select k from kunde k where k.mail = ?1")
    List<kunde> findbyMail(String mail);

    boolean existsById(int id);
}
@Repository
interface vareRepository extends JpaRepository<vare, Integer>{

}