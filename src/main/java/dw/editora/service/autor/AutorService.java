package br.edu.uepg.editora.service;

import br.edu.uepg.editora.entity.Autor;
import br.edu.uepg.editora.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor salvar(Autor autor) {
        return autorRepository.save(autor);
    }

    public List<Autor> buscarTodos() {
        return autorRepository.findAll();
    }

    public Optional<Autor> buscarPorId(Long id) {
        return autorRepository.findById(id);
    }

    public void deletarPorId(Long id) {
        autorRepository.deleteById(id);
    }
}