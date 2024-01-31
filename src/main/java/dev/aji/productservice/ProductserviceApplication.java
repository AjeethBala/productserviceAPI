package dev.aji.productservice;

import dev.aji.productservice.inheritance_example.joinedTable.Mentor;
import dev.aji.productservice.inheritance_example.joinedTable.MentorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductserviceApplication implements CommandLineRunner {
//	private  MentorRepository mentorRepository;
//	public ProductserviceApplication(MentorRepository mentorRepository){
//		this.mentorRepository=mentorRepository;
//	}

	public static void main(String[] args) {
		SpringApplication.run(ProductserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Mentor mentor=new Mentor();
//		mentor.setName("Ajeeth");
//		mentor.setEmail("ajeeth@gmail.com");
//		mentor.setAvgRating(100.0);
//
//		mentorRepository.save(mentor);
	}
}
