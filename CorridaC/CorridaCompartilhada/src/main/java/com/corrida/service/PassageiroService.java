package com.corrida.service;

import java.io.Serializable;
import java.util.List;

import com.corrida.entity.Passageiro;

public interface PassageiroService extends Serializable{

	public List<Passageiro> listar();
	
	public Passageiro obter(Long id);
	
	public void incluir(Passageiro curso);
	
	public void alterar(Passageiro curso);
	
	public void remover(Long codigoPassageiro);
	
}
