package br.ufmt.alg3;

import br.ufmt.alg3.Categoria;
import br.ufmt.alg3.CategoriaDAO;
/**
 * Aplicação principal para gerenciar categorias, clientes, produtos, vendas e itens de venda.
 */
public final class App {
    private App() {
    }

    /**
     * Método principal da aplicação.
     * @param args Os argumentos do programa.
     */
    public static void main(String[] args) {
        // Criar e inserir uma nova Categoria
        Categoria categoria = new Categoria();
        categoria.setNome("Eletrônicos");
        
        CategoriaDao categoriaDAO = new CategoriaDao();
        categoriaDAO.inserir(categoria);

        // Criar e inserir um novo Cliente
        Cliente cliente = new Cliente();
        cliente.setCpf("12345678901");
        cliente.setNome("João Silva");
        cliente.setTelefone("11987654321");
        
        ClienteDao clienteDAO = new ClienteDao();
        clienteDAO.inserir(cliente);

        // Criar e inserir um novo Produto
        Produto produto = new Produto();
        produto.setValorProduto(1500.00f);
        produto.setIdCategoria(categoria.getIdCategoria()); // Supondo que você já tenha o ID da categoria inserido
        produto.setDescricao("Smartphone XYZ");
        
        ProdutoDao  produtoDAO = new  ProdutoDao ();
        produtoDAO.inserir(produto);

        // Criar e inserir uma nova Venda
        Venda venda = new Venda();
        venda.setIdCliente(cliente.getIdCliente()); // Supondo que você já tenha o ID do cliente inserido
        venda.setValorTotal(1500.00f);
        venda.setDataVenda(new java.sql.Date(System.currentTimeMillis())); // Data atual
        
        VendaDao vendaDAO = new VendaDao();
        vendaDAO.inserir(venda);

        // Criar e inserir um ItemVenda
        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setIdVenda(venda.getIdVenda()); // Supondo que você já tenha o ID da venda inserido
        itemVenda.setIdProduto(produto.getIdProduto()); // Supondo que você já tenha o ID do produto inserido
        itemVenda.setQuantidade(1);
        itemVenda.setValorProduto(produto.getValorProduto());
        
        ItemVendaDao itemVendaDAO = new ItemVendaDao();
        itemVendaDAO.inserir(itemVenda);

        // Exemplo de remoção
        categoriaDAO.remover(categoria.getIdCategoria());
        clienteDAO.remover(cliente.getIdCliente());
        produtoDAO.remover(produto.getIdProduto());
        vendaDAO.remover(venda.getIdVenda());
        itemVendaDAO.remover(itemVenda.getIdItem());
    }
}
