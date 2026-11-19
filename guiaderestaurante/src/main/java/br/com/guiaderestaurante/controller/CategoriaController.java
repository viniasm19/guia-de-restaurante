package br.com.guiaderestaurante.controller;

import br.com.guiaderestaurante.model.Categoria;
import br.com.guiaderestaurante.model.Erro;
import br.com.guiaderestaurante.service.CategoriaService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    public final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<Categoria>> listar(@PageableDefault(page = 0, size = 5, sort = "nome", direction = Sort.Direction.ASC) Pageable pageable){
        Page<Categoria> page = service.listar(pageable);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @RequestBody Categoria categoria){
        Categoria atualizado = service.atualizar(id, categoria);
        return ResponseEntity.ok(atualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoria(@PathVariable Long id){
        Categoria categoria = service.buscarPorId(id);
        if(categoria != null){
            return ResponseEntity.ok(categoria);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Object> InserirCategoria(@RequestBody Categoria categoria){
        try {
            Categoria inserido = service.inserir(categoria);
            return ResponseEntity.created(URI.create("/categoria/"+inserido.getId())).body(inserido);
        } catch (DataIntegrityViolationException e){
            Erro erro = Erro.builder().status(HttpStatus.BAD_REQUEST).
                    mensagem("Possivel registro duplicado").exception(e.getClass().getName()).build();
            return new ResponseEntity(erro,erro.getStatus());
        }catch (Exception e) {
            Erro erro = Erro.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).
                    mensagem(e.getMessage()).exception(e.getClass().getName()).build();
            return new ResponseEntity<>(erro, erro.getStatus());
        }
    }
}
