import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome){
        this.nome = nome;
        contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta){
        this.contas.add(conta);
    }

    public Conta contaCliente(String nome){

        for(Conta c : getContas()){
           if(nome.equals(c.cliente.getNome())){
               return c;
           }

        }
        return null;
    }

    public void sacar(Cliente cliente, double valor){
        Conta conta = contaCliente(cliente.getNome());
        if(conta.saldo - valor < 0 || conta.saldo == 0){
            System.out.println("Você não tem saldo suficiente");
        }
        conta.sacar(valor);
    }

    public void depositarConta(Cliente cliente, double valor){
        Conta conta = contaCliente(cliente.getNome());
        conta.despositar(valor);
    }

    public void transferir(Cliente cliente, Cliente destino, double valor){
        Conta conta = contaCliente(cliente.getNome());
        Conta contaDestino = contaCliente(destino.getNome());
        conta.transferir(contaDestino,valor);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public void imprimirTodasContas(){
        for(Conta conta : getContas()){
            conta.imprimirExtrato();
        }
    }
}
