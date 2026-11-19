package br.com.guiaderestaurante.repository;

import br.com.guiaderestaurante.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
