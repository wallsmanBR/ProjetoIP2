package br.com.dieta_saude.dados;

import br.com.dieta_saude.java_beans.Dieta;

public class RepositorioDieta extends RepositorioGenerico implements InterfaceRepositorioDieta {

	public RepositorioDieta(int tamanho) {
		super((Object[]) new Dieta[tamanho]);
	}

	@Override
	public void cadastrar(Dieta dieta) {
		super.cadastrar(dieta);

	}

	
	public boolean remover(Dieta aRemover) {
		int id = aRemover.getId();
		int i = this.procurarIndice(id);
		if (i != this.proxima) {
			this.arrayDeDados[i] = this.arrayDeDados[this.proxima - 1];
			this.arrayDeDados[this.proxima - 1] = null;
			this.proxima = this.proxima - 1;
			return true;
			// System.out.println("Dieta com id: "+ this.dieta[i].getId() + "
			// removida.");
		} else {
			return false;
			// System.out.println("Dieta n�o existe.");
		}
	}
	

	public boolean atualizar(Object objeto) {
		Dieta atualizador = (Dieta) objeto;
		int i = this.procurarIndice(atualizador.getId());
		if (i != this.proxima) {
			((Dieta) this.arrayDeDados[i]).setPeriodoEmDiasDaDieta(atualizador.getPeriodoEmDiasDaDieta());
			return true;
		} else {
			return false;
			// System.out.println("Dieta n�o existe.");
		}
	}

	
	public Object procurar(Object dieta) {
		Dieta procurado = (Dieta) dieta;
		int i = this.procurarIndice(procurado.getId());
		Dieta resultado = null;
		if (i != this.proxima) {
			resultado = (Dieta) this.arrayDeDados[i];
		}
		return resultado;
	}
	
	
	public int procurarIndice(int id) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < this.proxima)) {
			if (id == ((Dieta) this.arrayDeDados[i]).getId()) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		return i;
	}

}
