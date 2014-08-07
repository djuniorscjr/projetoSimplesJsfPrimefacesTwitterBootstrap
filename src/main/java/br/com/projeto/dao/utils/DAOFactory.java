package br.com.projeto.dao.utils;

import br.com.projeto.dao.PerfilDao;
import br.com.projeto.dao.impl.PerfilDaoImpl;

public class DAOFactory {
	
	public static PerfilDao createPerfil(){
        PerfilDaoImpl perfilDaoImpl = new PerfilDaoImpl();
        perfilDaoImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return perfilDaoImpl;
    }
}
