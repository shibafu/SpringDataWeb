package com.tsugaruinfo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsugaruinfo.model.Mypersonaldata;

@Repository
public interface MyPesononalDataDaoRepository
	extends JpaRepository<Mypersonaldata, Integer> {

	public List<Mypersonaldata> findByName(String name);
	public List<Mypersonaldata> findByMail(String mail);
	public List<Mypersonaldata> findByAge(int age);
	public List<Mypersonaldata> findByNameLike(String name);
	public List<Mypersonaldata> findByMailLike(String mail);
	public List<Mypersonaldata> findByNameOrMail(String name, String mail);
	public List<Mypersonaldata> findByNameLikeOrMailLike(String name, String mail);
	
	public List<Mypersonaldata> findByAgeGreaterThan(Integer age);
	public List<Mypersonaldata> findByAgeLessThan(Integer age);
	public List<Mypersonaldata> findByAgeGreaterThanOrAgeLessThan(Integer age0, Integer age1);
 }
