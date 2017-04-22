package br.ufsc.ine5605.trab1.controllers;

import java.util.ArrayList;

import br.ufsc.ine5605.trab1.display.TelaVeiculo;
import br.ufsc.ine5605.trab1.interfaces.IRucd;
import br.ufsc.ine5605.trab1.objects.Veiculo;
import br.ufsc.ine5605.trab1.objects.Message;

public class ControladorVeiculo implements IRucd {

	private ArrayList<Veiculo> listaVeiculos;
	private TelaVeiculo telaVeiculo;

	public ControladorVeiculo() {

		telaVeiculo = new TelaVeiculo(this);
		listaVeiculos = new ArrayList<>();

	}

	public void inicia() {
		telaVeiculo.exibeMenuInicialVeiculo();
	}
        
        public Veiculo buscarPelaPlaca(String placa) {
		if (verificaVeiculoExiste(placa)) {
			for (Veiculo v : listaVeiculos) {
				if (v.getPlaca().equals(placa)) {
					return v;
				}
			}
		}
		return null;
        }

	public ArrayList<Veiculo> listarVeiculos() {
		return listaVeiculos;
	}

	public String exibeListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
                String listaDeVeic = "";
		if (listaVeiculos != null) {
			if (!listaVeiculos.isEmpty()) {
				for (Veiculo veiculo : listaVeiculos) {
					listaDeVeic += ("\nPlaca: " + veiculo.getPlaca() + "\nModelo: " + veiculo.getModelo()
							+ "\nMarca: " + veiculo.getMarca() + "\nAno: " + veiculo.getAno()
							+ "\nQuilometragem Atual: " + veiculo.getQuilometragemAtual() + "\n");
				}
			}
		} else {
                    new Message("Lista Vazia ou Nula");
                }
                return listaDeVeic;
	}

	@Override
	public void cadastrar(Object veiculo) {
		if (veiculo != null) {
			Veiculo veic = (Veiculo) veiculo;
			if (!listaVeiculos.isEmpty()) {
				if (!listaVeiculos.contains(veic)) {
					listaVeiculos.add(veic);
					new Message("Veiculo cadastrado com sucesso!\n");					
				}
                        } else {
                            listaVeiculos.add(veic);
                            new Message("Veiculo cadastrado com sucesso!\n");
                        }
                } else {
                    new Message("Erro ao cadastrar: Veiculo nulo");
                }		
	}

	@Override
	public void alterar(String placa, Object veiculo) {
		if (veiculo != null) {
		} else {
                    new Message("Erro ao alterar: Lista Vazia/Nula ou Veiculo inexistente");
                }
		
	}

	@Override
	public void excluir(String placa) {
            if (verificaVeiculoExiste(placa)) {
			listaVeiculos.remove(buscarPelaPlaca(placa));
			new Message("Veiculo removido com sucesso!");
		} else {
			new Message("Erro ao remover: Lista Vazia/Nula ou placa não cadastrada!");
		}
	}

	public boolean validadePlaca(String placa) {
		boolean validade = false;

		if (placa.matches("[a-zA-Z]{3}-\\d{4}") && !placa.substring(3, 6).equals("0000")) {
			validade = true;
		}

		return validade;
	}
        
        public boolean verificaVeiculoExiste(String placa) {
		if (!listaVeiculos.isEmpty()) {
			for (Veiculo v : listaVeiculos) {
				if (v.getPlaca().equals(placa)) {
					return true;
				}
			}
		}
		return false;
	}
        
        public boolean validadeAno(int ano) {
		boolean validAno = false;

		if (ano <= 2017 && ano >= 1990) {
			validAno = true;
		}

		return validAno;
	}
        
        public boolean validadeQuilometragem(int quilometragemAtual) {
		boolean validKm= false;

		if (quilometragemAtual >= 0 && quilometragemAtual <= 200000) {
			validKm = true;
		}

		return validKm;
	}

}
