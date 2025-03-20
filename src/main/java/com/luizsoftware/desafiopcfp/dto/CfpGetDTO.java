package com.luizsoftware.desafiopcfp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
}
