package spring.com.token.response;

public class TokenSessionResponse {

	private String validationMessage;
	private String validateTime;
	public String getValidationMessage() {
		return validationMessage;
	}
	public void setValidationMessage(String validationMessage) {
		this.validationMessage = validationMessage;
	}
	public String getValidateTime() {
		return validateTime;
	}
	public void setValidateTime(String validateTime) {
		this.validateTime = validateTime;
	}
	
	
}
