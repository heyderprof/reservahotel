package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import excecoes.ExcecaoPersonalizada;

public class Reserva {

	private int numeroQuarto;
	private String nomeCliente;
	private Date entrada;
	private Date saida;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva(int numeroQuarto, Date entrada, Date saida, String nomeCliente) {

		Date atual = new Date();

		if (entrada.before(atual)) {
			throw new ExcecaoPersonalizada("As datas da reserva precisam ser superiores a data atual.");
		}

		this.numeroQuarto = numeroQuarto;
		this.entrada = entrada;
		this.saida = saida;
		this.nomeCliente = nomeCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getEntrada() {
		return entrada;
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	public Date getSaida() {
		return saida;
	}

	public void setSaida(Date saida) {
		this.saida = saida;
	}

	public long duracao() {
		long diferenca = saida.getTime() - entrada.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}

	public String toString() {
		return "RESERVA: quarto nº " + numeroQuarto + " - Cliente: " + nomeCliente + " - Entrada: "
				+ sdf.format(entrada) + " saída: " + sdf.format(saida) + " - Duração: " + duracao() + " dias";
	}

}
