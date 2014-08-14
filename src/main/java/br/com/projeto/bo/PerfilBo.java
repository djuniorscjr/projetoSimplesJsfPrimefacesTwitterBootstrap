package br.com.projeto.bo;

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
 
    public void save(Perfil perfil){
        perfilDao.save(perfil);
    }    
}
