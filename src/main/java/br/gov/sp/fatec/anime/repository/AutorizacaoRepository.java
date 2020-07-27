package br.gov.sp.fatec.anime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.anime.entity.Autorizacao;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long> {

    public Autorizacao findByNome(String nome);

}