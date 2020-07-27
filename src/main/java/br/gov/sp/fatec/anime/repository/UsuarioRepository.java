package br.gov.sp.fatec.anime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.anime.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Usuario findTop1ByNomeOrEmail (String nome, String email);
}
