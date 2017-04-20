package br.ufsc.ine5605.trab1.controllers;

import java.util.ArrayList;

import br.ufsc.ine5605.trab1.display.TelaVeiculo;
import br.ufsc.ine5605.trab1.interfaces.IRucd;
import br.ufsc.ine5605.trab1.objects.Veiculo;

public class ControladorVeiculo implements IRucd {

	private ArrayList<Veiculo> listaVeiculos;
	private TelaVeiculo telaVeiculo;

	public ControladorVeiculo() {

		telaVeiculo = new TelaVeiculo(this);
		listaVeiculos = new ArrayList<>();

	}

	public void inicia() {
		telaVeiculo.exibeMenuInicial();
	}

	public ArrayList<Veiculo> listarVeiculos() {
		return listaVeiculos;
	}

	public String exibeListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
		if (listaVeiculos != null) {
			if (!listaVeiculos.isEmpty()) {
				for (Veiculo veiculo : listaVeiculos) {
					return ("\nDigitos da placa: " + veiculo.getPlaca() + "\nModelo: " + veiculo.getModelo()
							+ "\nMarca: " + veiculo.getMarca() + "\nAno: " + veiculo.getAno()
							+ "\nQuilometragem Atual: " + veiculo.getQuilometragemAtual());
				}
			}
		}
		return "Lista Vazia ou Nula";
	}

	@Override
	public void cadastrar(Object veiculo) {
		if (veiculo != null) {
			Veiculo veic = (Veiculo) veiculo;
			if (!listaVeiculos.isEmpty()) {
				if (!listaVeiculos.contains(veic)) {
					listaVeiculos.add(veic);
					System.out.println("Veiculo cadastrado com sucesso!\n");
					exibeListaVeiculos(listaVeiculos);
				}
			}
			listaVeiculos.add(veic);
			System.out.println("Veiculo cadastrado com sucesso!\n");
			exibeListaVeiculos(listaVeiculos);
		}
		System.out.println("Erro ao cadastrar: Veiculo nulo");
	}

	@Override
	public void alterar(String placa, Object veiculo) {
		if (veiculo != null) {
			Veiculo veic = (Veiculo) veiculo;
			if (codigo != 0) {
				if (!listaVeiculos.isEmpty()) {
					for (Veiculo veiculoAlterar : listaVeiculos) {
						if (veiculoAlterar.getCodigo() == codigo) {
							listaVeiculos.set(codigo - 1, veic);
							break;
						}
					}
				}
			}
		}
		System.out.println("Erro ao alterar: Lista Vazia/Nula ou Veiculo Nulo");
	}

	@Override
	public void excluir(String placa) {
		if (codigo != 0) {
			if (!listaVeiculos.isEmpty()) {
				for (Veiculo veiculoExcluir : listaVeiculos) {
					if (veiculoExcluir.getCodigo() == codigo) {
						listaVeiculos.remove(veiculoExcluir);
						break;
					}
				}
			}
		}
	}

	public boolean validadePlaca(String placa) {
		boolean validade = false;

		if (placa.matches("[a-zA-Z]{3}-\\d{4}") && !placa.substring(3, 6).equals("0000")) {
			validade = true;
		}

		return validade;
	}

}
