package com.data1700.kraeskursEks2022;

import com.data1700.kraeskursEks2022.pojo.bestilling;
import com.data1700.kraeskursEks2022.pojo.kunde;
import org.springframework.data.jpa.repository.JpaRepository;

public interface serverRepository extends JpaRepository<bestilling, Integer>{
}
