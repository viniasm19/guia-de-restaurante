package br.com.guiaderestaurante.controller;

import br.com.guiaderestaurante.model.Categoria;
import br.com.guiaderestaurante.model.Erro;
import br.com.guiaderestaurante.service.CategoriaService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    public final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;

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
