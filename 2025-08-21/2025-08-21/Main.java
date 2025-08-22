import java.util.Scanner;

public class Program
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Insira os dados da conta:");
        System.out.print("Numero: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Proprietario: ");
        String proprietario = scanner.nextLine();

        System.out.print("Saldo inicial: ");
        double saldo = scanner.nextDouble();

        System.out.print("Limite de saque: ");
        double limiteSaque = scanner.nextDouble();
        
        Conta conta = new Conta(numero, proprietario, saldo, limiteSaque);
        
        System.out.println();
        System.out.print("Insira o valor que deseja sacar: ");
        double valorSaque = scanner.nextDouble();
        
        try {
            conta.retirar(valorSaque);
            System.out.printf("Novo saldo: %.2f%n", conta.getSaldo());
        }
        
        catch(SaqueException e)
        {
            System.out.println("Erro ao efetuar saque: " + e.getMessage());
        }
        
        scanner.close();
    }
}
