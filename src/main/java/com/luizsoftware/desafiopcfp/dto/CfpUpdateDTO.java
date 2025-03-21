package com.luizsoftware.desafiopcfp.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CfpUpdateDTO(
        @NotNull
        Long id,
        String title,
        String summary,
        String author,
        String email,
        LocalDateTime date
) {
}
