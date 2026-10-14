package dw.editora.service.artigo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dw.editora.model.artigo.Artigo;
import dw.editora.model.autor.Autor;
import dw.editora.repository.artigo.ArtigoRepository;
import jakarta.persistence.EntityManager;

@Service
public class ArtigoService {

    private final ArtigoRepository artigoRepository;
    private final EntityManager entityManager;

    public ArtigoService(ArtigoRepository artigoRepository, EntityManager entityManager) {
        this.artigoRepository = artigoRepository;
        this.entityManager = entityManager;
    }

    public Optional<Artigo> criar(Artigo entrada) {
        if (entrada.getAutor() == null) {
            return Optional.empty();
        }

        Autor autor = entityManager.find(Autor.class, entrada.getAutor().getId());
        if (autor == null) {
            return Optional.empty();
        }

        Artigo artigo = new Artigo(entrada.getTitulo(), entrada.getResumo(), entrada.isPublicado(), autor);
        return Optional.of(artigoRepository.save(artigo));
    }

    public Optional<List<Artigo>> listarPorAutor(long autorId) {
        Autor autor = entityManager.find(Autor.class, autorId);
        if (autor == null) {
            return Optional.empty();
        }

        return Optional.of(artigoRepository.findByAutorId(autorId));
    }
}
