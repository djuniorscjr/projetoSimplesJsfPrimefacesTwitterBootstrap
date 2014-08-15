package br.com.projeto.bo;

import java.util.List;

import br.com.projeto.dao.PerfilDao;
import br.com.projeto.dao.utils.DAOFactory;
import br.com.projeto.model.Perfil;

public class PerfilBo {

	private PerfilDao perfilDao;

	public PerfilBo() {
		super();
		setPerfilDao(DAOFactory.createPerfil());
	}
	
	private void setPerfilDao(PerfilDao perfilDao) {
        this.perfilDao = perfilDao;
    }
	
	public void save(Perfil perfil) {
		perfilDao.save(perfil);
	}
	
	/**
	 * 	Utilizando BasicDaoImpl
	 * 	
	 */
	public Perfil salvar(Perfil perfil){
		return perfilDao.salvar(perfil);
	}
	
	public void remover(Perfil perfil) {
		perfilDao.remover(perfil);
	}

	public Perfil mudarNome(Perfil perfil) {
		return perfilDao.mudarNome(perfil);
	}

	public Perfil retornaPorId(Long idOfPerfil) {
		return perfilDao.retornaPorId(idOfPerfil);
	}
	
	public List<Perfil> getPerfis() {

		return perfilDao.getPerfils();
	}
}
