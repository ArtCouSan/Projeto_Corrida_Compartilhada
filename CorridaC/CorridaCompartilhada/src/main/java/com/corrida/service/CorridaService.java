package com.corrida.service;

import java.io.Serializable;
import java.util.List;

import com.corrida.entity.Corrida;

public interface CorridaService extends Serializable {

	public List<Corrida> listar();
	
	public Corrida obter(Long id);
	
	public void incluir(Corrida corrida);
	
	public void alterar(Corrida corrida);
	
	public void remover(Long codigoCorrida);
	
}
