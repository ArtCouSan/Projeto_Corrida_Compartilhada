package com.corrida.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "TB_PASSAGEIRO")
public class Passageiro {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PASSAGEIRO")
	private Long Id;

	@NotBlank(message = "O nome é obrigatario!")
	@Size(max = 200, message = "O nome deve conter no maximo 200 caracteres!")
	@Column(name = "PASSAGEIRO_NOME", length = 200)
	private String nome;

	@NotBlank(message = "A data de nascimento é obrigataria!")
	@Size(max = 20)
	@Column(name = "PASSAGEIRO_DTNASCIMENTO", length = 20)
	private String dtNascimento;

	@org.hibernate.validator.constraints.br.CPF
	@NotBlank(message = "O cpf é obrigatario!")
	@Column(name = "MOTORISTA_CPF", length = 20)
	private String CPF;

	@NotBlank(message = "O sexo é obrigatario!")
	@Column(name = "MOTORISTA_SEXO", length = 50)
	private String sexo;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
