package br.com.guiaderestaurante.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Prato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    private Categoria categoria;
    private String descricao;
    private boolean destaque;
    private String imagem;
    private double preco;
    @ManyToOne
    private Restaurante restaurante;
}
