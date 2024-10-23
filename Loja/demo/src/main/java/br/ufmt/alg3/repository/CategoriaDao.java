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
        String sql = "INSERT INTO categoria (nome) VALUES (?);";
        try (Connection con = abreConexao(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setString(1, categoria.getNome());
            ps.executeUpdate();
            System.out.println("Categoria inserida com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Erro ao inserir a categoria!");
            erro.printStackTrace();
        }
    }


    public void atualizar(Categoria categoria) {
        String sql = "UPDATE categoria SET nome = ? WHERE idCategoria = ?;";
        try (Connection con = abreConexao(); 
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, categoria.getNome());
            ps.setInt(2, categoria.getIdCategoria());
            ps.executeUpdate();
            System.out.println("Categoria atualizada com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Erro ao atualizar a categoria!");
            erro.printStackTrace();
        }
    }

    public void remover(int idCategoria) {
        String sql = "DELETE FROM categoria WHERE idCategoria = ?;";
        try (Connection con = abreConexao(); 
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCategoria);
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
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setNome(rs.getString("nome"));
                categorias.add(categoria);
            }
        } catch (SQLException erro) {
            System.out.println("Erro ao listar as categorias!");
            erro.printStackTrace();
        }
        return categorias;
    }

}
