package br.com.guiaderestaurante.model;

import jakarta.persistence.*;
import lombok.Data;
import org.yaml.snakeyaml.events.Event;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "restaurante")
    private List<Avaliacao> avaliacoes;
    private String imagem;
    @ManyToMany
    private List<Categoria> categorias;
    private String horario;
    private String cep;
    private int numero;
    private String sobre;
    private String[] fotos;
    private String[] destaques;
    private MeioPagamento[] meiosPagamento;
    private boolean estacionamento;
    private boolean reserva;
    private boolean delivery;
    private boolean taxaServico;
    private LocalDate fundacao;
    private double taxaEntrega;
    private boolean musicaAoVivo;
    @OneToMany(mappedBy = "restaurante")
    private List<Prato> pratos;
    @OneToMany(mappedBy = "restaurante")
    private List<Faq> faqs;

    public double getMedia(){
        return 0;
    }
}
