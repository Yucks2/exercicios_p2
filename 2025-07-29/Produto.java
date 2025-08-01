public class Produto {
	String nome;
	double preco;
	int quantidade;
	double total;

	public Produto(String nome, Double preco, int quantidade, double total) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.total = total;
	}

	public double calcularvalortotal() {
		return total = quantidade * preco;
	}

	public void Adicionar_estoque(int aumentar) {
		quantidade += aumentar;
	}

	public void Remover_estoque(int remover) {
		quantidade -= remover;
	}

	public void informacoes() {
		total = preco * quantidade;
		System.out.print("O Produto " + nome + " de R$ " + preco + " possui " + quantidade + " em estoque\n");
		System.out.print("Total do estoque: R$ " + total + "\n");
	}

}