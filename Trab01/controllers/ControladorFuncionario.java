package br.ufsc.ine5605.trab1.controllers;

import java.util.ArrayList;

import br.ufsc.ine5605.trab1.display.TelaFuncionario;
import br.ufsc.ine5605.trab1.interfaces.IRucd;
import br.ufsc.ine5605.trab1.objects.Funcionario;
import br.ufsc.ine5605.trab1.objects.Message;

public class ControladorFuncionario implements IRucd {

	private ArrayList<Funcionario> listaFuncionarios;
	private TelaFuncionario telaFuncionario;

	public ControladorFuncionario() {

		telaFuncionario = new TelaFuncionario(this);
		listaFuncionarios = new ArrayList<>();

	}

	public void inicia() {
		telaFuncionario.exibeMenuInicial();
	}

	public Funcionario buscarPelaMatricula(String numeroMatricula) {
		if (verificaFuncionarioExiste(numeroMatricula)) {
			for (Funcionario f : listaFuncionarios) {
				if (f.getNumeroMatricula().equals(numeroMatricula)) {
					return f;
				}
			}
		}
		return null;
	}

	public boolean validadeMatricula(String numeroMatricula) {
		boolean validade = false;

		if (numeroMatricula.matches("\\d{8}") && !numeroMatricula.equals("00000000")) {
			validade = true;
		}

		return validade;
	}

	public boolean verificaFuncionarioExiste(String numeroMatricula) {
		if (!listaFuncionarios.isEmpty()) {
			for (Funcionario f : listaFuncionarios) {
				if (f.getNumeroMatricula().equals(numeroMatricula)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void cadastrar(Object funcionario) {
		if (funcionario != null) {
			Funcionario func = (Funcionario) funcionario;
			if (!listaFuncionarios.isEmpty()) {
				if (!verificaFuncionarioExiste(func.getNumeroMatricula())) {
					listaFuncionarios.add(func);
					new Message("Funcionario cadastrado com sucesso!\n");
				}
			} else {
				listaFuncionarios.add(func);
				new Message("Funcionario cadastrado com sucesso!\n");
			}
		} else {
			new Message("Erro ao cadastrar: Funcionario nulo ou Matricula Invalida ");
		}
	}

	@Override
	public void alterar(String numeroMatricula, Object funcionario) {
		if (funcionario != null) {
			Funcionario func = (Funcionario) funcionario;
			if (!listaFuncionarios.isEmpty()) {
				for (int i = 0; i < listaFuncionarios.size(); i++) {
					if (listaFuncionarios.get(i).getNumeroMatricula().equals(func.getNumeroMatricula())) {
						listaFuncionarios.set(i, func);
						new Message("Funcionario alterado com sucesso!");
					}
				}
			}
		} else {
			new Message("Erro ao alterar: Lista Vazia/Nula, Matricula Invalida ou Funcionario Nulo");
		}
	}

	public ArrayList<Funcionario> listarFuncionarios() {
		return listaFuncionarios;
	}

	@Override
	public void excluir(String numeroMatricula) {
		if (verificaFuncionarioExiste(numeroMatricula)) {
			listaFuncionarios.remove(buscarPelaMatricula(numeroMatricula));
			new Message("Funcionario excluido com sucesso!");
		} else {
			new Message("Erro ao excluir: Lista Vazia/Nula ou Numero de Matricula Inválido");
		}
	}

	public String exibeListaFuncionarios(ArrayList<Funcionario> listaFuncionarios) {
		String listaDeFunc = "";
		if (!listaFuncionarios.isEmpty()) {
			for (Funcionario funcionario : listaFuncionarios) {
				listaDeFunc += ("\nNumero de Matricula: " + funcionario.getNumeroMatricula() + "\nNome: "
						+ funcionario.getNome() + "\nNumero de telefone: " + funcionario.getTelefone()
						+ "\nData de Nascimento: " + funcionario.getDataNascimento() + "\nCargo: "
						+ funcionario.getCargo() + "\n");
			}
		} else {
			new Message("Lista Vazia/Nula");
		}
		return listaDeFunc;
	}

	public boolean verificaNome(String nome) {

		boolean validade = false;

		if (!(nome.length() < 3)) {
			for (int i = 0; i < nome.length(); i++) {
				if (Character.isAlphabetic(nome.charAt(i)) || Character.isWhitespace(nome.charAt(i))) {
					validade = true;
				} else {
					return false;
				}
			}
		}
		return validade;
	}

	public boolean verificaCargo(String cargo) {

		boolean validade = false;

		if (!(cargo.length() < 3)) {
			for (int i = 0; i < cargo.length(); i++) {
				if (Character.isAlphabetic(cargo.charAt(i)) || Character.isWhitespace(cargo.charAt(i))) {
					validade = true;
				} else {
					return false;
				}
			}
		}
		return validade;
	}

	public boolean verificaTelefone(String telefone) {

		boolean validade = false;

		if (!(telefone.length() < 8)) {
			for (int i = 0; i < telefone.length(); i++) {
				if (Character.isDigit(telefone.charAt(i)) || Character.isWhitespace(telefone.charAt(i))
						|| (telefone.charAt(i) == '-') || (telefone.charAt(i) == '(') || (telefone.charAt(i) == ')')) {
					validade = true;
				} else {
					return false;
				}
			}
		}
		return validade;
	}

}
