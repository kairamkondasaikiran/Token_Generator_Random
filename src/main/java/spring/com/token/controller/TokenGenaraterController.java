package spring.com.token.controller;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.com.token.request.UserRequest;
import spring.com.token.response.TokenRequest;
import spring.com.token.response.TokenResponse;
import spring.com.token.response.UserResponse;
import spring.com.token.service.TokenService;

@RestController
public class TokenGenaraterController {

	@Autowired
	TokenService tokenService;

	@PostMapping("/authenticate")
	public ResponseEntity<UserResponse> genarateToken(@Valid @RequestBody(required =true ) UserRequest userRequest){
		
		return new ResponseEntity<UserResponse>(tokenService.genarateToken(userRequest),HttpStatus.OK);
	}
	
	@GetMapping("/validateToken")
	public ResponseEntity<TokenResponse> validateToken(@RequestBody TokenRequest tokenRequest, HttpServletRequest httpServletRequest){
		String header=httpServletRequest.getHeader("Authorization");
		//System.out.println(header);
		tokenRequest.setToken(header);
		return new ResponseEntity<TokenResponse>(tokenService.validateToken(tokenRequest),HttpStatus.OK);
	}

	@GetMapping("/msg")
	public ResponseEntity<String> getMessage() {

		Random r = new Random( System.currentTimeMillis() );
		int a=(1 + r.nextInt(2)) * 10000 + r.nextInt(10000);
		System.out.println(a);
		StringBuffer sb = new StringBuffer();
		    try{
		        MessageDigest md = MessageDigest.getInstance("SHA-256");
		        md.update("Sai".getBytes());
		        byte byteData[] = md.digest();
		        for (int i = 0; i < byteData.length; i++) {
		         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		        }
		    } catch(Exception e){
		        e.printStackTrace();
		    }
		    System.out.println(sb.toString());
		try {
			LocalDateTime myDateObj = LocalDateTime.now();  
			System.out.println("Before Formatting: " + myDateObj);  
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm:ss");  
			String formattedDate = myDateObj.format(myFormatObj);  
			System.out.println("After Formatting: " + formattedDate); 
			String sDate5 = formattedDate;  
			SimpleDateFormat formatter5=new SimpleDateFormat("MMM dd yyyy HH:mm:ss");  
			Date startTime = Calendar.getInstance().getTime();
			System.out.println(startTime);
			Date date5=formatter5.parse(sDate5);  
			Date endTime = Calendar.getInstance().getTime();
			long difference = endTime.getTime() - date5.getTime();
			long differenceSeconds = difference / 1000 % 60;
			long differenceMinutes = difference / (60 * 1000) % 60;
			long differenceHours = difference / (60 * 60 * 1000) % 24;
			long differenceDays = difference / (24 * 60 * 60 * 1000);
			System.out.println(differenceDays + " days, ");
			System.out.println(differenceHours + " hours, ");
			System.out.println(differenceMinutes + " minutes, ");
			System.out.println(differenceSeconds + " seconds.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("success"+a, HttpStatus.OK);
	}
}
