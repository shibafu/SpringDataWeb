package com.tsugaruinfo.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

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
	
	@Autowired
	Validator validator;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Mypersonaldata> list = repository.findAll();
		request.setAttribute("entities", list);

		request.setAttribute("msg", "個人情報を入力してください！");
		request.setAttribute("name", "");
		request.setAttribute("mail", "");
		request.setAttribute("age", "");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());

		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//パラメータを取得
		String msg = "";
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		int age;
		
		try {
			age = Integer.valueOf(request.getParameter("age"));
		} catch (NumberFormatException e){
			age = 0;
		}
		
		
//		Mypersonaldata addData = new Mypersonaldata(name, mail, age);
//		dao.addEntity(addData);
//
//		Mypersonaldata addData = new Mypersonaldata(name, mail, age);
//		repository.saveAndFlush(addData);
		
//		List<Mypersonaldata> list = repository.findByNameLikeOrMailLike("%" + name + "%", "%" + mail + "%");
//		request.setAttribute("entities", list);
		
		Mypersonaldata entity = new Mypersonaldata(name, mail, age);
		
		//バリデーション開始
		Set<ConstraintViolation<Mypersonaldata>> result =
				validator.validate((Mypersonaldata)entity);
		
		//バリデーション処理分岐
		if(result.isEmpty()) {
			repository.saveAndFlush(entity);
			response.sendRedirect("person");
		} else {
			msg = "<pre>";
			for(ConstraintViolation<Mypersonaldata> viola : result) {
				msg += viola.getPropertyPath() + ":" + viola.getMessage() + "\n";
			}
			msg += "</pre>";
			
			request.setAttribute("msg", msg);
			request.setAttribute("name", name);
			request.setAttribute("mail", mail);
			request.setAttribute("age", "" + age);
			
			request.setAttribute("entities", repository.findAll());
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		}		
	}

}
