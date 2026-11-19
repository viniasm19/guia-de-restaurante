package br.com.guiaderestaurante.model;

public enum Nota {
    UMA_ESTRELA("Péssimo" ,1),
    DUAS_ESTRELAS("Ruim", 2),
    TRES_ESTRELAS("Regular",3),
    QUATRO_ESTRELAS("Bom",4),
    CINCO_ESTRELAS("Ótimo",5);

    public String texto;
    public int valor;

    Nota(String texto, int valor){
        this.texto = texto;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "texto='" + texto + '\'' +
                ", valor=" + valor +
                '}';
    }
}
