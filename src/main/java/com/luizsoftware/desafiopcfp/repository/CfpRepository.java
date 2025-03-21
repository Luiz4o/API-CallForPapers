package com.luizsoftware.desafiopcfp.repository;

import com.luizsoftware.desafiopcfp.model.Cfp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CfpRepository extends JpaRepository<Cfp,Long> {
    Page<Cfp> findAllByActiveTrue(Pageable page);

    Optional<Cfp> findByActiveTrueAndId(Long id);
}
