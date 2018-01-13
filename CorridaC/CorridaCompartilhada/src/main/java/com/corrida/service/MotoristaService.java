package com.corrida.service;

import java.io.Serializable;
import java.util.List;

import com.corrida.entity.Motorista;

public interface MotoristaService extends Serializable{

	public List<Motorista> listar();
	
	public Motorista obter(Long id);
	
	public void incluir(Motorista motorista);
	
	public void alterar(Motorista motorista);
	
	public void remover(Long motorista);
	
}
