package com.volunteers.login.models;

public class Volunteer {
	
	private int id;
	private String nick;
	private String email;
	private String password;
	private int id_roll;
	private int id_usuario;
	
	public void volunteer(int id, String nick, String email, String password, int id_roll, int id_usuario) {
		this.id = id;
		this.nick = nick;
		this.email = email;
		this.password = password;
		this.id_roll = id_roll;
		this.id_usuario = id_usuario;
	}
	
	public Volunteer volunteer() {
		return this;
	}
	
	

}
