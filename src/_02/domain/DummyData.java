package _02.domain;

import java.util.List;

public class DummyData {

	public static void prepareJobDatas(List<Job> listOfJobs){
		
		Job jobOfGoogle = new Job(1, "Google", "İstanbul");
		jobOfGoogle.setDescription("Google job opportunities...");
		jobOfGoogle.setPosition("Software Developer");
		jobOfGoogle.setType("full-time");
		
		Job jobOfMicrosoft = new Job(2, "Microsoft", "İstanbul");
		jobOfMicrosoft.setDescription("Microsoft job opportunities...");
		jobOfMicrosoft.setPosition("Software Developer");
		jobOfMicrosoft.setType("full-time");
		
		Job jobOfApple = new Job(3, "Apple", "Ankara");
		jobOfApple.setDescription("Apple job opportunities...");
		jobOfApple.setPosition("Software Developer");
		jobOfApple.setType("part-time");
		
		Job jobOfSony = new Job(4, "Sony", "İzmir");
		jobOfSony.setDescription("Sony job opportunities...");
		jobOfSony.setPosition("Software Developer");
		jobOfSony.setType("part-time");
		
		Job jobOfSamsung = new Job(5, "Samsung", "Antalya");
		jobOfSamsung.setDescription("Samsung job opportunities...");
		jobOfSamsung.setPosition("Software Developer");
		jobOfSamsung.setType("other");
		
		listOfJobs.add(jobOfGoogle);
		listOfJobs.add(jobOfMicrosoft);
		listOfJobs.add(jobOfApple);
		listOfJobs.add(jobOfSony);
		listOfJobs.add(jobOfSamsung);
		
	}


}
