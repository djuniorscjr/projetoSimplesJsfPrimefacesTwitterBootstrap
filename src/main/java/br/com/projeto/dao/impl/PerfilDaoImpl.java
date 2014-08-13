package br.com.projeto.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.projeto.dao.PerfilDao;
import br.com.projeto.model.Perfil;

public class PerfilDaoImpl implements PerfilDao {
	
	private Session session;
	 
    public void setSession(Session session) {
        this.session = session;
    }
     
    @Override
    @Transactional
    public void save(Perfil perfil) {
    	Transaction trans=session.beginTransaction();    	  
        this.session.saveOrUpdate(perfil);
        trans.commit();
    }
}
