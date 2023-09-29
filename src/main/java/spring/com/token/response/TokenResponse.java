package spring.com.token.response;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TokenResponse {

	private String statusCode;
	private String description;
	private String tokenValidationMessage;
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTokenValidationMessage() {
		return tokenValidationMessage;
	}
	public void setTokenValidationMessage(String tokenValidationMessage) {
		this.tokenValidationMessage = tokenValidationMessage;
	}
	@Override
	public String toString() {
		return "TokenResponse [statusCode=" + statusCode + ", description=" + description + ", tokenValidationMessage="
				+ tokenValidationMessage + ", getStatusCode()=" + getStatusCode() + ", getDescription()="
				+ getDescription() + ", getTokenValidationMessage()=" + getTokenValidationMessage() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public TokenResponse(String statusCode, String description, String tokenValidationMessage) {
		super();
		this.statusCode = statusCode;
		this.description = description;
		this.tokenValidationMessage = tokenValidationMessage;
	}
	public TokenResponse() {
		super();
	}
	
	
}
