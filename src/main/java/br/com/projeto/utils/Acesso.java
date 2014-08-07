package br.com.projeto.utils;

public enum Acesso {
	
	ACESSO_ADMIN("ADMINISTRADOR"),
	ACESSO_COMUM("USUARIO COMUM");
	
	private String value;
	
	private Acesso(String value){
		this.value = value;	
	}

	public String getValue() {
		return value;
	}

}
