public abstract class Conta implements IConta{

    private static final int AGENCIA = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int n_conta;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente){
            this.agencia = AGENCIA;
            this.n_conta = SEQUENCIAL++;
            this.cliente = cliente;
        }

    @Override
    public void sacar(double valor) {
        this.saldo = this.saldo - valor;
    }

    @Override
    public void despositar(double valor) {
        this.saldo = this.saldo + valor;
    }

    @Override
    public void transferir(IConta contaDestino, double valor) {
        this.sacar(valor);
        contaDestino.despositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getN_conta() {
        return n_conta;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirDadosComuns(){
        System.out.println(String.format("Titular: %s", cliente.getNome()));
        System.out.println(String.format("Agencia: %d", agencia));
        System.out.println(String.format("Numero: %d", n_conta));
        System.out.println(String.format("Saldo: %.2f", saldo));
    }

}
