package br.com.projeto.dao.impl;

import java.util.List;

import br.com.projeto.dao.PerfilDao;
import br.com.projeto.model.Perfil;

public class PerfilDaoImpl extends BasicDaoImpl implements PerfilDao{
     
    @Override
    public void save(Perfil perfil) {
        getSession().saveOrUpdate(perfil);
    }
    
    public List<Perfil> getPerfils(){
    	return getPureList(Perfil.class, "select perfil from Perfil perfil");
    }
    
    public Perfil salvar(Perfil perfil){
    	addEntity(Perfil.class, perfil);
    	return perfil;
    }

	@Override
	public void remover(Perfil perfil) {
		removeEntity(perfil);
		
	}

	@Override
	public Perfil mudarNome(Perfil perfil) {
		return setEntity(Perfil.class, perfil);
	}

	@Override
	public Perfil retornaPorId(Long idOfPerfil) {
		
		return getEntity(Perfil.class, idOfPerfil);
	}
	
	
}
