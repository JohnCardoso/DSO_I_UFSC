package br.ufsc.ine5605.trab1.display;

import java.util.Scanner;

import br.ufsc.ine5605.trab1.controllers.ControladorVeiculo;
import br.ufsc.ine5605.trab1.objects.Veiculo;

public class TelaVeiculo {

	private Scanner teclado;
	private ControladorVeiculo ctrlVeiculo;

	public TelaVeiculo(ControladorVeiculo ctrlVeiculo) {
		teclado = new Scanner(System.in);
		this.ctrlVeiculo = ctrlVeiculo;
	}

	public void exibeMenuInicialVeiculo() {

		int opcao = 0;

		System.out.println("-------------SisVeiculo-------------");
		System.out.println("1-Cadastra Veiculo");
		System.out.println("2-Exclui Veiculo");
		System.out.println("3-Altera Veiculo");
		System.out.println("4-Listar Veiculos");
		System.out.println("0-Encerra");
		System.out.println("Escolha a opcao");

		opcao = teclado.nextInt();

		while (opcao != 0) {
			switch (opcao) {
			case 1:
				/*
				 * CADASTRA VEICULO
				 */
				cadastraVeiculo();
				System.out.println("Digite a proxima opcao: ");
				opcao = teclado.nextInt();
				teclado.nextLine();
				break;
			case 2:
				/*
				 * REMOVER VEICULO
				 */
				removerVeiculo();

				System.out.println("Digite a proxima opcao: ");
				opcao = teclado.nextInt();
				teclado.nextLine();
				break;
			case 3:
				/*
				 * ALTERA VEICULO
				 */
				alteraVeiculo();

				System.out.println("Digite a proxima opcao");
				opcao = teclado.nextInt();
				teclado.nextLine();
				break;
			case 4:
				/*
				 * LISTA VEICULO
				 */
				listaVeiculos();

				System.out.println("Digite a proxima opcao: ");
				opcao = teclado.nextInt();
				teclado.nextLine();
				break;
			}
		}
	}
        private void cadastraVeiculo() {

		System.out.println("Digite a placa do veiculo a ser cadastrado (XXX-XXXX): ");
		String placa = teclado.next();
		teclado.nextLine();

		while (!ctrlVeiculo.validadePlaca(placa)
				|| ctrlVeiculo.verificaVeiculoExiste(placa)) {
			System.out.println("Digite uma placa valida e ainda não cadastrada: ");
			placa = teclado.next();
                        teclado.nextLine();
		}

		System.out.println("Digite o modelo: ");
		String modelo = teclado.nextLine();		

		System.out.println("Digite a marca do veiculo: ");
		String marca = teclado.nextLine();
				
		
		System.out.println("Digite o ano no formato YYYY: ");
		int ano = teclado.nextInt();
                
                while (!ctrlVeiculo.validadeAno(ano)) {
                    System.out.println("Digite um ano válido:");
                    ano = teclado.nextInt();
                    teclado.nextLine();
                }

		System.out.println("Digite a quilometragem atual do carro no momento deste cadastro:");
                int quilometragemAtual = teclado.nextInt();
                
                while (!ctrlVeiculo.validadeQuilometragem(quilometragemAtual)) {
                    System.out.println("Digite uma quilometragem válida:");
                    quilometragemAtual = teclado.nextInt();
                    teclado.nextLine();
                }
                        
		Veiculo veiculo = new Veiculo(placa, modelo, marca, ano, quilometragemAtual);
		ctrlVeiculo.cadastrar(veiculo);
		listaVeiculos();

	}

	private void alteraVeiculo() {
		System.out.println("Digite a placa do Veiculo a ser alterado: ");
		String placa = teclado.next();
		teclado.nextLine();

		while (!ctrlVeiculo.validadePlaca(placa)
				|| !ctrlVeiculo.verificaVeiculoExiste(placa)) {
			System.out.println("Digite uma Placa existente: ");
			placa = teclado.next();
			teclado.nextLine();
		}

		System.out.println("Digite o modelo: ");
		String modelo = teclado.nextLine();		

		System.out.println("Digite a marca do veiculo: ");
		String marca = teclado.nextLine();
				
		
		System.out.println("Digite o ano no formato YYYY: ");
		int ano = teclado.nextInt();
                
                while (!ctrlVeiculo.validadeAno(ano)) {
                    System.out.println("Digite um ano válido:");
                    ano = teclado.nextInt();
                    teclado.nextLine();
                }

		System.out.println("Atualize a quilometragem:");
                int quilometragemAtual = teclado.nextInt();
                
                while (!ctrlVeiculo.validadeQuilometragem(quilometragemAtual)) {
                    System.out.println("Digite uma quilometragem válida:");
                    quilometragemAtual = teclado.nextInt();
                    teclado.nextLine();
                }

		Veiculo veiculo = new Veiculo(placa, marca, modelo, ano, quilometragemAtual);

		ctrlVeiculo.alterar(placa, veiculo);
	}

	private void removerVeiculo() {
		System.out.println("Digite a placa do veiculo a ser removido: ");
		String placa = teclado.nextLine();

		while (!ctrlVeiculo.verificaVeiculoExiste(placa)) {
			System.out.println("Digite uma placa cadastrada: ");
			placa = teclado.nextLine();
		}

		ctrlVeiculo.excluir(placa);

	}

	private void listaVeiculos() {
		System.out.println(ctrlVeiculo.exibeListaVeiculos(ctrlVeiculo.listarVeiculos()));
	}

	
}
