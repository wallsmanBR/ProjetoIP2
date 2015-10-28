package br.com.dieta_saude.dados;

import br.com.dieta_saude.java_beans.Usuario;

public interface InterfaceRepositorio {
	
	void cadastrar ( Object objeto );
	
	boolean atualizar( Object objeto);
	
	Object procurar(Object objeto);
	
	boolean remover(Object objeto);
}
