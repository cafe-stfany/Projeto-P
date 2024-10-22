package br.ufmt.alg3;

import br.ufmt.alg3.CategoriaDao;
import br.ufmt.alg3.ProdutoDao;
import br.ufmt.alg3.ItemVendaDao;
import br.ufmt.alg3.VendaDao;
import br.ufmt.alg3.ClienteDao;
import br.ufmt.alg3.Categoria;
import br.ufmt.alg3.Produto;
import br.ufmt.alg3.Cliente;
import br.ufmt.alg3.ItemVenda;
import br.ufmt.alg3.Venda;

public final class App {
    private App() {
    }

    /**
     * Método principal da aplicação.
     * @param args Os argumentos do programa.
     */
    public static void main(String[] args) {
        
        Categoria categoria = new Categoria();
        categoria.setNome("Eletrônicos");
        
        CategoriaDao categoriaDAO = new CategoriaDao();
        categoriaDAO.inserir(categoria);

       
        Cliente cliente = new Cliente();
        cliente.setCpf("12345678901");
        cliente.setNome("João Silva");
        cliente.setTelefone("11987654321");
        
        ClienteDao clienteDAO = new ClienteDao();
        clienteDAO.inserir(cliente);

        
        Produto produto = new Produto();
        produto.setValorProduto(1500.00f);
        produto.setIdCategoria(categoria.getIdCategoria()); 
        produto.setDescricao("Smartphone XYZ");
        
        ProdutoDao  produtoDAO = new  ProdutoDao ();
        produtoDAO.inserir(produto);

        
        Venda venda = new Venda();
        venda.setIdCliente(cliente.getIdCliente()); 
        venda.setValorTotal(1500.00f);
        venda.setDataVenda(new java.sql.Date(System.currentTimeMillis())); 
        
        VendaDao vendaDAO = new VendaDao();
        vendaDAO.inserir(venda);

        
        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setIdVenda(venda.getIdVenda()); 
        itemVenda.setIdProduto(produto.getIdProduto()); 
        itemVenda.setQuantidade(1);
        itemVenda.setValorProduto(produto.getValorProduto());
        
        ItemVendaDao itemVendaDAO = new ItemVendaDao();
        itemVendaDAO.inserir(itemVenda);

        
        categoriaDAO.remover(categoria.getIdCategoria());
        clienteDAO.remover(cliente.getIdCliente());
        produtoDAO.remover(produto.getIdProduto());
        vendaDAO.remover(venda.getIdVenda());
        itemVendaDAO.remover(itemVenda.getIdItem());
    }
}
