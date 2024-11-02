package br.ufmt.alg3.repository;

import static br.ufmt.alg3.utils.abreconexao.abreConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufmt.alg3.io.ProdutoVenda;

public class ProdutoVendaDao {

    
    public void inserir(ProdutoVenda produtoVenda) {
        String sql = "INSERT INTO produtovenda (idProduto, idVenda, quantidade, precoUnitario) VALUES (?, ?, ?, ?);";
        try (Connection con = abreConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, produtoVenda.getIdProduto());
            ps.setInt(2, produtoVenda.getIdVenda());
            ps.setInt(3, produtoVenda.getQuantidade());
            ps.setFloat(4, produtoVenda.getPrecoUnitario());

            ps.executeUpdate();
            System.out.println("ProdutoVenda inserido com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Erro ao inserir ProdutoVenda.");
            erro.printStackTrace();
        }
    }

    
    public void atualizar(ProdutoVenda produtoVenda) {
        String sql = "UPDATE produtovenda SET idProduto = ?, idVenda = ?, quantidade = ?, precoUnitario = ? WHERE id = ?;";
        try (Connection con = abreConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, produtoVenda.getIdProduto());
            ps.setInt(2, produtoVenda.getIdVenda());
            ps.setInt(3, produtoVenda.getQuantidade());
            ps.setFloat(4, produtoVenda.getPrecoUnitario());
            ps.setInt(5, produtoVenda.getId());

            ps.executeUpdate();
            System.out.println("ProdutoVenda atualizado com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Erro ao atualizar ProdutoVenda.");
            erro.printStackTrace();
        }
    }

    
    public void remover(int idProdutoVenda) {
        String sql = "DELETE FROM produtovenda WHERE id = ?;";
        try (Connection con = abreConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idProdutoVenda);
            ps.executeUpdate();
            System.out.println("ProdutoVenda removido com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Erro ao remover ProdutoVenda.");
            erro.printStackTrace();
        }
    }

    
    public List<ProdutoVenda> listar() {
        List<ProdutoVenda> produtosVenda = new ArrayList<>();
        String sql = "SELECT * FROM produtovenda;";
        try (Connection con = abreConexao();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ProdutoVenda produtoVenda = new ProdutoVenda();
                produtoVenda.setId(rs.getInt("id"));  
                produtoVenda.setIdProduto(rs.getInt("idProduto"));
                produtoVenda.setIdVenda(rs.getInt("idVenda"));
                produtoVenda.setQuantidade(rs.getInt("quantidade"));
                produtoVenda.setPrecoUnitario(rs.getFloat("precoUnitario"));

                produtosVenda.add(produtoVenda);
            }

        } catch (SQLException erro) {
            System.out.println("Erro ao listar ProdutosVenda.");
            erro.printStackTrace();
        }
        return produtosVenda;
    }

    
    public ProdutoVenda buscar(int idProdutoVenda) {
        String sql = "SELECT * FROM produtovenda WHERE id = ?;";
        ProdutoVenda produtoVenda = null;

        try (Connection con = abreConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idProdutoVenda);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    produtoVenda = new ProdutoVenda();
                    produtoVenda.setId(rs.getInt("id"));  
                    produtoVenda.setIdProduto(rs.getInt("idProduto"));
                    produtoVenda.setIdVenda(rs.getInt("idVenda"));
                    produtoVenda.setQuantidade(rs.getInt("quantidade"));
                    produtoVenda.setPrecoUnitario(rs.getFloat("precoUnitario"));
                } else {
                    System.out.println("ProdutoVenda não encontrado!");
                }
            }

        } catch (SQLException erro) {
            System.out.println("Erro ao buscar ProdutoVenda.");
            erro.printStackTrace();
        }

        return produtoVenda;
    }
}

