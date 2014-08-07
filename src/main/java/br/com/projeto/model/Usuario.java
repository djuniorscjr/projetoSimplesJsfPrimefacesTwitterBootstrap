package br.com.projeto.model;

import java.util.HashSet;
import java.util.Set;
 

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

 
@Entity
@Table(name="usuario")
@SequenceGenerator(name = "seq", sequenceName = "seq_usuario", allocationSize = 1, initialValue = 1)
public class Usuario{
     
    @Id
    @GeneratedValue(generator="seq")
    private Long id;
    private String senha;    
    private Boolean ativado;
    private String validacao;
    
	@ElementCollection(targetClass = String.class)
    @JoinTable(name = "usuario_permissao",
               uniqueConstraints = { @UniqueConstraint (columnNames = {"id", "permissao" })},
               joinColumns = @JoinColumn(name = "id"))
    @Column(name = "permissao", length = 40)
    @Cascade(CascadeType.DELETE)
    private Set<String> permissoes = new HashSet<String>();    
 

    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }    
    
    public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAtivado() {
		return ativado;
	}

	public void setAtivado(Boolean ativado) {
		this.ativado = ativado;
	}

	public String getValidacao() {
		return validacao;
	}

	public void setValidacao(String validacao) {
		this.validacao = validacao;
	}

	public Set<String> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(Set<String> permissoes) {
		this.permissoes = permissoes;
	}
}