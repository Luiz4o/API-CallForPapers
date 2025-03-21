package com.luizsoftware.desafiopcfp.dto;

import com.luizsoftware.desafiopcfp.model.Cfp;

import java.time.LocalDateTime;

public record CfpGetDTO(
        Long id,
        String title,
        String summary,
        String author,
        String email,
        LocalDateTime date
){
    public CfpGetDTO(Cfp cfp) {
        this(cfp.getId(), cfp.getTitle(), cfp.getSummary(), cfp.getAuthor(), cfp.getEmail(), cfp.getDate());
    }
}
