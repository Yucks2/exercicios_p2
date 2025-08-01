import java.util.Scanner;

public class main
{
	public static void main(String[] args) {
		
	Scanner entrada = new Scanner(System.in);

	System.out.print("Digite o nome do produto: ");
	String nome = entrada.nextLine();

	System.out.print("Digite o preco do produto: ");
	Double preco = entrada.nextDouble();

	System.out.print("Digite a quantidade no estoque: ");
	int quantidade = entrada.nextInt();

	double total = preco * quantidade;

	Produto novoproduto = new Produto(nome, preco, quantidade, total);

	novoproduto.informacoes();

	System.out.print("----- Realizar entrada no estoque -----\n");

	System.out.print("Realizar entrada no estoque: ");
	int aumentar = entrada.nextInt();
	novoproduto.Adicionar_estoque(aumentar);

	novoproduto.informacoes();

	System.out.print("Realizar saida no estoque: ");
	int diminuir = entrada.nextInt();
	novoproduto.Remover_estoque(diminuir);

	novoproduto.informacoes();
	}
}