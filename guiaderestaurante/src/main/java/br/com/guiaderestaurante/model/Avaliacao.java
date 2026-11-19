package br.com.guiaderestaurante.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Nota nota;
    private LocalDate data;
    private String comentario;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Restaurante restaurante;
}
