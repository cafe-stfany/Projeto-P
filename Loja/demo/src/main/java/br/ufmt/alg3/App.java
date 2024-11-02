package br.ufmt.alg3;

import java.util.List;

import br.ufmt.alg3.io.Categoria;
import br.ufmt.alg3.io.Cliente;
import br.ufmt.alg3.io.Produto;
import br.ufmt.alg3.repository.ClienteDao;
import br.ufmt.alg3.repository.ProdutoDao;

public final class App {
    private App() {
    }

    /**
     * Método principal da aplicação.
     * @param args Os argumentos do programa.
     */
    public static void main(String[] args) {
 

            // Criação de um novo produto
        Produto produto = new Produto();
        produto.setNome("Camiseta Polo");
        produto.setDescricao("Camiseta Polo 100% algodão, disponível em várias cores.");
        produto.setPreco(49.90f);
        produto.setEstoque(100);
        produto.setIdCategoria(1); // Supondo que a categoria com id 1 exista

        // Instância do ProdutoDao
        ProdutoDao produtoDAO = new ProdutoDao();

        // Inserção do novo produto no banco de dados
        produtoDAO.inserir(produto);


    }
}
