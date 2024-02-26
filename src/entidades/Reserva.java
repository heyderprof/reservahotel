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

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Especifiquei como será o formato da data, com o objeto SimpleDateFormat

	public Reserva(int numeroQuarto, Date entrada, Date saida, String nomeCliente) {

		Date atual = new Date(); // criei uma variável do tipo DATE e atribui a ela a data de hoje (com new Date())

		if (entrada.before(atual) || saida.before(atual)) {
			throw new ExcecaoPersonalizada("As datas da reserva precisam ser superiores a data atual.");
		}
		
		/*
		 * ATIVIDADE
		  Fiz o tratamento da primeira exceção personalizada, para verificar se as datas de entrada
		  e saída informada pelo usuário são superiores à data atual.
		  
		  Utilizei o método "before", nativo do Date.java
		  
		  Falta fazer as demais, são elas:
		  A data de saída deve ser superior à data de entrada
		  A reserva precisa conter pelo menos 01 noite.
		*/
		
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
