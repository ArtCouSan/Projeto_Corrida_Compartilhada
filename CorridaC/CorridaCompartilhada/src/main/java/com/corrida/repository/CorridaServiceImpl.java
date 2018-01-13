package com.corrida.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.corrida.entity.Corrida;
import com.corrida.service.CorridaService;

@SuppressWarnings("serial")
@Repository
public class CorridaServiceImpl implements CorridaService{


	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private CorridaRepository repository;

	@Override
	public List<Corrida> listar() {
		
		Iterable<Corrida> corridas = repository.findAll();

		Iterator<Corrida> it = corridas.iterator();

		List<Corrida> lista = new ArrayList<Corrida>();

		while (it.hasNext()) {
			Corrida c = (Corrida) it.next();
			lista.add(c);
		}

		return lista;
	}

	@Override
	@Transactional
	public void remover(Long codigoCorrida) {
		
		Corrida c = entityManager.find(Corrida.class, codigoCorrida);

		entityManager.remove(c);		
				
	}

	@Override
	public Corrida obter(Long id) {
		return repository.findOne(id);
	}

	@Override
	@Transactional
	public void incluir(Corrida corrida) {
		entityManager.persist(corrida);
	}

	@Override
	@Transactional
	public void alterar(Corrida corrida) {
		entityManager.merge(corrida);
		
	}

	
}
