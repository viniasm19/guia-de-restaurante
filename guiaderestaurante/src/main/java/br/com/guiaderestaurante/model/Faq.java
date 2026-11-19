package br.com.guiaderestaurante.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Faq {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pergunta;
    private String resposta;
    @ManyToOne
    private Restaurante restaurante;
}
