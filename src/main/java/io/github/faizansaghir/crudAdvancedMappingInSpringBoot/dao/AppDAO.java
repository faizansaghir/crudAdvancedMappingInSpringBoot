package io.github.faizansaghir.crudAdvancedMappingInSpringBoot.dao;

import io.github.faizansaghir.crudAdvancedMappingInSpringBoot.entity.Course;
import io.github.faizansaghir.crudAdvancedMappingInSpringBoot.entity.Instructor;
import io.github.faizansaghir.crudAdvancedMappingInSpringBoot.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> getCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void updatedInstructor(Instructor instructor);

    void updateCourse(Course course);

    Course findCourseById(int id);

    void deleteCourseById(int id);

    void save(Course course);

    Course findCourseAndReviewsByCourseId(int id);

    Course findCourseAndStudentsByCourseId(int id);
}
