package br.ufmt.alg3;

import br.ufmt.alg3.io.Cliente;
import br.ufmt.alg3.repository.ClienteDao;

public final class App {
    private App() {
    }

    /**
     * Método principal da aplicação.
     * @param args Os argumentos do programa.
     */
    public static void main(String[] args) {
 

       
        Cliente cliente = new Cliente();
        cliente.setCpf("12345678901");
        cliente.setNome("João Silva");
        cliente.setTelefone("11987654321");
        
        ClienteDao clienteDAO = new ClienteDao();
        clienteDAO.inserir(cliente);

        clienteDAO.remover(cliente.getIdCliente());

        

    }
}
