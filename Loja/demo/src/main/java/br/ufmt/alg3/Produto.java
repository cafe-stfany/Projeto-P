package br.ufmt.alg3;

public class Produto {
    private int idProduto;
    private Float valorProduto;
    private String idCategoria;
    private String descricao;


    public int getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    public float getValorProduto() {
        return valorProduto;
    }
    public void setValorProduto(Float valorProduto) {
        this.valorProduto= valorProduto;
    }
    public String getIdCategoria() {
        return idCategoria;
    }
    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}