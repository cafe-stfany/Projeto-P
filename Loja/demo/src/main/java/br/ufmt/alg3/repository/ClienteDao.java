package br.ufmt.alg3.repository;

import static br.ufmt.alg3.utils.abreconexao.abreConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufmt.alg3.io.Cliente;

public class ClienteDao {

    
    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, cpf,  telefone, email, endereco) VALUES (?, ?, ?, ?, ?);";
        try (Connection con = abreConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getEndereco());
            ps.executeUpdate();
            System.out.println("Cliente inserido com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Não foi possível inserir o cliente!");
            erro.printStackTrace();
        }
    }

   
    public void atualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, cpf = ?, telefone = ?, email = ?, endereco = ? WHERE idCliente = ?;";
        try (Connection con = abreConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getEndereco());
            ps.setInt(6, cliente.getIdCliente());
            ps.executeUpdate();
            System.out.println("Cliente atualizado com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Não foi possível atualizar o cliente!");
            erro.printStackTrace();
        }
    }

   
    public void remover(int idCliente) {
        String sql = "DELETE FROM cliente WHERE idCliente = ?;";
        try (Connection con = abreConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCliente);
            ps.executeUpdate();
            System.out.println("Cliente removido com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Não foi possível remover o cliente!");
            erro.printStackTrace();
        }
    }

    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente;";
        try (Connection con = abreConexao();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));  
                cliente.setEndereco(rs.getString("endereco"));  
                clientes.add(cliente);
            }

        } catch (SQLException erro) {
            System.out.println("Não foi possível listar os clientes!");
            erro.printStackTrace();
        }
        return clientes;
    }

    
    public Cliente buscar(String cpf) {
        String sql = "SELECT * FROM cliente WHERE cpf = ?;";
        Cliente cliente = null;

        try (Connection con = abreConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cpf);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cliente = new Cliente();
                    cliente.setIdCliente(rs.getInt("idCliente"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setTelefone(rs.getString("telefone"));
                    cliente.setEmail(rs.getString("email"));  
                    cliente.setEndereco(rs.getString("endereco")); 
                } else {
                    System.out.println("Cliente não encontrado!");
                }
            }

        } catch (SQLException erro) {
            System.out.println("Erro ao buscar cliente!");
            erro.printStackTrace();
        }

        return cliente;
    }
}



