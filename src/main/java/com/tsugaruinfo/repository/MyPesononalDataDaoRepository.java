package com.tsugaruinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsugaruinfo.model.Mypersonaldata;

@Repository
public interface MyPesononalDataDaoRepository
	extends JpaRepository<Mypersonaldata, Integer> {

}
