package com.tsugaruinfo.dao;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.tsugaruinfo.model.Mypersonaldata;

public abstract class AbstractMyPersnalDataDao implements MyPersonDataDao<Mypersonaldata> {

	public void init() {
		SpringBeanAutowiringSupport
			.processInjectionBasedOnCurrentContext(this);
	}

}
