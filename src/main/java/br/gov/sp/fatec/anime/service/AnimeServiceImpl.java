package br.gov.sp.fatec.anime.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.anime.entity.Anime;
import br.gov.sp.fatec.anime.entity.Usuario;
import br.gov.sp.fatec.anime.repository.AnimeRepository;
import br.gov.sp.fatec.anime.repository.UsuarioRepository;

@Service("animeService")
public class AnimeServiceImpl implements AnimeService {


    @Autowired
    private AnimeRepository animeRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Override
    @Transactional
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public Anime adicionarAnime(String identificadorUsuario, String animeNome, 
            String animeChar) {
        Usuario usuario = usuarioRepo.findTop1ByNomeOrEmail(
                identificadorUsuario, identificadorUsuario);
        if (usuario == null) {
            throw new UsernameNotFoundException(
                    "Usuário com identificador "+ 
                    identificadorUsuario +
                    " não foi encontrado");
        }

        Anime anime = new Anime();
        anime.setAnimeNome(animeNome);
        anime.setAnimePersonagem(animeChar);
        anime.setCharUsr(usuario);
        anime.setAnimeAno(new Date());
        animeRepo.save(anime);
        return anime;
    }

}