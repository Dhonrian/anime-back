package br.gov.sp.fatec.anime.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import br.gov.sp.fatec.anime.entity.Anime;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

	@PreAuthorize("isAuthenticated()")
    public List<Anime> findByCharUsrNomeOrCharUsrEmail (String nome, String email);

}
