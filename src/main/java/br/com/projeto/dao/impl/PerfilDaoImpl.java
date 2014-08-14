package br.com.projeto.dao.impl;

import org.hibernate.Session;

import br.com.projeto.dao.PerfilDao;
import br.com.projeto.model.Perfil;

public class PerfilDaoImpl implements PerfilDao {
	
	private Session session;
	 
    public void setSession(Session session) {
        this.session = session;
    }
     
    @Override
    public void save(Perfil perfil) {
        this.session.saveOrUpdate(perfil);
    }
}
