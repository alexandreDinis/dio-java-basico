package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class Banco {

    private List<Person> cliente;
    private List<Conta> conta;

    public Banco() {
        this.cliente = new ArrayList<>(); // Inicializa a lista de clientes
        this.conta = new ArrayList<>(); // Inicializa a lista de contas
    }


    public void addCliente(Person person) {
        this.cliente.add(person);
    }

    public void addConta(Conta conta) {
        this.conta.add(conta);
    }

    public Optional<Conta> buscarContaPorNome(String nome) {
        return conta.stream()
                .filter(c -> c.getPerson().getNome().equals(nome))
                .findFirst();
    }
}
