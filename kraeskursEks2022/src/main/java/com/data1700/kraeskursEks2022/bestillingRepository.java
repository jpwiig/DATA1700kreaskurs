package com.data1700.kraeskursEks2022;

import com.data1700.kraeskursEks2022.pojo.bestilling;
import com.data1700.kraeskursEks2022.pojo.kunde;
import com.data1700.kraeskursEks2022.pojo.vare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
*
*  NOTE: This is with using ORM, we will do live coding with the jdbc :)
 */

//just the different interfaces
public interface bestillingRepository extends JpaRepository<bestilling, Integer>{
}
interface Kunderepository extends JpaRepository<kunde, Integer>{



}
interface vareRepository extends JpaRepository<vare, Integer>{

}