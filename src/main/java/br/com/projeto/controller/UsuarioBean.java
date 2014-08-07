package br.com.projeto.controller;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.projeto.bo.PerfilBo;
import br.com.projeto.model.Perfil;
import br.com.projeto.model.Usuario;
import br.com.projeto.utils.Acesso;
import br.com.projeto.utils.GenerateValidation;
import br.com.projeto.utils.ManipulateDate;
import br.com.projeto.utils.security.GenerateMD5;
 

@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean {
 
    private Usuario usuario = null;
    private Perfil perfil = null;
 
    private int day = 0;
    private int month = 0;
    private int year = 0;
 
    @PostConstruct
    public void init() {
    	usuario = new Usuario();
    	perfil = new Perfil();
    }
 
    public String save() {
 
    	PerfilBo perfilBo = new PerfilBo();
 
    	usuario.setSenha(GenerateMD5.generate(usuario.getSenha()));
    	usuario.setValidacao(GenerateValidation.keyValidation());
    	usuario.getPermissoes().add(Acesso.ACESSO_COMUM.getValue());
    	usuario.setAtivado(false);
         
        perfil.setUsuario(usuario);
        perfil.setDataDeNascimento(ManipulateDate.getDate(year, month, day));
 
        perfilBo.save(perfil);
        return "/public/feedback_cadastro";
    }
 
    public Map<String, Object> getDays() {
        return ManipulateDate.getDays();
    }
 
    public Map<String, Object> getMonths() {
        return ManipulateDate.getMonths();
    }
 
    public Map<String, Object> getYears() {
        return ManipulateDate.getYears();
    }
 
    public int getDay() {
        return day;
    }
 
    public void setDay(int day) {
        this.day = day;
    }
 
    public int getMonth() {
        return month;
    }
 
    public void setMonth(int month) {
        this.month = month;
    }
 
    public int getYear() {
        return year;
    }
 
    public void setYear(int year) {
        this.year = year;
    }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
}
