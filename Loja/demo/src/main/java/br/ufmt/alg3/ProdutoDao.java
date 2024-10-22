package br.ufmt.alg3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {
    private Connection abreConexao() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:postgresql://127.0.0.1:5433/sua_loja",  
            "usuario",  
            "senha"    
        );
    }

   
    public void inserir(Produto produto) {
        String sql = "INSERT INTO produto (valorProduto, idCategoria, descricao) VALUES (?, ?, ?);";
        try (Connection con = abreConexao(); 
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setFloat(1, produto.getValorProduto());
            ps.setString(2, produto.getIdCategoria());
            ps.setString(3, produto.getDescricao());

            ps.executeUpdate();
            System.out.println("Produto inserido com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Erro ao inserir produto.");
            erro.printStackTrace();
        }
    }

   
    public void atualizar(Produto produto) {
        String sql = "UPDATE produto SET valorProduto = ?, idCategoria = ?, descricao = ? WHERE idProduto = ?;";
        try (Connection con = abreConexao(); 
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setFloat(1, produto.getValorProduto());
            ps.setString(2, produto.getIdCategoria());
            ps.setString(3, produto.getDescricao());
            ps.setInt(4, produto.getIdProduto());

            ps.executeUpdate();
            System.out.println("Produto atualizado com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Erro ao atualizar produto.");
            erro.printStackTrace();
        }
    }

    // Método para remover um produto pelo ID
    public void remover(int idProduto) {
        String sql = "DELETE FROM produto WHERE idProduto = ?;";
        try (Connection con = abreConexao(); 
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idProduto);
            ps.executeUpdate();
            System.out.println("Produto removido com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Erro ao remover produto.");
            erro.printStackTrace();
        }
    }

    // Método para listar todos os produtos
    public List<Produto> listar() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto;";
        try (Connection con = abreConexao(); 
             PreparedStatement ps = con.prepareStatement(sql); 
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setValorProduto(rs.getFloat("valorProduto"));
                produto.setIdCategoria(rs.getString("idCategoria"));
                produto.setDescricao(rs.getString("descricao"));

                produtos.add(produto);
            }

        } catch (SQLException erro) {
            System.out.println("Erro ao listar produtos.");
            erro.printStackTrace();
        }
        return produtos;
    }
}


