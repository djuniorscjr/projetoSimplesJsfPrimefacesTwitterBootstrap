package br.com.projeto.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NaturalId;
 
@Entity
public class Perfil {
 
    @Id
    private Long id;
    private String nome;
    private String sobreNome;
    @NaturalId
    private String email;
    private String sexo;
    private Date dataDeNascimento;
 
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Usuario usuario;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
 
 
}