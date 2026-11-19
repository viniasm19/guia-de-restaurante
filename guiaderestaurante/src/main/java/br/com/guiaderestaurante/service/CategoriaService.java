package br.com.guiaderestaurante.service;

import br.com.guiaderestaurante.model.Categoria;
import br.com.guiaderestaurante.repository.CategoriaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository){
        this.repository = repository;
    }

    public Categoria inserir(Categoria categoria){
        return repository.save(categoria);
    }


    public Categoria atualizar(Long id,Categoria categoria){
        categoria.setId(id);
        return repository.save(categoria);
    }


    public Categoria buscarPorId(Long id){
        return repository.findById(id).orElse(null);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }

    public Page<Categoria> listar(Pageable pageable){
        return repository.findAll(pageable);
    }
}
