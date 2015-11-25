package br.com.dieta_saude.dados;

import br.com.dieta_saude.java_beans.Dieta;

public interface InterfaceRepositorioDieta extends InterfaceGenerica{

	void cadastrar(Dieta dieta);
	
	boolean remover(Dieta dietaARemover);

}
