package spring.com.token.service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.com.token.entity.TokenEntity;
import spring.com.token.repo.TokenRepo;
import spring.com.token.request.UserRequest;
import spring.com.token.response.TokenRequest;
import spring.com.token.response.TokenResponse;
import spring.com.token.response.TokenSessionResponse;
import spring.com.token.response.UserResponse;

@Service
public class TokenService {

	@Autowired
	private TokenRepo tokenRepo;
	
	
	

	public UserResponse genarateToken(UserRequest userRequest) {
		UserResponse userResponse= new UserResponse();	

		try {
			if((userRequest.getUserID()==null||userRequest.getUserID().equals("")) || (userRequest.getPassword()==null || userRequest.getPassword().equals(""))) {
				userResponse.setResponseDescription("Please provide UserId and Password");
				userResponse.setStatusCode("300");
				userResponse.setToken("Non");
				return userResponse;
			}
			userRequest.getUserID().trim();
			userRequest.getPassword().trim();
			TokenEntity firstLoginValidate= tokenRepo.findById(userRequest.getUserID()).get();
			//System.out.println(firstLoginValidate);
			String passwordEncode=passwordEncodeDecode(userRequest.getPassword());
			if(passwordEncode.equalsIgnoreCase(firstLoginValidate.getPassword())) {
				TokenSessionResponse tokenValidate=compareTime(firstLoginValidate.getLastLoginTime());
				if(tokenValidate.getValidationMessage().equalsIgnoreCase(("Valid_Token"))) {
					userResponse.setResponseDescription("Valid token and Valid for next "+tokenValidate.getValidateTime()+" minutes" );
					userResponse.setStatusCode("200");
					userResponse.setToken(firstLoginValidate.getToken()); 
					return userResponse; 
				}
				else {
					String token="";
					Random r = new Random( System.currentTimeMillis());
					Integer a=(1 + r.nextInt(2)) * 10000 + r.nextInt(10000);
					token=passwordEncodeDecode(userRequest.getUserID())+a.toString();
					firstLoginValidate.setLastLoginTime(timeStamp());
					firstLoginValidate.setToken(token);
					TokenEntity tokenRes= tokenRepo.save(firstLoginValidate);
					userResponse.setResponseDescription("Please find the Token");
					userResponse.setStatusCode("200");
					userResponse.setToken(tokenRes.getToken());
					return userResponse;
				}
			}
			else {
				userResponse.setResponseDescription("InValid Password");
				userResponse.setStatusCode("300");
				userResponse.setToken("Null");
				return userResponse;
			}
		} catch (Exception e) {
			try {
				TokenEntity entity = new TokenEntity();
				userRequest.getUserID();
				/* Token Genaration here 
				 * Genaratiing Random 6 digit number using Random class*/
				String token="";
				Random r = new Random( System.currentTimeMillis() );
				Integer a=(1 + r.nextInt(2)) * 10000 + r.nextInt(10000);
				token=passwordEncodeDecode(userRequest.getUserID())+a.toString();
				entity.setUserName(userRequest.getUserID());
				entity.setLastLoginTime(timeStamp());
				entity.setPassword(passwordEncodeDecode(userRequest.getPassword()));
				entity.setActive(1);
				entity.setToken(token);
				TokenEntity tokenRes= tokenRepo.save(entity);
				userResponse.setResponseDescription("User Created and Token Generated");
				userResponse.setStatusCode("200");
				userResponse.setToken(tokenRes.getToken());
				return userResponse;
			}
			catch (Exception e2) {
			}
			return userResponse;
		}
	}
	/* Creating login time here */
	private static String timeStamp() {
		LocalDateTime myDateObj = LocalDateTime.now();  
		//System.out.println("Before Formatting: " + myDateObj);  
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");  
		String formattedDate = myDateObj.format(myFormatObj);  
		System.out.println("After Formatting: " + formattedDate);
		return formattedDate;
	}

	/* Validating token for 30 minutes */
	private static TokenSessionResponse compareTime(String lastLogin) {
		String tokenValidation="";
		TokenSessionResponse tokenSessionResponse = new TokenSessionResponse();
		try {
			String sDate5 = lastLogin;  
			SimpleDateFormat formatter5=new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");  
			Date startTime = Calendar.getInstance().getTime();
			//System.out.println(startTime);
			Date date5=formatter5.parse(sDate5);  
			Date endTime = Calendar.getInstance().getTime();
			long difference = endTime.getTime() - date5.getTime();
			long differenceSeconds = difference / 1000 % 60;
			Long differenceMinutes = difference / (60 * 1000) % 60;
			long differenceHours = difference / (60 * 60 * 1000) % 24;
			long differenceDays = difference / (24 * 60 * 60 * 1000);
			if( differenceDays< 1 && differenceHours < 1 && differenceMinutes < 30) {
				tokenSessionResponse.setValidationMessage("Valid_Token");
				differenceMinutes=30-differenceMinutes;
				tokenSessionResponse.setValidateTime(differenceMinutes.toString());
			}
			else {
				tokenValidation="InValid_Token";
				tokenSessionResponse.setValidationMessage("InValid_Token");
				tokenSessionResponse.setValidateTime(differenceMinutes.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tokenSessionResponse;
	}

	/* Password Encription Here 
	 * Input of string convert to bytes array*/
	private static String passwordEncodeDecode(String password) {

		byte[] bytes;
		String encoded ="";
		try {
			bytes = password.getBytes("UTF-8");
			encoded = Base64.getEncoder().encodeToString(bytes);
			byte[] decoded = Base64.getDecoder().decode(encoded);
			String decodedStr = new String(decoded, StandardCharsets.UTF_8);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Random r = new Random( System.currentTimeMillis() );
		int a=(1 + r.nextInt(2)) * 10000 + r.nextInt(10000);
		//System.out.println(a);
		StringBuffer sb = new StringBuffer();
		try{
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(encoded.getBytes());
			byte byteData[] = md.digest();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		//   System.out.println(sb.toString());
		return sb.toString();
	}

	public TokenResponse validateToken(TokenRequest request) {
		TokenResponse tokenResponse= new TokenResponse();
		if((request.getUserId()==null||request.getUserId().equals("")) || (request.getToken()==null||request.getToken().equals(""))) {
			tokenResponse.setDescription("Please provide UserId");
			tokenResponse.setStatusCode("300");
			tokenResponse.setTokenValidationMessage("User ID and Token can't empty");
			return tokenResponse;
		}
		request.getUserId().trim();
		request.getToken().trim();
		try {
			TokenEntity firstLoginValidate= tokenRepo.findById(request.getUserId()).get();
			//System.out.println(firstLoginValidate);
			if(firstLoginValidate.getToken().equalsIgnoreCase(request.getToken())) {
				TokenSessionResponse tokenValidate=compareTime(firstLoginValidate.getLastLoginTime());
				if(tokenValidate.getValidationMessage().equalsIgnoreCase("Valid_Token")) {
					tokenResponse.setDescription("Valid_Token");
					tokenResponse.setStatusCode("200");
					tokenResponse.setTokenValidationMessage("Token will valid for next "+tokenValidate.getValidateTime()+" minutes");
					return tokenResponse;
				}
				else {
					tokenResponse.setDescription("Token expired Genarate Token Again");
					tokenResponse.setStatusCode("300");
					tokenResponse.setTokenValidationMessage("Token expired "+tokenValidate.getValidateTime()+" minutes ago");
					return tokenResponse;
				}
			}
			else {
				tokenResponse.setDescription("InValid Token");
				tokenResponse.setStatusCode("300");
				tokenResponse.setTokenValidationMessage("Please provide Valid token");
				return tokenResponse;
			}
		} catch (Exception e) {
			tokenResponse.setDescription("InValid User");
			tokenResponse.setStatusCode("300");
			tokenResponse.setTokenValidationMessage("Please provide Valid user");
			return tokenResponse;
		}
	}

}
