package model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class  Conta implements IConta{

    protected static int numero = 1;
    protected static final int agencia = 406;
    protected  Double saldo = 0.0;
    protected Person person;
    protected Boolean status = true;

    @Override
    public void depositar(Double valor) {
        this.saldo += valor;
    }

    @Override
    public void sacar(Double valor) {
        if(verificarSaldo(valor)){
            this.saldo -= valor;
        }else{
            throw new IllegalArgumentException("Saldo insuficiente");
        }
    }

    @Override
    public void transferir(Double valor, Conta conta) {
        if(verificarSaldo(valor)){
            this.saldo -= valor;
            conta.saldo +=valor;
        }else{
            throw new IllegalArgumentException("Saldo insuficiente");
        }
    }

    @Override
    public void encerrarConta(Conta conta) {
        this.status = false;
    }

    @Override
    public Boolean verificarSaldo(Double valor) {
        return valor < saldo;
    }

    public void imprimirInfosComuns() {
        System.out.printf("Titular: %s%n", this.person.getNome());
        System.out.printf("Agencia: %d%n", agencia);
        System.out.printf("Numero: %d%n", numero);
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }
}
