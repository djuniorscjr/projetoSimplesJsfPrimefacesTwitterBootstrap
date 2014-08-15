package br.com.projeto.dao;

import java.util.List;

import br.com.projeto.model.Perfil;

public interface PerfilDao {
	
	public void save(Perfil perfil);

	public List<Perfil> getPerfils();
	
	public Perfil salvar(Perfil perfil);
	
	public void remover(Perfil perfil);

	public Perfil mudarNome(Perfil perfil);

	public Perfil retornaPorId(Long idOfPerfil);
}
