package br.gov.sp.fatec.anime.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.anime.controller.View;

@Entity
@Table(name = "anime_chars")
public class Anime {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name = "anm_id")
    @JsonView(View.AnimeCompleto.class)
    private Long id;

    @Column (name = "anm_char", length=100, nullable = false)
    @JsonView(View.AnimeResumo.class)
    private String animePersonagem;

    @Column (name = "anm_name", length=100, nullable = false)
    @JsonView(View.AnimeResumo.class)
    private String animeNome;

    @Column (name = "anm_ano", nullable = false)
    @JsonView(View.AnimeCompleto.class)
    private Date animeAno;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "anm_char_usr_id")
    @JsonView(View.AnimeCompleto.class)
    private Usuario charUsr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnimePersonagem() {
        return animePersonagem;
    }

    public void setAnimePersonagem(String animePersonagem) {
        this.animePersonagem = animePersonagem;
    }

    public String getAnimeNome() {
        return animeNome;
    }

    public void setAnimeNome(String animeNome) {
        this.animeNome = animeNome;
    }

    public Date getAnimeAno() {
        return animeAno;
    }

    public void setAnimeAno(Date animeAno) {
        this.animeAno = animeAno;
    }

	public Usuario getCharUsr() {
		return charUsr;
	}

	public void setCharUsr(Usuario charUsr) {
		this.charUsr = charUsr;
	}


}