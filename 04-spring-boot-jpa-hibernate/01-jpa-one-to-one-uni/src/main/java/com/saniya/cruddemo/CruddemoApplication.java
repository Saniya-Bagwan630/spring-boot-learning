package com.saniya.cruddemo;

import com.saniya.cruddemo.dao.InstructorDaoInterface;
import com.saniya.cruddemo.entity.Instructor;
import com.saniya.cruddemo.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorDaoInterface instructorDaoInterface){
		return tunner ->{

			createInstructor(instructorDaoInterface);

		};
	}

	private void createInstructor(InstructorDaoInterface instructorDaoInterface) {

		//create the instructor
		Instructor instructor = new Instructor("Saniya", "Bagwan", "san@gmail.com");

		//create instructor detail
		InstructorDetails instructorDetails= new InstructorDetails("smile with saniya","crochet");

		//add instructor detail to instructor
		instructor.setInstructorDetails(instructorDetails);

		//save the instructor
		//this will also save the instructor detail bcz we have CASCADETYPE.ALL
		System.out.println("Saving Instructor: "+instructor);

		instructorDaoInterface.save(instructor);

		System.out.println("DONE!!");

	}
}
