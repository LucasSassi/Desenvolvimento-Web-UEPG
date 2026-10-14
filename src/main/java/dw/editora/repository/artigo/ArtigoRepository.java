package dw.editora.repository.artigo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dw.editora.model.artigo.Artigo;

public interface ArtigoRepository extends JpaRepository<Artigo, Long> {

    List<Artigo> findByPublicado(boolean publicado);

    List<Artigo> findByTituloContainingIgnoreCase(String titulo);

    List<Artigo> findByAutorId(long autorId);
}
