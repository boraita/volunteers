package com.volunteers.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
	
	private int id;
	private String name;
	private String lastname;
	private String email;
	private String password;
	private String born_date;
	private int id_rol;
	private String dni;
	private String registered_date;
	private int id_lopd;
	private int image;
	private String nick;
	
	public UserModel(ResultSet rs){
		super();
		try {
			this.id = rs.getInt("id");
			this.name = rs.getString("name");
			this.email = rs.getString("email");
			this.password = rs.getString("password");
			this.born_date = rs.getString("born_date");
			this.id_rol = rs.getInt("id_rol");
			this.dni = rs.getString("dni");
			this.registered_date = rs.getString("registered_date");
			this.id_lopd = rs.getInt("id_lopd");
			this.image = rs.getInt("id_image");
			this.nick = rs.getString("nick");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBorn_date() {
		return born_date;
	}
	public void setBorn_date(String born_date) {
		this.born_date = born_date;
	}
	public int getId_rol() {
		return id_rol;
	}
	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getRegister_date() {
		return registered_date;
	}
	public void setRegister_date(String register_date) {
		this.registered_date = register_date;
	}
	public int getId_lopd() {
		return id_lopd;
	}
	public void setId_lopd(int id_lopd) {
		this.id_lopd = id_lopd;
	}
	public int getImage() {
		return image;
	}
	public void setImage(int image) {
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getNick() {
		return nick;
	}


	public void setNick(String nick) {
		this.nick = nick;
	}

}
