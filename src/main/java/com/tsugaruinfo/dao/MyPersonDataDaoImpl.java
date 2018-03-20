package com.tsugaruinfo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tsugaruinfo.model.Mypersonaldata;

@Component
public class MyPersonDataDaoImpl extends AbstractMyPersnalDataDao{

	@PersistenceContext
	private EntityManager manager;
	
	public MyPersonDataDaoImpl() {
		init();
	}
	
	@Override
	public List<Mypersonaldata> getAllEntity() {
		// TODO 自動生成されたメソッド・スタブ
		Query query = manager.createNamedQuery("Mypersonaldata.getAllEntity");
		return query.getResultList();
	}

	@Override
	public List<Mypersonaldata> findByField(String field, String find) {
		// TODO 自動生成されたメソッド・スタブ
		Query query = manager.createQuery("FROM Mypersonaldata WHERE " + field + " = '" + find + "'");
		return query.getResultList();
	}
	
	public List<Mypersonaldata> findByName(String name) {
		// TODO 自動生成されたメソッド・スタブ
		Query query = manager.createNamedQuery("Mypersonaldata.findByName")
				.setParameter("value", name);
		return query.getResultList();
	}

	@Transactional
	@Override
	public void updateEntity(Mypersonaldata entity) {
		// TODO 自動生成されたメソッド・スタブ
		manager.merge(entity);
		manager.flush();
	}
	
	@Transactional
	@Override
	public void addEntity(Mypersonaldata data) {
		// TODO 自動生成されたメソッド・スタブ
		manager.persist(data);
		manager.flush();
	}

	@Transactional
	@Override
	public void removeEntity(Mypersonaldata data) {
		// TODO 自動生成されたメソッド・スタブ
		manager.remove(data);
		manager.flush();
	}
	
	@Transactional
	public void removeEntity(int id) {
		// TODO 自動生成されたメソッド・スタブ
		
		com.tsugaruinfo.model.Mypersonaldata rm_data = manager.find(com.tsugaruinfo.model.Mypersonaldata.class, id);
		removeEntity((Mypersonaldata)rm_data);
		
	}

}
