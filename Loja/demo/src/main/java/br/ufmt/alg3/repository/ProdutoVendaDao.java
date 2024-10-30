package br.ufmt.alg3.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.ufmt.alg3.io.ProdutoVenda;
import br.ufmt.alg3.io.Produto;
import br.ufmt.alg3.io.Venda;
import static br.ufmt.alg3.utils.abreconexao.abreConexao;

public class ProdutoVendaDao {

    // Inserir ProdutoVenda
    public void inserir(ProdutoVenda item) {
        String sql = "INSERT INTO produto_venda (idVenda, idProduto, quantidade, precoUnitario) VALUES (?, ?, ?, ?);";
        try (Connection con = abreConexao(); 
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, item.getVenda().getId());
            ps.setInt(2, item.getProduto().getId());
            ps.setInt(3, item.getQuantidade());
            ps.setFloat(4, item.getPrecoUnitario());
            ps.executeUpdate();
            System.out.println("ProdutoVenda inserido com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Erro ao inserir ProdutoVenda!");
            erro.printStackTrace();
        }
    }

    // Atualizar ProdutoVenda
    public void atualizar(ProdutoVenda item) {
        String sql = "UPDATE produto_venda SET idVenda = ?, idProduto = ?, quantidade = ?, precoUnitario = ? WHERE id = ?;";
        try (Connection con = abreConexao(); 
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, item.getVenda().getId());
            ps.setInt(2, item.getProduto().getId());
            ps.setInt(3, item.getQuantidade());
            ps.setFloat(4, item.getPrecoUnitario());
            ps.setInt(5, item.getId());
            ps.executeUpdate();
            System.out.println("ProdutoVenda atualizado com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Erro ao atualizar ProdutoVenda!");
            erro.printStackTrace();
        }
    }

    // Remover ProdutoVenda pelo ID
    public void remover(int id) {
        String sql = "DELETE FROM produto_venda WHERE id = ?;";
        try (Connection con = abreConexao(); 
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("ProdutoVenda removido com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Erro ao remover ProdutoVenda!");
            erro.printStackTrace();
        }
    }

    // Listar todos os ProdutoVenda
    public List<ProdutoVenda> listar() {
        List<ProdutoVenda> itens = new ArrayList<>();
        String sql = "SELECT * FROM produto_venda;";
        try (Connection con = abreConexao(); 
             PreparedStatement ps = con.prepareStatement(sql); 
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ProdutoVenda item = new ProdutoVenda();
                item.setId(rs.getInt("id"));

                // Criando objetos Produto e Venda com base nos IDs
                Produto produto = new Produto();
                produto.setId(rs.getInt("idProduto"));
                item.setProduto(produto);

                Venda venda = new Venda();
                venda.setId(rs.getInt("idVenda"));
                item.setVenda(venda);

                item.setQuantidade(rs.getInt("quantidade"));
                item.setPrecoUnitario(rs.getFloat("precoUnitario"));
                itens.add(item);
            }
        } catch (SQLException erro) {
            System.out.println("Erro ao listar ProdutoVenda!");
            erro.printStackTrace();
        }
        return itens;
    }

    // Buscar ProdutoVenda pelo ID
    public ProdutoVenda buscar(int id) {
        String sql = "SELECT * FROM produto_venda WHERE id = ?;";
        ProdutoVenda item = null;

        try (Connection con = abreConexao(); 
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    item = new ProdutoVenda();
                    item.setId(rs.getInt("id"));

                    // Preenchendo Produto e Venda
                    Produto produto = new Produto();
                    produto.setId(rs.getInt("idProduto"));
                    item.setProduto(produto);

                    Venda venda = new Venda();
                    venda.setId(rs.getInt("idVenda"));
                    item.setVenda(venda);

                    item.setQuantidade(rs.getInt("quantidade"));
                    item.setPrecoUnitario(rs.getFloat("precoUnitario"));
                }
            }
        } catch (SQLException erro) {
            System.out.println("Erro ao buscar ProdutoVenda!");
            erro.printStackTrace();
        }
        return item;
    }
}
