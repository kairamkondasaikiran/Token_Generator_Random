package spring.com.token.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import spring.com.token.entity.Address;
import spring.com.token.entity.StreamAPIEntity;
import spring.com.token.entity.UserFiles;
import spring.com.token.repo.SteamAPIRepo;

@Service
public class StreamAPIService {

	@Autowired
	SteamAPIRepo apiRepo;

	public StreamAPIEntity saveData(StreamAPIEntity apiEntity) {

		StreamAPIEntity streamAPIEntity =apiRepo.save(apiEntity);

		return streamAPIEntity;

	}
	
	public List<StreamAPIEntity> allData(){
		
		return apiRepo.findAll();
	}



	public StreamAPIEntity getData(Long salary,int id) {

		
		StreamAPIEntity streamAPIEntity=	apiRepo.findById(id).get();
		List<StreamAPIEntity>	list =apiRepo.findAll();

		list.forEach(a ->a.getUserAddress().stream().filter(b -> b.getDistrict().equals("Siddipet")).collect(Collectors.toList()));
		System.out.println(list);
		list.forEach(a ->a.getUserAddress().stream().filter(b -> b.getDistrict().equals("Medak")).forEach(System.out::println));
		list.forEach(a ->a.getUserAddress().stream().filter(b -> b.getDistrict().equals("Siddipet")).forEach(c -> System.out.println(c.getDistrict())));

		streamAPIEntity.getUserFile().stream().filter(data -> data.getFileId()==1).forEach(System.out::println);
		List<UserFiles> streamAPIEntity1=	streamAPIEntity.getUserFile().stream().filter(data -> data.getFileId()==1 && data.getFileName().equals("file1.txt")).collect(Collectors.toList());
			System.out.println(streamAPIEntity);
			System.out.println(streamAPIEntity1);
			
			
			list.forEach(file -> file.getUserFile().stream().filter(b -> b.getFileDate().equals("08/09/2023")).collect(Collectors.toList()));

			list.forEach(a -> a.getUserFile().stream().filter(b -> b.getFileDate().charAt(9)>3).collect(Collectors.toList()));
			list.forEach(a -> a.getUserFile().stream().filter(b -> b.getFileDate().charAt(9)>3).forEach(System.out::println));

		for(int i=0;i<list.size();i++) {

			for(int j=0;j<list.get(i).getUserAddress().size();j++) {
             if(list.get(i).getUserAddress().get(j).getDistrict().equals("Siddipet")) {
            	 System.out.println(list.get(i).getUserAddress().get(j));
             }
			}
		}
		

		return streamAPIEntity;



	}

	public static long startTime() {

		long startTime = System.currentTimeMillis();
		System.out.println(startTime);
		return startTime;

	}
	public static String endTime() {


		long endTime = System.currentTimeMillis();
		System.out.println(endTime);
		long differenceTime = endTime - startTime();
		System.out.println("Request time: " + differenceTime);
		//or
		System.out.println("Request time: " + TimeUnit.MILLISECONDS.toSeconds(differenceTime) + " sec");
		return null;

	}

}
