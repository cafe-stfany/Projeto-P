package br.ufmt.alg3.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufmt.alg3.io.Produto;
import br.ufmt.alg3.io.Categoria;
import static br.ufmt.alg3.utils.abreconexao.abreConexao;

public class ProdutoDao {

    // Inserir novo produto
    public void inserir(Produto produto) {
        String sql = "INSERT INTO produto (nome, descricao, preco, estoque, idCategoria) VALUES (?, ?, ?, ?, ?);";
        try (Connection con = abreConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getDescricao());
            ps.setFloat(3, produto.getPreco());
            ps.setInt(4, produto.getEstoque());
            ps.setInt(5, produto.getCategoria().getId());

            ps.executeUpdate();
            System.out.println("Produto inserido com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Erro ao inserir produto.");
            erro.printStackTrace();
        }
    }

    // Atualizar produto existente
    public void atualizar(Produto produto) {
        String sql = "UPDATE produto SET nome = ?, descricao = ?, preco = ?, estoque = ?, idCategoria = ? WHERE idProduto = ?;";
        try (Connection con = abreConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getDescricao());
            ps.setFloat(3, produto.getPreco());
            ps.setInt(4, produto.getEstoque());
            ps.setInt(5, produto.getCategoria().getId());
            ps.setInt(6, produto.getId());

            ps.executeUpdate();
            System.out.println("Produto atualizado com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Erro ao atualizar produto.");
            erro.printStackTrace();
        }
    }

    // Remover produto pelo ID
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

    // Listar todos os produtos
    public List<Produto> listar() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT p.*, c.idCategoria, c.nome AS nomeCategoria FROM produto p JOIN categoria c ON p.idCategoria = c.idCategoria;";
        try (Connection con = abreConexao();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setEstoque(rs.getInt("estoque"));

                // Configurando a categoria do produto
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("idCategoria"));
                categoria.setNome(rs.getString("nomeCategoria"));
                produto.setCategoria(categoria);

                produtos.add(produto);
            }

        } catch (SQLException erro) {
            System.out.println("Erro ao listar produtos.");
            erro.printStackTrace();
        }
        return produtos;
    }

    // Buscar produto pelo ID
    public Produto buscar(int idProduto) {
        String sql = "SELECT p.*, c.idCategoria, c.nome AS nomeCategoria FROM produto p JOIN categoria c ON p.idCategoria = c.idCategoria WHERE p.idProduto = ?;";
        Produto produto = null;

        try (Connection con = abreConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idProduto);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    produto = new Produto();
                    produto.setId(rs.getInt("idProduto"));
                    produto.setNome(rs.getString("nome"));
                    produto.setDescricao(rs.getString("descricao"));
                    produto.setPreco(rs.getFloat("preco"));
                    produto.setEstoque(rs.getInt("estoque"));

                    // Configurando a categoria do produto
                    Categoria categoria = new Categoria();
                    categoria.setId(rs.getInt("idCategoria"));
                    categoria.setNome(rs.getString("nomeCategoria"));
                    produto.setCategoria(categoria);
                } else {
                    System.out.println("Produto não encontrado!");
                }
            }

        } catch (SQLException erro) {
            System.out.println("Erro ao buscar produto.");
            erro.printStackTrace();
        }

        return produto;
    }
}


