import java.util.Scanner;

public class ContaTermina{



    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        int numero;
        String agencia, nomeCliente;
        Double saldo;

        System.out.println("\n************* DIO BANCK ************");
        System.out.println("");
        System.out.println("Por favor, digite o número da agência: ");
        agencia = input.nextLine();
        System.out.println("Digite o número da conta: ");
        numero = input.nextInt();
        input.nextLine();
        System.out.println("Digite o nome do cliente: ");
        nomeCliente = input.nextLine();
        System.out.println("Por favor, digite o valor que deseja depositar: ");
        saldo = input.nextDouble();

       
       System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %s e seu saldo %.2f já está disponível para saque.%n", nomeCliente, agencia, numero, saldo);


    }
}