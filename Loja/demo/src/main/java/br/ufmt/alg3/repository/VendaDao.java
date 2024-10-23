package br.ufmt.alg3.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import br.ufmt.alg3.io.Venda;

import static br.ufmt.alg3.utils.abreconexao.abreConexao;

public class VendaDao {


    
    public void inserir(Venda venda) {
        String sql = "INSERT INTO venda (idCliente, valorTotal, dataVenda) VALUES (?, ?, ?);";
        try (Connection con = abreConexao(); 
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, venda.getIdCliente());
            ps.setFloat(2, venda.getValorTotal());
            ps.setDate(3, new Date(venda.getDataVenda().getTime()));
            ps.executeUpdate();
            System.out.println("Venda inserida com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Erro ao inserir venda!");
            erro.printStackTrace();
        }
    }

  
    public void atualizar(Venda venda) {
        String sql = "UPDATE venda SET idCliente = ?, valorTotal = ?, dataVenda = ? WHERE idVenda = ?;";
        try (Connection con = abreConexao(); 
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, venda.getIdCliente());
            ps.setFloat(2, venda.getValorTotal());
            ps.setDate(3, new Date(venda.getDataVenda().getTime()));
            ps.setInt(4, venda.getIdVenda());
            ps.executeUpdate();
            System.out.println("Venda atualizada com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Erro ao atualizar venda!");
            erro.printStackTrace();
        }
    }

 
    public void remover(int idVenda) {
        String sql = "DELETE FROM venda WHERE idVenda = ?;";
        try (Connection con = abreConexao(); 
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idVenda);
            ps.executeUpdate();
            System.out.println("Venda removida com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Erro ao remover venda!");
            erro.printStackTrace();
        }
    }

   
    public List<Venda> listar() {
        List<Venda> vendas = new ArrayList<>();
        String sql = "SELECT * FROM venda;";
        try (Connection con = abreConexao(); 
             PreparedStatement ps = con.prepareStatement(sql); 
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Venda venda = new Venda();
                venda.setIdVenda(rs.getInt("idVenda"));
                venda.setIdCliente(rs.getInt("idCliente"));
                venda.setValorTotal(rs.getFloat("valorTotal"));
                venda.setDataVenda(rs.getDate("dataVenda"));
                vendas.add(venda);
            }
        } catch (SQLException erro) {
            System.out.println("Erro ao listar vendas!");
            erro.printStackTrace();
        }
        return vendas;
    }
}
