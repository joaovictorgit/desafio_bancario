import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String [] args){
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente());
        clientes.get(0).setNome("João");

        clientes.add(new Cliente());
        clientes.get(1).setNome("Ana");

       Banco banco = new Banco("Banco Teste");

       banco.adicionarConta(new ContaCorrente(clientes.get(0)));
       banco.adicionarConta(new ContaPoupanca(clientes.get(1)));

       banco.depositarConta(clientes.get(0), 30);
       banco.transferir(clientes.get(0),clientes.get(1), 20);
       banco.imprimirTodasContas();
    }
}
