import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate data_checkin = null;
        LocalDate data_checkout = null;
        boolean checkin_valido = false;
        boolean checkout_valido = false;

        System.out.print("Insira o numero do quarto: ");
        int numero_quarto = scanner.nextInt();
        scanner.nextLine();

        while(!checkin_valido)
        {
            System.out.print("Insira a data de ENTRADA no formato (dd/mm/yyyy): ");
            String entrada = scanner.nextLine();

            try
            {
                data_checkin = LocalDate.parse(entrada, formatar);
                checkin_valido = true;
            }

            catch(DateTimeParseException e)
            {
                System.out.println("Formato invalido, tente novamente.");
            }
        }

        while(!checkout_valido)
        {
            System.out.print("Insira a data de SAIDA no formato (dd/mm/yyyy): ");
            String entrada = scanner.nextLine();

            try
            {
                data_checkout = LocalDate.parse(entrada, formatar);
                if(data_checkout.isAfter(data_checkin))
                {
                    checkout_valido = true;
                }
                else
                {
                    System.out.println("Insira uma data de saida apos a data de entrada.");
                }
            }
            catch(DateTimeParseException e)
            {
                System.out.println("Formato invalido, tente novamente.");
            }
        }

        Reserva novareserva = new Reserva(numero_quarto, data_checkin, data_checkout);
        novareserva.informacoes();
        
        System.out.print("Caso deseje atualizar a data, digite sim ou nao: ");
        String resposta = scanner.nextLine();

        if(resposta.equals("sim"))
        {
            LocalDate novo_checkin = null;
            LocalDate novo_checkout = null;
            boolean novo_checkin_valido = false;
            boolean novo_checkout_valido = false;

            while(!novo_checkin_valido)
            {
                System.out.print("Digite para qual data deseja reagendar (dd/mm/yyyy): ");
                String entrada = scanner.nextLine();

                try
                {
                    novo_checkin = LocalDate.parse(entrada, formatar);
                    if(novo_checkin.isAfter(data_checkin))
                    {
                        novo_checkin_valido = true;
                    }
                    else
                    {
                        System.out.println("A nova data deve ser depois da primeira data informada.");
                    }
                }
                catch(DateTimeParseException e)
                {
                    System.out.println("Formato invalido, tente novamente.");
                }
            }

            while(!novo_checkout_valido)
            {
                System.out.print("Insira a nova data de saida (dd/mm/yyyy): ");
                String entrada = scanner.nextLine();

                try
                {
                    novo_checkout = LocalDate.parse(entrada, formatar);
                    if(novo_checkout.isAfter(novo_checkin))
                    {
                        novo_checkout_valido = true;
                    }
                    else
                    {
                        System.out.println("A data deve ser apos a entrada.");
                    }
                }
                catch(DateTimeParseException e)
                {
                    System.out.println("Formato invalido, tente novamente.");
                }
            }
            novareserva.atualizarDatas(novo_checkin, novo_checkout);
        }
        novareserva.informacoes();
    }
}