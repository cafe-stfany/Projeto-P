package br.ufmt.alg3.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import br.ufmt.alg3.io.Venda;
import br.ufmt.alg3.io.Cliente;
import static br.ufmt.alg3.utils.abreconexao.abreConexao;

public class VendaDao {

    // Método para inserir uma venda
    public void inserir(Venda venda) {
        String sql = "INSERT INTO venda (idCliente, valorTotal, dataVenda, status, formaPagamento) VALUES (?, ?, ?, ?, ?);";
        try (Connection con = abreConexao(); 
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, venda.getIdCliente()); 
            ps.setFloat(2, venda.getValorTotal());
            ps.setDate(3, new Date(venda.getDataVenda().getTime()));
            ps.setString(4, venda.getStatus());
            ps.setString(5, venda.getFormaPagamento());
            
            ps.executeUpdate();
            System.out.println("Venda inserida com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Erro ao inserir venda!");
            erro.printStackTrace();
        }
    }

    
    public void atualizar(Venda venda) {
        String sql = "UPDATE venda SET idCliente = ?, valorTotal = ?, dataVenda = ?, status = ?, formaPagamento = ? WHERE id = ?;";
        try (Connection con = abreConexao(); 
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, venda.getIdCliente());
            ps.setFloat(2, venda.getValorTotal());
            ps.setDate(3, new Date(venda.getDataVenda().getTime()));
            ps.setString(4, venda.getStatus());
            ps.setString(5, venda.getFormaPagamento());
            ps.setInt(6, venda.getId()); 
            
            ps.executeUpdate();
            System.out.println("Venda atualizada com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Erro ao atualizar venda!");
            erro.printStackTrace();
        }
    }

    
    public void remover(int idVenda) {
        String sql = "DELETE FROM venda WHERE id = ?;";
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
        String sql = "SELECT v.*, c.id AS idCliente, c.nome AS nomeCliente FROM venda v JOIN cliente c ON v.idCliente = c.id;";
        try (Connection con = abreConexao(); 
             PreparedStatement ps = con.prepareStatement(sql); 
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Venda venda = new Venda();
                venda.setId(rs.getInt("id")); 
                
               
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNome(rs.getString("nomeCliente"));
                venda.setIdCliente(cliente.getIdCliente()); 
                venda.setValorTotal(rs.getFloat("valorTotal"));
                venda.setDataVenda(rs.getDate("dataVenda"));
                venda.setStatus(rs.getString("status"));
                venda.setFormaPagamento(rs.getString("formaPagamento"));

                vendas.add(venda);
            }
        } catch (SQLException erro) {
            System.out.println("Erro ao listar vendas!");
            erro.printStackTrace();
        }
        return vendas;
    }
}
