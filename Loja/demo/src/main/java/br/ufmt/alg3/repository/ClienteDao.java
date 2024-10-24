package br.ufmt.alg3.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufmt.alg3.io.Cliente;

import static br.ufmt.alg3.utils.abreconexao.abreConexao;

public class ClienteDao {
     
    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO cliente (cpf, nome, telefone) VALUES (?, ?, ?);";
        try (Connection con = abreConexao(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getTelefone());
            ps.executeUpdate();
           try {

            
           } catch (Exception e) {
           
           }
        } catch (SQLException erro) {
            System.out.println("Não foi possível inserir o cliente!");
            erro.printStackTrace();
        }
    }

    public void atualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET cpf = ?, nome = ?, telefone = ? WHERE idCliente = ?;";
        try (Connection con = abreConexao(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getTelefone());
            ps.setInt(4, cliente.getIdCliente());
            ps.executeUpdate();
            
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
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                clientes.add(cliente);
            }
        } catch (SQLException erro) {
            System.out.println("Não foi possível listar os clientes!");
            erro.printStackTrace();
        }
        return clientes;
    }

    public Cliente buscar(String cpf){

        String sql = "SELECT * FROM cliente WHERE cpf = ?";
        Cliente cliente = new Cliente();
        try  (Connection con = abreConexao(); 
            PreparedStatement ps = con.prepareStatement(sql); 
            ResultSet rs = ps.executeQuery();){

                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
              
              

            }
             catch (SQLException erro) {
                System.out.println("Cliente não cadastrado!");
                erro.printStackTrace();
            }
            return cliente;  
            }
        };
            
        
    



