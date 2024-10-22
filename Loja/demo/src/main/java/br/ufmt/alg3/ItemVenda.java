package br.ufmt.alg3;

public class ItemVenda {
    private int idItem;
    private int idVenda;
    private int idProduto;
    private int quantidade;
    private float valorProduto;

    // Getters e Setters
    public int getIdItem() {
        return idItem;
    }
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getIdVenda() {
        return idVenda;
    }
    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValorProduto() {
        return valorProduto;
    }
    public void setValorProduto(float valorProduto) {
        this.valorProduto = valorProduto;
    }
}

