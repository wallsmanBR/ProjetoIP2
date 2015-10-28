package controladorDeUsuario;

import br.com.dieta_saude.dados.RepositorioAlimento;
import br.com.dieta_saude.dados.RepositorioUsuario;
import br.com.dieta_saude.java_beans.Alimento;
import br.com.dieta_saude.java_beans.Usuario;

public class ControladorDeAlimentos {
	
	public ControladorDeAlimentos()
	{
		
	}
	
	// ISugestao
	 public boolean verificaExistenciaDeAlimento(Alimento alimento, RepositorioAlimento repositorio)
		{
			boolean resultado = false;
			if (repositorio.procurar(alimento.getNome()) != null)
				resultado = true;
			
			return resultado;
		}
	// FSugestao
	
	/*
	public boolean verificaExistenciaDeAlimento(String nome, RepositorioAlimento repositorio)
	{
		boolean resultado = false;
		if (repositorio.procurar(nome) != null)
			resultado = true;
		
		return resultado;
	}
	*/
	
	public boolean adicionaAlimentos(Alimento alimento, 
			RepositorioAlimento repositorio)
	{
		boolean resultado = false;
		boolean verificador = verificaExistenciaDeAlimento(alimento, repositorio);
		
		// Alimento teste = new Alimento(nome, pontos);
	
		if (verificador == false){
			repositorio.cadastrar(alimento);
			resultado = true;
		}
		
		return resultado;
	}
	
	
	
	
}
