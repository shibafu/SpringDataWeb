package com.tsugaruinfo.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.Getter;


/**
 * The persistent class for the mypersonaldata database table.
 * 
 */

@Data
@Entity
@Table(name="Mypersonaldata")
@NamedQueries({
		@NamedQuery(name = "Mypersonaldata.getAllEntity",
		query="FROM Mypersonaldata m"),
		
		@NamedQuery(name = "Mypersonaldata.findByName",
		query="FROM Mypersonaldata m WHERE m.name = :value")
})
public class Mypersonaldata implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
	@SequenceGenerator(name = "id_seq", sequenceName="mypersonadata_id", allocationSize = 1)
	private Integer id;

	@Column
	private Integer age;

	@Column(length=100)
	private String mail;

	@Column
	private String name;

	public Mypersonaldata() {
	}
	
	public Mypersonaldata(String name, String mail, int age) {
		this();
		this.name = name;
		this.mail = mail;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "MyPersonanData [id=" + id + ", name=" + name 
				+ ", mail=" + mail + ",age=" + age + "]";
	}
	
}