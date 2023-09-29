package spring.com.token;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.assertj.core.util.Arrays;

public class TestCases {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		// .....
		// processing request
		// .....
		
		
			long endTime = System.currentTimeMillis();
			long differenceTime = endTime - startTime;
			
			System.out.println("Request time: " + differenceTime);
			//or
			System.out.println("Request time: " + TimeUnit.MILLISECONDS.toSeconds(differenceTime) + " sec");
		
		List<String> s=java.util.Arrays.asList("gbz.financial.crime.ops.and.governance.team@uk.zurich.com","john.1.martin@zurich.com","dino.placido.bivona@zurich.com","alvarez.garcia.juan.enrique@zurich.com","fct@uk.zurich.com,amlteam@uk.zurich.com","sentinel.desk@zurich.com");
		
		
	}
}
