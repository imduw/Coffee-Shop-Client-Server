package model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "account")
public class AccountModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer ID;
	
    
	private String Username;
	
	
	private String Password;
	
	
	private String Role;


	public AccountModel(Integer iD, String username, String password, String role) {
		
		this.ID = iD;
		this.Username = username;
		this.Password = password;
		this.Role = role;
	}


	public AccountModel() {
		
	}


	public Integer getID() {
		return ID;
	}


	public void setID(Integer iD) {
		ID = iD;
	}


	public String getUsername() {
		return Username;
	}


	public void setUsername(String username) {
		Username = username;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getRole() {
		return Role;
	}


	public void setRole(String role) {
		Role = role;
	}


	

	
	
	
	
	
	
	
}
