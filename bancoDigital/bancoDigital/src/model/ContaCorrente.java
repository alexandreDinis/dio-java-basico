package model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaCorrente extends Conta{

    private static final String tipo = "CORRENTE";

    @Override
      public void imprimirInfosComuns() {
        super.imprimirInfosComuns();
        System.out.printf("Tipo: %s%n", tipo);
    }
}
