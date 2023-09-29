package spring.com.token.service;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import spring.com.token.entity.DocumentUploadEntity;
import spring.com.token.entity.FileData;
import spring.com.token.repo.DocumentUploadRepo;
import spring.com.token.repo.FileDataRepo;

@Service
public class FileDataService {

	private static final String RETRIEVE_FOLDER = null;

	@Autowired
	FileDataRepo fileDataRepo;
	
	@Autowired
	DocumentUploadRepo documentUploadRepo;
	
	public List<String> fileDataRead(String fileName,MultipartFile file) throws FileNotFoundException, IOException {
		
		List<String> list= new ArrayList<String>();
		FileData entity = new FileData();
		try (BufferedReader br = new BufferedReader(new FileReader("C://JavaPrac_workspace/CDF_GBR_CCADB_GI_20210223151515.txt"))) {
			   String line;
			   while ((line = br.readLine()) != null) {
				   if(line.contains("Active")) {
					   list.add(line);
					 //  System.out.println(line);
				   }
			      
			   }
			   entity.setId(fileName);
			   entity.setFileData((ArrayList<String>) list);
			   fileDataRepo.save(entity);
			}
		
		
		 
		return list;
		
		
	}
	
	public void file(MultipartFile file, String fileName) {
		 if (true) {
		        try {
		            byte[] bytes = file.getBytes();

		            // Creating the directory to store file
		            String rootPath = System.getProperty("catalina.home");
		            File dir = new File(rootPath + File.separator + "tmpFiles");
		            if (!dir.exists()) {
		                dir.mkdirs();
		            }

		            // Create the file on server
		            File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);
		            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
		            stream.write(bytes);
		            stream.close();

		            System.out.println("Server File Location=" + serverFile.getAbsolutePath());
		            String path =serverFile.getAbsolutePath();
		            
		            Resource resource = new ClassPathResource("file:///C:/JavaPrac_workspace/Tirumala%20Tirupati%20Devasthanams(Official%20Booking%20Portal).pdf");
		            File file1 = resource.getFile();
		            BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));

		            String[] array = bufferedReader.lines().collect(Collectors.joining()).split(",");
		            System.out.println(Arrays.asList(array));

		           // return null;
		        } catch (Exception e) {
		        	
		        }
		    }
		
	}
	
	public String documentUpload(MultipartFile[] file, String email) {
		
		 try {
	    	  DocumentUploadEntity demoDocument = new DocumentUploadEntity();
	          demoDocument.setEmailId(email);
	          demoDocument.setDocType("pictures");
	       //   demoDocument.setFile(new org.bson.types.Binary(BsonBinarySubType.BINARY, file.getBytes()));
	      //    documentUploadRepo.insert(demoDocument);
	         // System.out.println(demoDocument);
	      } catch (Exception e) {
	          e.printStackTrace();
	          return "failure";
	      }
		return "success";
		
	}
	
	public String fileRetrive(String email) {
	
		//DocumentUploadEntity demoDocument = documentUploadRepo.findBy(new BasicQuery("{emailId : \""+email+"\", docType : \"pictures\"}"), DocumentUploadEntity.class);
		    
		    DocumentUploadEntity demoDocument =documentUploadRepo.findByEmailId(email);
		    System.out.println(demoDocument);
		    Binary document = demoDocument.getFile();
		    if(document != null) {
		        FileOutputStream fileOuputStream = null;
		        try {
		            fileOuputStream = new FileOutputStream(RETRIEVE_FOLDER + "prof_pic.jpg");
		            fileOuputStream.write(document.getData());
		        } catch (Exception e) {
		            e.printStackTrace();
		            return "failure";
		        } finally {
		            if (fileOuputStream != null) {
		                try {
		                    fileOuputStream.close();
		                } catch (IOException e) {
		                    e.printStackTrace();
		                    return "failure";
		                }
		            }
		        }
		    }
		return "Success";
	}
	
	
}
