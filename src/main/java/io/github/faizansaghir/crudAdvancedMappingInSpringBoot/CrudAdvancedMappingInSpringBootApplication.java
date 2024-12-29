package io.github.faizansaghir.crudAdvancedMappingInSpringBoot;

import io.github.faizansaghir.crudAdvancedMappingInSpringBoot.dao.AppDAO;
import io.github.faizansaghir.crudAdvancedMappingInSpringBoot.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudAdvancedMappingInSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAdvancedMappingInSpringBootApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {

			// createCourseAndStudents(appDAO);
			// findCourseAndStudents(appDAO);
			findStudentAndCourses(appDAO);

		};
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int id = 2;

		Student student = appDAO.findStudentAndCoursesByStudentId(id);

		System.out.println(STR."Loaded student: \{student}");
		System.out.println(STR."Associated courses: \{student.getCourses()}");
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int id = 10;

		Course course = appDAO.findCourseAndStudentsByCourseId(id);

		System.out.println(STR."Loaded course: \{course}");
		System.out.println(STR."Associated students: \{course.getStudents()}");

	}

	private void createCourseAndStudents(AppDAO appDAO) {

		Course course = new Course("Pacman- How To Score A Million Score");

		Student student1 = new Student("John", "Doe", "john@example.com");
		Student student2 = new Student("Mary", "Public", "mary@example.com");

		course.addStudent(student1);
		course.addStudent(student2);

		System.out.println(STR."Saving the course \{course}");
		System.out.println(STR."Associated students: \{course.getStudents()}");

		appDAO.save(course);

		System.out.println("Done!");

	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int id = 10;

		System.out.println(STR."Deleting course with id: \{id}");

		appDAO.deleteCourseById(id);

		System.out.println("Done");

	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int id = 10;
		Course course = appDAO.findCourseAndReviewsByCourseId(id);

		System.out.println(course);

		System.out.println(course.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course course = new Course("Pacman- How to score one million points");
		course.addReview(new Review("Great course... loved it!!!"));
		course.addReview(new Review("Cool course, job well done."));
		course.addReview(new Review("What a dumb course, you are an idiot"));

		System.out.println("Saving the course");
		System.out.println(course);
		System.out.println(course.getReviews());

		appDAO.save(course);

		System.out.println("Done");
	}

	private void deleteCourse(AppDAO appDAO) {
		int id = 10;

		System.out.println(STR."Deleting course with id: \{id}");

		appDAO.deleteCourseById(id);

		System.out.println("Done");
	}

	private void updateCourse(AppDAO appDAO) {
		int id = 10;

		System.out.println(STR."Finding course with id: \{id}");

		Course course = appDAO.findCourseById(id);

		System.out.println(STR."Updating course with id: \{id}");

		course.setTitle("Enjoy the Simple Things");

		appDAO.updateCourse(course);

		System.out.println("Done");
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;

		System.out.println(STR."Finding instructor with id: \{id}");

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println(STR."Updating instructor with id: \{id}");

		instructor.setLastName("Techie");

		appDAO.updatedInstructor(instructor);

		System.out.println("Done");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int id = 1;

		System.out.println(STR."Finding instructor with id: \{id}");

		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println(STR."Instructor: \{instructor}");

		System.out.println(
				STR."Associated Courses: \{instructor.getCourses()}"
		);
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;

		System.out.println(STR."Finding instructor with id: \{id}");

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println(STR."Instructor: \{instructor}");

		System.out.println(STR."Finding courses for instructor id: \{id}");

		List<Course> courses = appDAO.getCoursesByInstructorId(id);

		instructor.setCourses(courses);

		System.out.println(
				STR."Associated Courses: \{instructor.getCourses()}"
		);
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor(
				"Alpha", "Guide", "alpha@abc.com"
		);

		InstructorDetail instructorDetail = new InstructorDetail(
				"http://www.youtube.com/alphaGuide", "Gaming"
		);

		instructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("Learn spanish");
		Course course2 = new Course("Software development");

		instructor.add(course1);
		instructor.add(course2);

		System.out.println(STR."Saving instructor: \{instructor}");
		System.out.println(STR."Courses: \{instructor.getCourses()}");

		appDAO.save(instructor);

		System.out.println("Done");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 3;

		System.out.println(STR."Deleting instructor detail with id: \{id}");

		appDAO.deleteInstructorDetailById(id);

		System.out.println("Done");

	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id = 1;

		System.out.println(STR."Finding instructor detail with id: \{id}");

		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

		System.out.println(STR."InstructorDetail: \{instructorDetail}");
		System.out.println(
				STR."Associated Instructor: \{instructorDetail.getInstructor()}"
		);

	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;

		System.out.println(STR."Deleting instructor with id: \{id}");

		appDAO.deleteInstructorById(id);

		System.out.println("Done");
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 2;
		System.out.println(STR."Finding instructor with id: \{id}");

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println(STR."Instructor: \{instructor}");
		System.out.println(
				STR."Associated InstructorDetail: \{instructor.getInstructorDetail()}"
		);
	}

	private void createInstructor(AppDAO appDAO) {

		/*
		Instructor instructor = new Instructor(
				"Faizan", "Saghir", "faizan@abc.com"
		);

		InstructorDetail instructorDetail = new InstructorDetail(
				"http://www.youtube.com/faizan", "Code and learn"
		);
		*/

		Instructor instructor = new Instructor(
				"Alpha", "Tech", "alpha@abc.com"
		);

		InstructorDetail instructorDetail = new InstructorDetail(
				"http://www.youtube.com/a_tech", "Technical analysis"
		);

		instructor.setInstructorDetail(instructorDetail);

		System.out.println(instructor);

		appDAO.save(instructor);

		System.out.println("Done");

	}
}
