package daviClimaco.gerenciamentoAutores.services;

import daviClimaco.gerenciamentoAutores.entity.Autor;
import daviClimaco.gerenciamentoAutores.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServices {
    private AutorRepository autorRepository;

    public AutorServices(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor salvar(Autor autor){
        return autorRepository.save(autor);
    }

    public void deletar(Long id) {
        autorRepository.deleteById(id);
    }

    public Autor buscarAutorPorId(Long id){
        return autorRepository.findById(id).orElse(null);
    }

    public List<Autor> buscarTodosAutores(){
        return autorRepository.findAll();
    }

    public Autor atualizar(Long id, Autor autor){
        autor.setId(id);
        return autorRepository.save(autor);
    }

}