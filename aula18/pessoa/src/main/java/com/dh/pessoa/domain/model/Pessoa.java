package com.dh.pessoa.domain.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    public Pessoa(Long id, String name, String genre, String urlStream) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.urlStream = urlStream;
    }

    public Pessoa() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Basic(fetch = FetchType.LAZY)
    private String genre;

    @Basic (fetch = FetchType.LAZY)
    private String urlStream;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getUrlStream() {
        return urlStream;
    }

    public void setUrlStream(String urlStream) {
        this.urlStream = urlStream;
    }
}

