package br.ufmt.alg3;

import br.ufmt.alg3.ProdutoDAO;
import br.ufmt.alg3.Produto;

public class Main {
   private Main(){

   }
    public static void main(String[] args) {
        Produto produtoDAO = new ProdutoDao();
    
            // Criando um novo produto e inserindo no banco
            Produto novoProduto = new Produto();
            novoProduto.setValorProduto(299.99f);
            novoProduto.setIdCategoria("1");  // Exemplo de categoria
            novoProduto.setDescricao("Teclado Mecânico");
    
            produtoDAO.inserir(novoProduto);
            System.out.println("Produto inserido com sucesso!");
    }
}