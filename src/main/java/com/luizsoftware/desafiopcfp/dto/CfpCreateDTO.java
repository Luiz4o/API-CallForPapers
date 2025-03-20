package com.luizsoftware.desafiopcfp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CfpCreateDTO(
        @NotBlank
        String title,
        @NotBlank
        String summary,
        @NotBlank
        String author,
        @Email
        @NotBlank
        String email
) {
}
