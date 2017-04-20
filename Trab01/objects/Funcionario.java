package br.ufsc.ine5605.trab1.objects;

import java.util.ArrayList;
import java.util.Date;

public class Funcionario {

	private String numeroMatricula;
	private String nome;
	private Date dataNascimento;
	private String telefone;
	private String cargo;
	private ArrayList<Veiculo> listaDeCarrosLiberados;

	public Funcionario(String numeroMatricula, String nome, Date dataNascimento, String telefone, String cargo) {
		super();
		this.numeroMatricula = numeroMatricula;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.cargo = cargo;
		this.listaDeCarrosLiberados = new ArrayList<>();
	}

	public String getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void addVeiculo(Veiculo veiculo) {
		if (veiculo != null) {
			if (!listaDeCarrosLiberados.isEmpty()) {
				if (!listaDeCarrosLiberados.contains(veiculo)) {
					listaDeCarrosLiberados.add(veiculo);
				}
			} else {
				listaDeCarrosLiberados.add(veiculo);
			}
		}
	}

}
