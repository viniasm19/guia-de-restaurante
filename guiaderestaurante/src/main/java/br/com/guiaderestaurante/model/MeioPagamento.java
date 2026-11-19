package br.com.guiaderestaurante.model;

public enum MeioPagamento { DEBITO("Débito"), CREDITO("Crédito"),
    PIX("PIX"), VOUCHER("Voucher"), DINHEIRO("Dinheiro");

    public String descricao;

    MeioPagamento(String descricao){
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
