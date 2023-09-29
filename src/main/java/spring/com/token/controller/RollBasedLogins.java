package spring.com.token.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import spring.com.token.request.FileUploadRequest;
import spring.com.token.service.FileDataService;

@RestController
public class RollBasedLogins {

	@Autowired
	FileDataService fileDataService;
	
	@GetMapping("/uploadFile")
	public ResponseEntity<List<String>> fileUpload(@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file,
            HttpServletRequest request) throws FileNotFoundException, IOException{
		
		
		return new ResponseEntity<List<String>>(fileDataService.fileDataRead(name,file), HttpStatus.OK);
		
	}
}
