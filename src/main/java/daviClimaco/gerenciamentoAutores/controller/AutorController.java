package daviClimaco.gerenciamentoAutores.controller;

import daviClimaco.gerenciamentoAutores.entity.Autor;
import daviClimaco.gerenciamentoAutores.services.AutorServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("autor")
public class AutorController {
    private AutorServices autorService;

    public AutorController(AutorServices autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public ResponseEntity<Autor> salvar(@RequestBody Autor autor){ //requestbody recebe o json e transforma em objeto
        Autor requeste = autorService.salvar(autor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(autor.getId())
                .toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping ("{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        autorService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Autor>> buscarTodos(){
        List<Autor> requeste = autorService.buscarTodosAutores(); //reotrna a lista de objetos java
        return ResponseEntity.ok().body(requeste);
    }

    @GetMapping("{id}")
    public Autor buscarPorId(@PathVariable Long id){
        return autorService.buscarAutorPorId(id); //retorna o objeto pelo id
    }

    @PutMapping("{id}")
    public Autor atualizar(@PathVariable Long id, @RequestBody Autor autor){
        return autorService.atualizar(id, autor);
    }

}