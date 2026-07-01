package com.saniya.cruddemo;

import com.saniya.cruddemo.dao.InstructorDaoInterface;
import com.saniya.cruddemo.entity.Course;
import com.saniya.cruddemo.entity.Instructor;
import com.saniya.cruddemo.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorDaoInterface instructorDaoInterface){
		return tunner ->{

		};
	}

	private void deleteCourse(InstructorDaoInterface instructorDaoInterface) {
		int id =10;
		System.out.println("Deleting Course");
		instructorDaoInterface.deleteCourse(id);
		System.out.println("Deleted");
	}

	private void updateCourse(InstructorDaoInterface instructorDaoInterface) {
		int id =10;
		//find course
		Course course = instructorDaoInterface.findCourseById(id);

		//update data
		course.setTitle("Cooking");

		//update
		System.out.println("Updating........");
		instructorDaoInterface.updateCourse(course);
		System.out.println("DONE!!");
	}

	private void updateInstructor(InstructorDaoInterface instructorDaoInterface) {
		int id =1;

		//find instructor
		Instructor instructor = instructorDaoInterface.findById(id);

		//update data
		instructor.setlName("Lucccy");

		//update
		System.out.println("Updating........");
		instructorDaoInterface.updateInstructor(instructor);
		System.out.println("DONE!!");

	}

	//using join fetch
	private void findInstructorWithCoursesJoinFetch(InstructorDaoInterface instructorDaoInterface) {
		int id=1;
		System.out.println("Finding Instructor.........");
		Instructor instructor=instructorDaoInterface.findCoursesUsingInstructorIdUsingJOINFETCH(id);

		System.out.println("Instructor: "+instructor);
		System.out.println("Courses: "+ instructor.getCourses());
		System.out.println("DONE!!!!!!!!!!");
	}

	private void findInstructorWithCourses(InstructorDaoInterface instructorDaoInterface) {
		int id=1;
		/* this will work for eager loading
		System.out.println("Finding Instructor");
		Instructor instructor =instructorDaoInterface.findById(id);
		System.out.println("Instructor Found: "+instructor);

		System.out.println("Courses: "+instructor.getCourses());
		 */

		System.out.println("Finding Instructor");
		Instructor instructor =instructorDaoInterface.findById(id);
		System.out.println("Instructor Found: "+instructor);

		System.out.println("Finding courses for instructor id: "+id);

		//without using join fetch
		List<Course> courses= instructorDaoInterface.findCoursesUsingInstructorId(id);

		//associate with instructor
		instructor.setCoursse(courses);

		System.out.println("Associated Courses are"+instructor.getCourses());
	}

	private void createInstructorWithCourses(InstructorDaoInterface instructorDaoInterface) {
		//create the instructor
		Instructor instructor = new Instructor("Sima", "Chavan", "sim@gmail.com");

		//create instructor detail
		InstructorDetails instructorDetails= new InstructorDetails("Sim Chavan","batminton");

		//add instructor detail to instructor
		instructor.setInstructorDetails(instructorDetails);

		System.out.println("Creating Courses.........");
		//create course
		Course c1 = new Course("CS");
		Course c2 = new Course("OS");

		System.out.println("Courses created..........");

		//add courses to instructor
		System.out.println("Adding courses to : "+instructor);
		instructor.addCourse(c1);
		instructor.addCourse(c2);

		//sabing instructor
		System.out.println("Saving the Instructor");
		//it will automatically save instructor details as well as courses
		//due to cascades
		instructorDaoInterface.save(instructor);

		System.out.println("Done!!!!!!!!!!");

	}

	private void deleteInstructorDetails(InstructorDaoInterface instructorDaoInterface) {
		System.out.println("Deleting Instructor details with Id: "+4);
		instructorDaoInterface.deleteInstructorDetailById(4);
		System.out.println("Done");
	}

	private void findInstructorDetails(InstructorDaoInterface instructorDaoInterface) {
		System.out.println("Finding Instructor Details....");
		InstructorDetails instructorDetails= instructorDaoInterface.findInstructorDetailById(3);
		System.out.println("Found "+ instructorDetails+" "+instructorDetails.getInstructor());
	}

	private void deleteInstructor(InstructorDaoInterface instructorDaoInterface) {
		System.out.println("Deleting instructor with id: "+1);
		instructorDaoInterface.deleteInstructor(1);
		System.out.println("Done");
	}

	private void findInstructor(InstructorDaoInterface instructorDaoInterface) {
		Instructor instructor= instructorDaoInterface.findById(1);
		System.out.println("Instructor Found: "+ instructor.getInstructorDetails());
		return ;
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
