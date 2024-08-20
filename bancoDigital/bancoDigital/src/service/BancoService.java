package service;

import lombok.Getter;
import model.*;

import java.util.Optional;
import java.util.Scanner;

@Getter
public class BancoService {

    private final Banco banco;

    public BancoService(){
        this.banco = new Banco();
    }

    public void abrirConta(String nome, String tipoConta) {
        var person = new Person(nome);
        if (tipoConta.contains("CORRENTE")){
            var contaCorrente = new ContaCorrente();
            contaCorrente.setPerson(person);
            banco.addCliente(person);
            banco.addConta(contaCorrente);
        } else if (tipoConta.contains("POUPANCA")) {
            var contaPoupanca = new ContaPoupanca();
            contaPoupanca.setPerson(person);
            banco.addCliente(person);
            banco.addConta(contaPoupanca);
        }else{
            throw new RuntimeException("Tipo de conta invalido");
        }
    }

    public void executarOperacoes() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Escolha uma operação:");
            System.out.println("1: Cadastrar Conta");
            System.out.println("2: Depositar");
            System.out.println("3: Sacar");
            System.out.println("4: Transferir");
            System.out.println("5: Encerrar Conta");
            System.out.println("6: Imprimir Extrato");
            System.out.println("7: Sair");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1 -> {
                    System.out.println("Digite o nome do cliente:");
                    String nome = scanner.nextLine().toUpperCase();
                    System.out.println("Digite o tipo de conta (CORRENTE ou POUPANCA):");
                    String tipoConta = scanner.nextLine().toUpperCase();
                    abrirConta(nome, tipoConta);
                }
                case 2 -> {
                    System.out.println("Digite o nome do cliente para depósito:");
                    String nome = scanner.nextLine().toUpperCase();
                    Optional<Conta> optionalConta = banco.buscarContaPorNome(nome);
                    if (optionalConta.isPresent()) {
                        Conta conta = optionalConta.get();
                        System.out.println("Digite o valor para depósito:");
                        double valor = scanner.nextDouble();
                        conta.depositar(valor);
                        System.out.println("Depósito realizado com sucesso.");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                }
                case 3 -> {
                    System.out.println("Digite o nome do cliente para saque:");
                    String nome = scanner.nextLine().toUpperCase();
                    Optional<Conta> optionalConta = banco.buscarContaPorNome(nome);
                    if (optionalConta.isPresent()) {
                        Conta conta = optionalConta.get();
                        System.out.println("Digite o valor para saque:");
                        double valor = scanner.nextDouble();
                        conta.sacar(valor);
                        System.out.println("Saque realizado com sucesso.");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                }
                case 4 -> {
                    System.out.println("Digite o nome do cliente que vai transferir:");
                    String nome = scanner.nextLine().toUpperCase();
                    Optional<Conta> optionalContaOrigem = banco.buscarContaPorNome(nome);
                    if (optionalContaOrigem.isPresent()) {
                        Conta contaOrigem = optionalContaOrigem.get();
                        System.out.println("Digite o nome do cliente destinatário:");
                        String nomeDestino = scanner.nextLine().toUpperCase();
                        Optional<Conta> optionalContaDestino = banco.buscarContaPorNome(nomeDestino);
                        if (optionalContaDestino.isPresent()) {
                            Conta contaDestino = optionalContaDestino.get();
                            System.out.println("Digite o valor para transferência:");
                            double valor = scanner.nextDouble();
                            try {
                                contaOrigem.transferir(valor, contaDestino);
                                System.out.println("Transferência realizada com sucesso.");
                            } catch (IllegalArgumentException e) {
                                System.out.println("Erro: " + e.getMessage());
                            }
                        } else {
                            System.out.println("Conta de destino não encontrada.");
                        }
                    } else {
                        System.out.println("Conta de origem não encontrada.");
                    }
                }
                case 5 -> {
                    System.out.println("Digite o nome do cliente para encerrar a conta:");
                    String nome = scanner.nextLine().toUpperCase();
                    Optional<Conta> optionalConta = banco.buscarContaPorNome(nome);
                    if (optionalConta.isPresent()) {
                        Conta conta = optionalConta.get();
                        conta.encerrarConta(conta);
                        System.out.println("Conta encerrada com sucesso.");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                }
                case 6 -> {
                    System.out.println("Digite o nome do cliente para imprimir o extrato:");
                    String nome = scanner.nextLine().toUpperCase();
                    Optional<Conta> optionalConta = banco.buscarContaPorNome(nome);
                    if (optionalConta.isPresent()) {
                        Conta conta = optionalConta.get();
                        conta.imprimirInfosComuns();
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                }
                case 7 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 7);

        scanner.close();
    }

}



