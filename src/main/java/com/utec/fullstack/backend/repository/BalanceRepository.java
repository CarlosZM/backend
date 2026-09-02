package com.utec.fullstack.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends JpaRepository<BalanceEntity, Integer> {

    /**
     *
     Connection conn = new connection("postgres")

     List<Person> result = conn.execute("SELECT id,name,email,password,----, ----, ---- ,---  FROM PERSONAS;")

     return result

     */
}
