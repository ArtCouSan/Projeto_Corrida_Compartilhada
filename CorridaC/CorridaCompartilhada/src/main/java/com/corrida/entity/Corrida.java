package com.corrida.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_CORRIDA")
public class Corrida {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CORRIDA")
	private Long Id;
	
	@NotNull
	@Column(name = "CORRIDA_MOTORISTA")
	private Long IdMotorista;
	
	@NotNull
	@Column(name = "CORRIDA_PASSAGEIRO")
	private Long IdPassageiro;
	
	@NotNull
	@Column(name = "CORRIDA_VALOR")
	private BigDecimal valor;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getIdMotorista() {
		return IdMotorista;
	}

	public void setIdMotorista(Long idMotorista) {
		IdMotorista = idMotorista;
	}

	public Long getIdPassageiro() {
		return IdPassageiro;
	}

	public void setIdPassageiro(Long idPassageiro) {
		IdPassageiro = idPassageiro;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
