package br.com.projeto.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class BasicDaoImpl {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	protected Session getSession(){
		return session;
	}
	
	private Query createQuery(String query, Object... values) {
		
		Query qr = this.session.createQuery(query);
		for(int i = 0; i < values.length; i++){
			qr.setParameter((i+1), values[i]);
		}
		
		return qr;
	}
	
	@SuppressWarnings("unchecked")
	protected <T> T addEntity(Class<T> classToCast, Object entity){
		getSession().persist(entity);
		return (T) entity;
	}
	
	@SuppressWarnings("unchecked")
	protected <T> T getEntity(Class<T> classToCast, Serializable pk){
		return (T) getSession().get(classToCast,pk);
	}
	
	@SuppressWarnings("unchecked")
	protected <T> T setEntity(Class<T> classToCast, Object entity){
		Object updateObject = session.merge(entity);
		return (T) updateObject;
	}
	
	protected void removeEntity(Object entity){
		Object updateObj = session.merge(entity);
		session.delete(updateObj);
	}
	
	@SuppressWarnings("unchecked")
	protected <T> List<T> getPureList(Class<T> classToCast, String query,
			Object... values) {
		Query qr = createQuery(query, values);
		return qr.list();
	}
	
	@SuppressWarnings("unchecked")
	protected <T> T getPurePojo (Class<T> classToCast, String query, Object... values){
		Query qr = createQuery(query, values);
		return (T) qr.getFirstResult();
	}
	
	

}
