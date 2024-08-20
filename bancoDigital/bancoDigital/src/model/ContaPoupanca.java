package model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaPoupanca extends Conta{

    private String tipo = "POUPANCA";

    @Override
    public void imprimirInfosComuns() {
        super.imprimirInfosComuns();
        System.out.printf("Tipo: %s%n", tipo);
    }
}
