package io.github.faizansaghir.crudAdvancedMappingInSpringBoot;

import io.github.faizansaghir.crudAdvancedMappingInSpringBoot.dao.AppDAO;
import io.github.faizansaghir.crudAdvancedMappingInSpringBoot.entity.Instructor;
import io.github.faizansaghir.crudAdvancedMappingInSpringBoot.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudAdvancedMappingInSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAdvancedMappingInSpringBootApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 2;

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
