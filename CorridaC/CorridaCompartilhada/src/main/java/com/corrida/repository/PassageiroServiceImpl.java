package com.corrida.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.corrida.entity.Passageiro;
import com.corrida.service.PassageiroService;

@SuppressWarnings("serial")
@Repository
public class PassageiroServiceImpl implements PassageiroService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private PassageiroRepository repository;
	
	@Override
	public List<Passageiro> listar() {

		Iterable<Passageiro> passageiros = repository.findAll();

		Iterator<Passageiro> it = passageiros.iterator();

		List<Passageiro> lista = new ArrayList<Passageiro>();

		while (it.hasNext()) {
			Passageiro c = (Passageiro) it.next();
			lista.add(c);
		}

		return lista;
	}

	@Override
	public Passageiro obter(Long id) {
		return repository.findOne(id);
	}

	@Override
	@Transactional
	public void incluir(Passageiro passageiro) {
		entityManager.persist(passageiro);

	}

	@Override
	@Transactional
	public void alterar(Passageiro passageiro) {
		entityManager.merge(passageiro);
	}

	@Override
	@Transactional
	public void remover(Long codigoPassageiro) {

		Passageiro  c = entityManager.find(Passageiro.class, codigoPassageiro);

		entityManager.remove(c);	
		
	}

}
