package com.corrida.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.corrida.entity.Motorista;
import com.corrida.service.MotoristaService;

@SuppressWarnings("serial")
@Repository
public class MotoristaServiceImpl implements MotoristaService{

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private MotoristaRepository repository;

	@Override
	public List<Motorista> listar() {
		
		Iterable<Motorista> motoristas = repository.findAll();

		Iterator<Motorista> it = motoristas.iterator();

		List<Motorista> lista = new ArrayList<Motorista>();

		while (it.hasNext()) {
			Motorista c = (Motorista) it.next();
			lista.add(c);
		}

		return lista;
	}

	@Override
	public Motorista obter(Long id) {
		return repository.findOne(id);
	}

	@Override
	@Transactional
	public void incluir(Motorista motorista) {
		entityManager.persist(motorista);
	}

	@Override
	@Transactional
	public void alterar(Motorista motorista) {
		entityManager.merge(motorista);
	}

	@Override
	@Transactional
	public void remover(Long codigoMotorista) {
		
		Motorista c = entityManager.find(Motorista.class, codigoMotorista);

		entityManager.remove(c);		
				
	}
	
}
