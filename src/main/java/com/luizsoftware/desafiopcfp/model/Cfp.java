package com.luizsoftware.desafiopcfp.model;

import com.luizsoftware.desafiopcfp.dto.CfpCreateDTO;
import com.luizsoftware.desafiopcfp.dto.CfpUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "cfps")
public class Cfp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String summary;
    private String author;
    private String email;

    private LocalDateTime date;

    private boolean active;


    public Cfp(CfpCreateDTO data, LocalDateTime date){
        title = data.title();
        summary = data.summary();
        author = data.author();
        email = data.email();
        this.date = date;
        this.active = true;
    }


    public void updateInfoProposal(CfpUpdateDTO data) {
        if(data.title() != null){
            this.title = data.title();
        }
        if(data.summary() != null){
            this.summary = data.summary();
        }
        if(data.author() != null){
            this.author = data.author();
        }
        if(data.email() != null){
            this.email = data.email();
        }
    }

    public void deleteProposal() {
        this.active = false;
    }

    public Cfp(Long id, String title, String summary, String author, String email, LocalDateTime date, boolean active) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.author = author;
        this.email = email;
        this.date = date;
        this.active = active;
    }

    public Cfp() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
