package br.ufmt.alg3.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufmt.alg3.io.Categoria;

import static br.ufmt.alg3.utils.abreconexao.abreConexao;

public class CategoriaDao {

    
    public void inserir(Categoria categoria) {
        String sql = "INSERT INTO categoria (nome, descricao) VALUES (?, ?);";
        try (Connection con = abreConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, categoria.getNome());
            ps.setString(2, categoria.getDescricao());
            ps.executeUpdate();
            System.out.println("Categoria inserida com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Erro ao inserir a categoria!");
            erro.printStackTrace();
        }
    }

  
    public void atualizar(Categoria categoria) {
        String sql = "UPDATE categoria SET nome = ?, descricao = ? WHERE id = ?;";
        try (Connection con = abreConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, categoria.getNome());
            ps.setString(2, categoria.getDescricao());
            ps.setInt(3, categoria.getId());
            ps.executeUpdate();
            System.out.println("Categoria atualizada com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Erro ao atualizar a categoria!");
            erro.printStackTrace();
        }
    }

 
    public void remover(int id) {
        String sql = "DELETE FROM categoria WHERE id = ?;";
        try (Connection con = abreConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Categoria removida com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Erro ao remover a categoria!");
            erro.printStackTrace();
        }
    }

   
    public List<Categoria> listar() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria;";
        try (Connection con = abreConexao();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));
                categorias.add(categoria);
            }
        } catch (SQLException erro) {
            System.out.println("Erro ao listar as categorias!");
            erro.printStackTrace();
        }
        return categorias;
    }
}
