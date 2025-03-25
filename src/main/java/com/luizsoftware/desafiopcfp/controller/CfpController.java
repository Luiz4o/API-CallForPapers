package com.luizsoftware.desafiopcfp.controller;

import com.luizsoftware.desafiopcfp.dto.CfpCreateDTO;
import com.luizsoftware.desafiopcfp.dto.CfpGetDTO;
import com.luizsoftware.desafiopcfp.dto.CfpUpdateDTO;
import com.luizsoftware.desafiopcfp.model.Cfp;
import com.luizsoftware.desafiopcfp.repository.CfpRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Page<CfpGetDTO>> getAllProposal(@PageableDefault Pageable page){

        var cfps = repository.findAllByActiveTrue(page).map(CfpGetDTO :: new);

        return ResponseEntity.ok(cfps);
    }

    @GetMapping("/{id}")
    public ResponseEntity findProposal(@PathVariable Long id){
        var cfp = repository.findByActiveTrueAndId(id);

        if(cfp.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(new CfpGetDTO(cfp.get()));
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateProposal(@RequestBody @Valid CfpUpdateDTO data){
        var proposal = repository.getReferenceById(data.id());

        proposal.updateInfoProposal(data);

        return  ResponseEntity.ok(new CfpGetDTO(proposal));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteProposal(@PathVariable Long id) {
        var cfp = repository.getReferenceById(id);
        cfp.deleteProposal();

        return ResponseEntity.noContent().build();
    }

}
