package spring.com.token.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.com.token.entity.StreamAPIEntity;
import spring.com.token.service.StreamAPIService;

@RestController
public class StreamAPIController {
	
	@Autowired
	StreamAPIService apiService;

	@PostMapping("/StreamAPIData")
	public ResponseEntity<?> saveApiData(@RequestBody StreamAPIEntity apiEntity){
		
	//	apiService.saveData(apiEntity);
		
		return ResponseEntity.ok(apiService.saveData(apiEntity));
		
	}
	
	@GetMapping("/getData")
	public ResponseEntity<?> getData(@RequestParam("salary") Long salary,@RequestParam("id") int id){
		
		return ResponseEntity.ok(apiService.getData(salary, id));
	}
	
	@GetMapping("/allData")
	public ResponseEntity<?> allData(){
		
		return ResponseEntity.ok(apiService.allData());
	}
}
