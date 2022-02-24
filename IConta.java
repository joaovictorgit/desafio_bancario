public interface IConta {
    void sacar(double valor);
    void despositar(double valor);
    void transferir(IConta contaDestino, double valor);
    void imprimirExtrato();
}
