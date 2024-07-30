import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Digite o primerio número: ");
        int a = input.nextInt();
        System.out.println("Digite o segundo número: ");
        int b = input.nextInt();

        try {

                imprimeNumeros(a, b);

        }catch (ParametrosInvalidosExeption e) {

            System.err.println(e.getMessage());
        }
    }

    public static void imprimeNumeros(int a, int b) throws ParametrosInvalidosExeption {

        if(a > b ) {
            throw new ParametrosInvalidosExeption();
        }

        int qtdd = b - a;

        for (int i = 1; i <= qtdd; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }
}