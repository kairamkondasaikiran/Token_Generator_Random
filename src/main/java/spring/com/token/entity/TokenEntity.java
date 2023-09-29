package spring.com.token.entity;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Document(collection = "User")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TokenEntity {

	
	@Id
	@NotNull
	private String userName;
	
	private String password;
	private String token;
	private String lastLoginTime;
	private Integer active;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "TokenEntity [userName=" + userName + ", password=" + password + ", token=" + token + ", lastLoginTime="
				+ lastLoginTime + ", active=" + active + "]";
	}
	
}
