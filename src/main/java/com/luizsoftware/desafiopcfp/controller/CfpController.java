package com.luizsoftware.desafiopcfp.controller;

import com.luizsoftware.desafiopcfp.dto.CfpCreateDTO;
import com.luizsoftware.desafiopcfp.dto.CfpGetDTO;
import com.luizsoftware.desafiopcfp.model.Cfp;
import com.luizsoftware.desafiopcfp.repository.CfpRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("propostas")
public class CfpController {

    @Autowired
    private CfpRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity createProposal(@RequestBody @Valid CfpCreateDTO data){

        Cfp cfp = new Cfp(data, LocalDateTime.now());

        repository.save(cfp);

        return ResponseEntity.ok().body(cfp);
    }

    @GetMapping
    public ResponseEntity<Page<CfpGetDTO>> getAllProposal(@PageableDefault(size = 10) Pageable page){

        var cfps = repository.findAll(page).map(cfp -> new CfpGetDTO(
                cfp.getId(),
                cfp.getTitle(),
                cfp.getSummary(),
                cfp.getAuthor(),
                cfp.getEmail(),
                cfp.getDate()));

        return ResponseEntity.ok(cfps);
    }

}
