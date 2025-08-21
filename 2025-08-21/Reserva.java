import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reserva
{
    private int numero_quarto;
    private LocalDate entrada;
    private LocalDate saida;

    public Reserva(int numero_quarto, LocalDate entrada, LocalDate saida)
    {
        if(saida.isBefore(entrada) || saida.isEqual(entrada))
        {
            throw new IllegalArgumentException("A data de saída deve ser em seguida da data de entrada.");
        }
        this.numero_quarto = numero_quarto;
        this.entrada = entrada;
        this.saida = saida;
    }

    public void atualizarDatas(LocalDate novocheckin, LocalDate novocheckout)
    {

    if(novocheckout.isBefore(novocheckin) || novocheckout.isEqual(novocheckin))
    {
        System.out.println("A nova data de saída deve ser posterior à nova data de entrada.");
        return;
    }

        this.entrada = novocheckin;
        this.saida = novocheckout;
        System.out.println("Datas da reserva atualizadas com sucesso!");
    }

    public void informacoes()
    {
        System.out.println("O seu quarto " + numero_quarto + " foi reservado na data " + entrada + " e saida em " + saida);
    }
}