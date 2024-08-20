package model;

public interface IConta {

    void depositar(Double valor);

    void sacar(Double valor);

    void transferir(Double valor, Conta conta);

    void encerrarConta(Conta conta);

    Boolean verificarSaldo(Double valor);

}
