package br.ufsc.ine5605.trab1.display;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import br.ufsc.ine5605.trab1.controllers.ControladorFuncionario;
import br.ufsc.ine5605.trab1.objects.Funcionario;

public class TelaFuncionario {

	private Scanner teclado;
	private ControladorFuncionario ctrlFuncionario;

	public TelaFuncionario(ControladorFuncionario ctrlFuncionario) {
		teclado = new Scanner(System.in);
		this.ctrlFuncionario = ctrlFuncionario;
	}

	public void exibeMenuInicial() {

		int opcao = 0;

		System.out.println("-------------SisFuncionario-------------");
		System.out.println("1-Cadastra Funcionario");
		System.out.println("2-Exclui Funcionario");
		System.out.println("3-Altera Funcionario");
		System.out.println("4-Listar Funcionarios");
		System.out.println("0-Encerra");
		System.out.println("Escolha a opcao");

		opcao = teclado.nextInt();

		while (opcao != 0) {
			switch (opcao) {
			case 1:
				/*
				 * CADASTRA FUNCIONARIO
				 */
				cadastraFuncionario();
				System.out.println("Digite a proxima opcao: ");
				opcao = teclado.nextInt();
				break;
			case 2:
				/*
				 * REMOVER FUNCIONARIO
				 */
				removerFuncionario();

				System.out.println("Digite a proxima opcao: ");
				opcao = teclado.nextInt();
				break;
			case 3:
				/*
				 * ALTERA FUNCIONARIO
				 */
				alteraFuncionario();

				System.out.println("Digite a proxima opcao");
				opcao = teclado.nextInt();
				break;
			case 4:
				/*
				 * LISTA FUNCIONARIO
				 */
				listaFuncionarios();

				System.out.println("Digite a proxima opcao: ");
				opcao = teclado.nextInt();
				break;
			}
		}
	}

	private void alteraFuncionario() {
		System.out.println("Digite a matricula do funcionario a ser alterado: ");
		String numeroMatricula = teclado.next();

		while (!ctrlFuncionario.validadeMatricula(numeroMatricula)
				|| !ctrlFuncionario.verificaFuncionarioExiste(numeroMatricula)) {
			System.out.println("Digite uma matricula existente: ");
			numeroMatricula = teclado.next();
		}

		System.out.println("Digite o nome: ");
		String nome = teclado.next();

		while (!ctrlFuncionario.verificaNome(nome)) {
			System.out.println("Digite um nome valido: ");
			nome = teclado.next();
		}

		System.out.println("Digite o numero do telefone: ");
		String telefone = teclado.next();

		while (!ctrlFuncionario.verificaTelefone(telefone)) {
			System.out.println("Digite um numero de telefone valido: ");
			telefone = teclado.next();
		}

		System.out.println("Digite a data de nascimento em formato dd/MM/aaaa: ");
		String dataDeNascimento = teclado.next();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNascimento = null;
		try {
			dataNascimento = sdf.parse(dataDeNascimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Digite o cargo: ");
		String cargo = teclado.next();

		while (!ctrlFuncionario.verificaCargo(cargo)) {
			System.out.println("Digite um cargo valido: ");
			cargo = teclado.next();
		}

		Funcionario funcionario = new Funcionario(numeroMatricula, nome, dataNascimento, telefone, cargo);

		ctrlFuncionario.alterar(numeroMatricula, funcionario);
	}

	private void removerFuncionario() {
		System.out.println("Digite a matricula do funcionario a ser apagado: ");
		String numeroMatricula = teclado.next();

		while (!ctrlFuncionario.verificaFuncionarioExiste(numeroMatricula)) {
			System.out.println("Digite uma matricula existente: ");
			numeroMatricula = teclado.next();
		}

		ctrlFuncionario.excluir(numeroMatricula);

	}

	private void listaFuncionarios() {
		System.out.println(ctrlFuncionario.exibeListaFuncionarios(ctrlFuncionario.listarFuncionarios()));
	}

	private void cadastraFuncionario() {

		System.out.println("Digite um numero de matricula desejado que tenha 8 numeros: ");
		String numeroMatricula = teclado.next();

		while (!ctrlFuncionario.validadeMatricula(numeroMatricula)
				|| ctrlFuncionario.verificaFuncionarioExiste(numeroMatricula)) {
			System.out.println("Digite uma matricula valida e inexistente: ");
			numeroMatricula = teclado.next();
		}

		System.out.println("Digite o nome: ");
		String nome = teclado.next();

		while (!ctrlFuncionario.verificaNome(nome)) {
			System.out.println("Digite um nome valido: ");
			nome = teclado.next();
		}

		System.out.println("Digite o numero de telefone: ");
		String telefone = teclado.next();

		while (!ctrlFuncionario.verificaTelefone(telefone)) {
			System.out.println("Digite um numero de telefone valido: ");
			telefone = teclado.next();
		}

		System.out.println("Digite a data de nascimento em formato dd/MM/aaaa: ");
		String dataDeNascimento = teclado.next();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNascimento = null;
		try {
			dataNascimento = sdf.parse(dataDeNascimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Digite o cargo: ");
		String cargo = teclado.next();

		while (!ctrlFuncionario.verificaCargo(cargo)) {
			System.out.println("Digite um cargo valido: ");
			cargo = teclado.next();
		}

		Funcionario funcionario = new Funcionario(numeroMatricula, nome, dataNascimento, telefone, cargo);
		ctrlFuncionario.cadastrar(funcionario);
		listaFuncionarios();

	}
}
