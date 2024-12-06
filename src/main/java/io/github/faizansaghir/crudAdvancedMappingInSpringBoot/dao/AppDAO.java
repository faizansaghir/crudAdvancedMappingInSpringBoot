package io.github.faizansaghir.crudAdvancedMappingInSpringBoot.dao;

import io.github.faizansaghir.crudAdvancedMappingInSpringBoot.entity.Instructor;
import io.github.faizansaghir.crudAdvancedMappingInSpringBoot.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

}
