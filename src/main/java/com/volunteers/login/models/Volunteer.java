package com.volunteers.login.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Volunteer {
	
	private int id;
	private String nick;
	private String email;
	private String password;
	private int id_roll;
	private int id_usuario;
	
	public Volunteer(ResultSet rs) throws SQLException {
		super();
		this.id = rs.getInt("id");
		this.nick = rs.getString("nick");
		this.email = rs.getString("email");
		this.password = rs.getString("password");
		this.id_roll = rs.getInt("id_roll");
		this.id_usuario = rs.getInt("id_usuario");
	}
	public Volunteer() throws SQLException {
		super();
		this.id = 0;
		this.nick = "";
		this.email = "";
		this.password = "";
		this.id_roll = 0;
		this.id_usuario = 0;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId_roll() {
		return id_roll;
	}

	public void setId_roll(int id_roll) {
		this.id_roll = id_roll;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
