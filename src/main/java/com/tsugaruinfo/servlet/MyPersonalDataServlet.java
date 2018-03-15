package com.tsugaruinfo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.tsugaruinfo.dao.MyPersonDataDaoImpl;
import com.tsugaruinfo.model.Mypersonaldata;
import com.tsugaruinfo.repository.MyPesononalDataDaoRepository;

/**
 * Servlet implementation class MyPersonalDataServlet
 */
@WebServlet("/person")
public class MyPersonalDataServlet extends BeanAutowiringFilterServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	MyPersonDataDaoImpl dao;
	
	@Autowired
	MyPesononalDataDaoRepository repository;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Mypersonaldata> list = repository.findAll();

		request.setAttribute("entities", list);

		response.getWriter().append("Served at: ").append(request.getContextPath());

		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		int age = Integer.valueOf(request.getParameter("age"));
		
//		Mypersonaldata addData = new Mypersonaldata(name, mail, age);
//		dao.addEntity(addData);
		
		Mypersonaldata addData = new Mypersonaldata(name, mail, age);

		repository.saveAndFlush(addData);
		
		response.sendRedirect("person");

	}

}
