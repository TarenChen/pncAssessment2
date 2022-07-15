package com.example.pnc_assessment;

import javax.validation.constraints.NotBlank;
import java.util.UUID;
import javax.persistence.Entity;
import javax.validation.constraints.Pattern;

@Entity
public class User {
	
	private UUID uuid;
	@NotBlank(message = "userName can not be blank")
	private String userName;
	@NotBlank(message = "password can not be blank")
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[_#$%.])(?=\\S+$).{8,}", message = "Password need to be greater than 8 characters, containing at least 1 number, 1 Capitalized letter, 1 special character in this set _#$%.")
	private String password;
	@NotBlank(message = "ipAddress can not be blank")
	private String ipAddress;
	
	public User(UUID uuid, String userName, String password, String ipAddress) {
		this.uuid = UUID.randomUUID();
		this.userName = userName;
		this.password = password;
		this.ipAddress = ipAddress;
	}

	public UUID getUuid() {
		return uuid;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getIpAddress() {
		return ipAddress;
	}
	
}
