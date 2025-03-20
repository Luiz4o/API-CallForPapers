package com.luizsoftware.desafiopcfp.model;

import com.luizsoftware.desafiopcfp.dto.CfpCreateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "cfps")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cfp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String summary;
    private String author;
    private String email;

    private LocalDateTime date;

    public Cfp(CfpCreateDTO data, LocalDateTime date){
        title = data.title();
        summary = data.summary();
        author = data.author();
        email = data.email();
        this.date = date;
    }


}
