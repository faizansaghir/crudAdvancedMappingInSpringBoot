package io.github.faizansaghir.crudAdvancedMappingInSpringBoot.dao;

import io.github.faizansaghir.crudAdvancedMappingInSpringBoot.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class AppDAOImpl implements AppDAO{

    private final EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.merge(instructor);
    }
}
