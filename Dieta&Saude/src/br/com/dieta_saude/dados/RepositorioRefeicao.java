package br.com.dieta_saude.dados;

import br.com.dieta_saude.java_beans.Refeicao;

public class RepositorioRefeicao extends RepositorioGenerico implements InterfaceRepositorioRefeicao {

	public RepositorioRefeicao(int tamanho) {
		super((Object[]) new Refeicao[tamanho]);
	}

	public void cadastrar(Refeicao refeicao) {
		super.cadastrar(refeicao);
	}

	public boolean remover(Refeicao refeicaoARemover) {
		int id = refeicaoARemover.getId();
		int i = this.procurarIndice(id);
		if (i != this.proxima) {
			this.arrayDeDados[i] = this.arrayDeDados[this.proxima - 1];
			this.arrayDeDados[this.proxima - 1] = null;
			this.proxima = this.proxima - 1;
			return true;
			// System.out.println("Refei��o com id: "+ this.refeicoes[i].getId()
			// + " removida.");
		} else {
			return false;
			// System.out.println("Refei��o n�o existe.");
		}
	}

	// ccl
	public boolean atualizar(Object objeto) {
		Refeicao atualizador = (Refeicao) objeto;
		int i = this.procurarIndice(atualizador.getId());
		if (i != this.proxima) {
			((Refeicao) this.arrayDeDados[i]).setPontos(atualizador.getPontos());
			return true;
		} else {
			return false;
		}
	}

	// ccl
	public Object procurar(Object objeto) {
		Refeicao procurado = (Refeicao) objeto;
		int i = this.procurarIndice(procurado.getId());
		Refeicao resultado = null;
		if (i != this.proxima) {
			resultado = (Refeicao) this.arrayDeDados[i];
		}
		return resultado;
	}

	public int procurarIndice(int id) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < this.proxima)) {
			if (id == ((Refeicao) this.arrayDeDados[i]).getId()) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		return i;
	}

}
