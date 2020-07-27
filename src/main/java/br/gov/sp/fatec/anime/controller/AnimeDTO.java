package br.gov.sp.fatec.anime.controller;

public class AnimeDTO {

    private String usuario;

    private String animePersonagem;

    private String animeNome;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

}