package com.agendamento.consulta.medico;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.agendamento.consulta.consultorio.ConsultorioEntity;
import com.agendamento.consulta.util.SexoEnum;

@Entity
@Table(name = "MEDICOS" )
public class MedicoEntity {

	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "idMedico", nullable = false, length = 255, insertable = true, updatable = true)
    private UUID idMedico;
	
	@Column
	private String nome;
	
	@Column
	private String sobrenome;
	
	@Column
	private SexoEnum sexo;
	
	@Column
	private String email;
	
	@Column
	private String telefone;
	
	@Column
	private String cep;
	
	@Column
	private String endereco;
	
	@Column
	private String numero;
	
	@Column
	private String complemento;
	
	@Column
	private String cidade;
	
	@Column
	private String estado;
	
	@Column
	private String rg;
	
	@Column
	private String cri;
	
	@Column
	private String cro;
	
	@Column
	private String especializacao;
	
	@ManyToMany(mappedBy="medicos", cascade = CascadeType.ALL)
	public List<ConsultorioEntity> consultorios;

	
	public String getEspecializacao() {
		return especializacao;
	}
	
	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}
	
	public String getCri() {
		return cri;
	}
	
	public void setCri(String cri) {
		this.cri = cri;
	}
	
	public String getCro() {
		return cro;
	}
	
	public void setCro(String cro) {
		this.cro = cro;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public UUID getIdMedico() {
		return idMedico;
	}
	
	public void setIdMedico(UUID idMedico) {
		this.idMedico = idMedico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
