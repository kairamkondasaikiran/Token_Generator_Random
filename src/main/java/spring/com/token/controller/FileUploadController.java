package spring.com.token.controller;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import spring.com.token.entity.DocumentUploadEntity;
import spring.com.token.response.FileUploadResponse;
import spring.com.token.service.FileDataService;
import spring.com.token.util.FileUploadUtil;

@RestController
public class FileUploadController {
	
	@Autowired
	FileDataService fileDataService;

	  @PostMapping("/uploadFile")
	    public ResponseEntity<FileUploadResponse> uploadFile(
	            @RequestParam("file") MultipartFile multipartFile)
	                    throws IOException {
	         
	        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
	        long size = multipartFile.getSize();
	         
	        String filecode = FileUploadUtil.saveFile(fileName, multipartFile);
	         
	        FileUploadResponse response = new FileUploadResponse();
	        response.setFileName(fileName);
	        response.setSize(size);
	        response.setDownloadUri("/downloadFile/" + filecode);
	         
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }
	  
	  @PostMapping("/uploadDocument")
	  public ResponseEntity<String> singleFileUpload(@RequestParam("file") MultipartFile[] multipart, @RequestParam("email") String email) {
	     
		  System.out.println(multipart.length);
		 Arrays.stream(multipart).forEach(files ->{
			 System.out.println(files.getOriginalFilename());
			 System.out.println(files.getContentType());
		 });
		  fileDataService.documentUpload(multipart, email);
		  
	      return new ResponseEntity<String>("Success",HttpStatus.OK);
	  }
	  @PostMapping("/retrieve")
	  public String retrieveFile(@RequestParam("email") String email){
		  fileDataService.fileRetrive(email);
	      return "success";
	  }
}

