package com.luizsoftware.desafiopcfp.repository;

import com.luizsoftware.desafiopcfp.model.Cfp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CfpRepository extends JpaRepository<Cfp,Long> {
}
