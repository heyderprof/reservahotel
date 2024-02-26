package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import entidades.Reserva;
import excecoes.ExcecaoPersonalizada;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		
		try {
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		

		System.out.println("***Nacional Palace Hotel ***");
		System.out.println("Nova Reserva");
		System.out.print("Número do quarto: ");
		int num = sc.nextInt();
		sc.nextLine();
		System.out.print("Cliente: ");
		String nomeCliente = sc.nextLine();
		System.out.print("Entrada: (dd/mm/aaaa): ");
		Date entrada = sdf.parse(sc.next());
		System.out.print("Saída: (dd/mm/aaaa): ");
		Date saida = sdf.parse(sc.next());
		
		Reserva reserva = new Reserva(num, entrada, saida, nomeCliente);
		
		System.out.println(reserva);
		
		sc.close();
		
		System.out.println("Reserva Efetuada com Sucesso!");
		
		}
		catch (ParseException erro) {
			System.out.println("Formato de data inválido!");
		}
		
		catch (InputMismatchException erro) {
			System.out.println("Formato de dados inválido!");
		}
		
		catch (ExcecaoPersonalizada erro) {
			System.out.println(erro.getMessage());
		}
		

	}

}
