package com.corrida.repository;

import org.springframework.data.repository.CrudRepository;

import com.corrida.entity.Passageiro;

public interface PassageiroRepository extends CrudRepository<Passageiro, Long> {

}
