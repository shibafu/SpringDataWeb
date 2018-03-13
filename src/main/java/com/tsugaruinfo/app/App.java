package com.tsugaruinfo.app;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;

import com.tsugaruinfo.dao.MyPersonDataDaoImpl;
import com.tsugaruinfo.model.Mypersonaldata;

import lombok.Data;

@Component
@ComponentScan("com.tsugaruinfo.config")
public class App {
	//private static JdbcTemplate jdbcTemplate;
	private static ApplicationContext context;
	private static EntityManager manager;
	
	
	
	public static void main(String args[]) {
		
		//アノテーションを用いたテンプレートの作成
		//context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		//JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean(JdbcTemplate.class);
		//コンテキスト取得
//		context = new ClassPathXmlApplicationContext("bean.xml");
//		jdbcTemplate = context.getBean(JdbcTemplate.class);
	
		
		//マネージャーの作成

		//Daoの生成
		MyPersonDataDaoImpl daoimpl = 
				new MyPersonDataDaoImpl();
		
		//追加データの作成
		daoimpl.removeEntity(4);
		List<Mypersonaldata> result = daoimpl.getAllEntity();
		
		for(Mypersonaldata data : result) {
			System.out.println(data);
		}
	
	}

}
