public class Cadastro
{
    String nome;
    double renda_anual;
    double gastos_saude;
    int numero_funcionarios;

    public Cadastro(String nome, double renda_anual, double gastos_saude, int numero_funcionarios)
    {
        this.nome = nome;
        this.renda_anual = renda_anual;
        this.gastos_saude = gastos_saude;
        this.numero_funcionarios = numero_funcionarios;
    }

    //caso pessoa juridica
    public double juridica()
    {
        if(numero_funcionarios > 10)
        {
            return renda_anual * 14/100;
        }
        else
        {
            return renda_anual * 16/100;
        }
    }

    //caso pessoa física
    public double fisica()
    {
        if(renda_anual < 20000)
        {
            return (renda_anual * 15/100) - (gastos_saude * 50/100);
        }
        else
        {
            return (renda_anual * 25/100) - (gastos_saude * 50/100);
        }
    }

    public void informacoes(String nome, double imposto)
    {
        System.out.println("Imposto total de " + nome + " =  R$ " + imposto);
    }
}
