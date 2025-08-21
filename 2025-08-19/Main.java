import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite a quantidade de pessoas que serao registradas: ");
        int n = entrada.nextInt();
        entrada.nextLine();

        for(int i = 0; i < n; i++)
        {
            System.out.print("Qual o tipo de pessoa? (Digite f para fisica e j para juridica): ");
            String f_ou_j = entrada.nextLine();

            if (f_ou_j.equals("j"))
            {
                System.out.print("Nome da pessoa: ");
                String nome = entrada.nextLine();

                System.out.print("Renda anual: ");
                double renda_anual = entrada.nextDouble();

                System.out.print("Número de funcionarios: ");
                int numero_funcionarios = entrada.nextInt();
                entrada.nextLine();

                Cadastro novocadastro = new Cadastro(nome, renda_anual, 0, numero_funcionarios);
                double imposto = novocadastro.juridica();
                novocadastro.informacoes(nome, imposto);
            }
            else {
                System.out.print("Nome da pessoa: ");
                String nome = entrada.nextLine();

                System.out.print("Renda anual: ");
                double renda_anual = entrada.nextDouble();

                System.out.print("Gastos com saude: ");
                double gastos_saude = entrada.nextDouble();
                entrada.nextLine();

                Cadastro novocadastro = new Cadastro(nome, renda_anual, gastos_saude, 0);
                double imposto = novocadastro.fisica();
                novocadastro.informacoes(nome, imposto);
            }
        }
    }
}