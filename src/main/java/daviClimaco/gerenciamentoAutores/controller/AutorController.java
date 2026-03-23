package daviClimaco.gerenciamentoAutores.controller;

import daviClimaco.gerenciamentoAutores.entity.Autor;
import daviClimaco.gerenciamentoAutores.services.AutorServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("autor")
public class AutorController {
    private AutorServices autorService;

    public AutorController(AutorServices autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public void salvar(@RequestBody Autor autor){ //requestbody recebe o json e transforma em objeto
        autorService.salvar(autor);
    }

    @DeleteMapping ("{id}")
    public void deletar(@PathVariable Long id) {
        autorService.deletar(id);
    }

    @GetMapping
    public List<Autor> buscarTodos(){
        return autorService.buscarTodosAutores(); //reotrna a lista de objetos java
    }

    @GetMapping("{id}")
    public Autor buscarPorId(@PathVariable Long id){
        return autorService.buscarAutorPorId(id); //retorna o objeto pelo id
    }

}