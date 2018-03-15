package com.tsugaruinfo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.tsugaruinfo.repository.MyPesononalDataDaoRepository;

public class BeanAutowiringFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("ちぇっく");
		SpringBeanAutowiringSupport
			.processInjectionBasedOnCurrentContext(this);
		System.out.println("ちぇっく２");
	}

}
