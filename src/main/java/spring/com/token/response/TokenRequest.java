package spring.com.token.response;

public class TokenRequest {

	private String userId;
	private String token;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "TokenRequest [userId=" + userId + ", token=" + token + "]";
	}
	public TokenRequest(String userId, String token) {
		super();
		this.userId = userId;
		this.token = token;
	}
	
	
}
