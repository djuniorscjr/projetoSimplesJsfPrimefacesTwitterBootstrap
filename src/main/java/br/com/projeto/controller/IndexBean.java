package br.com.projeto.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class IndexBean {

	@PostConstruct
	public void init() {
		System.out.println("Bean Encontrado!");
	}

	public String getMessage() {
		return "Hello World JSF!";
	}

	public String register() {
		return "/public/cadastro.xhtml";
	}
}
