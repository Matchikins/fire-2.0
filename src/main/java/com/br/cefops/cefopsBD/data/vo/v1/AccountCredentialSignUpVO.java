package com.br.cefops.cefopsBD.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


public class AccountCredentialSignUpVO  implements Serializable{
private static final long serialVersionUID = 1L;
	@NotEmpty(message = "O Campo Usário não pode ser vazio !")
	private String username;
	@NotEmpty(message = "O Campo Senha não pode ser vazio !")
	private String password;
	@NotEmpty(message = "O Campo E-mail não pode ser vazio !")
    @Email(message = "Por Favor Insira Um E-mail Valido !")
	private String email;
	@NotEmpty(message = "O Campo Nome Completo não pode ser vazio !")
	private String fristName;
	private String lastName;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFristName() {
		return fristName;
	}
	public void setFristName(String fristName) {
		this.fristName = fristName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, fristName, lastName, password, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountCredentialSignUpVO other = (AccountCredentialSignUpVO) obj;
		return Objects.equals(email, other.email) && Objects.equals(fristName, other.fristName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}

	
		
	

	
	
}
