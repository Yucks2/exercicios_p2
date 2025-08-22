public class Conta
{

    private int numero;
    private String proprietario;
    private double saldo;
    private double limiteSaque;

    public Conta(int numero, String proprietario, double saldo, double limiteSaque)
    {
        this.numero = numero;
        this.proprietario = proprietario;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
    }
    
    
    public int getNumero() {
        return numero;
    }

    public String getProprietario()
    {
        return proprietario;
    }

    public double getSaldo()
    {
        return saldo;
    }

    public double getLimiteSaque()
    {
        return limiteSaque;
    }
    
    public void deposito(double quantia)
    {
        this.saldo += quantia;
    }
    
    public void retirar(double quantia) throws SaqueException
    {
        if (quantia > getLimiteSaque())
        {
            throw new SaqueException("O valor do saque supera o limite permitido.");
        }
        if (quantia > getSaldo()) {
            throw new SaqueException("Saldo insuficiente.");
        }
        this.saldo -= quantia;
    }
}
