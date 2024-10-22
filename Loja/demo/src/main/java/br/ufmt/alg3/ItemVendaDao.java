package br.ufmt.alg3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemVendaDao {

    private Connection abreConexao() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:postgresql://127.0.0.1:5433/sua_loja", // Atualize com seus dados
            "usuario", 
            "senha"
        );
    }

   
    public void inserir(ItemVenda item) {
        String sql = "INSERT INTO item_venda (idVenda, idProduto, quantidade, valorProduto) VALUES (?, ?, ?, ?);";
        try (Connection con = abreConexao(); 
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, item.getIdVenda());
            ps.setInt(2, item.getIdProduto());
            ps.setInt(3, item.getQuantidade());
            ps.setFloat(4, item.getValorProduto());
            ps.executeUpdate();
            System.out.println("Item de venda inserido com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Erro ao inserir item de venda!");
            erro.printStackTrace();
        }
    }

   
    public void atualizar(ItemVenda item) {
        String sql = "UPDATE item_venda SET idVenda = ?, idProduto = ?, quantidade = ?, valorProduto = ? WHERE idItem = ?;";
        try (Connection con = abreConexao(); 
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, item.getIdVenda());
            ps.setInt(2, item.getIdProduto());
            ps.setInt(3, item.getQuantidade());
            ps.setFloat(4, item.getValorProduto());
            ps.setInt(5, item.getIdItem());
            ps.executeUpdate();
            System.out.println("Item de venda atualizado com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Erro ao atualizar item de venda!");
            erro.printStackTrace();
        }
    }

    
    public void remover(int idItem) {
        String sql = "DELETE FROM item_venda WHERE idItem = ?;";
        try (Connection con = abreConexao(); 
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idItem);
            ps.executeUpdate();
            System.out.println("Item de venda removido com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Erro ao remover item de venda!");
            erro.printStackTrace();
        }
    }

    
    public List<ItemVenda> listar() {
        List<ItemVenda> itens = new ArrayList<>();
        String sql = "SELECT * FROM item_venda;";
        try (Connection con = abreConexao(); 
             PreparedStatement ps = con.prepareStatement(sql); 
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ItemVenda item = new ItemVenda();
                item.setIdItem(rs.getInt("idItem"));
                item.setIdVenda(rs.getInt("idVenda"));
                item.setIdProduto(rs.getInt("idProduto"));
                item.setQuantidade(rs.getInt("quantidade"));
                item.setValorProduto(rs.getFloat("valorProduto"));
                itens.add(item);
            }
        } catch (SQLException erro) {
            System.out.println("Erro ao listar itens de venda!");
            erro.printStackTrace();
        }
        return itens;
    }
}
