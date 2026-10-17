package br.edu.uepg.editora.repository;

import br.edu.uepg.editora.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByEmail(String email);

    boolean existsByEmail(String email);
}
