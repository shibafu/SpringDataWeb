package com.tsugaruinfo.dao;

import java.util.List;

public interface MyPersonDataDao<T> {

	public List<T> getAllEntity();
	public List<T> findByField(String field, String find);
	public void updateEntity(T entity);
	public void addEntity(T data);
	public void removeEntity(T data);
}
