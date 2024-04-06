package com.example.sample1app;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOPersonImpl implements PersonDAO<Person> {
    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager entityManager;

    public PersonDAOPersonImpl() {
        super();
    }

    @Override
    public List<Person> getAll() {
        Query query = entityManager.createQuery("from Person");
        @SuppressWarnings("unchecked")
        List<Person> list = query.getResultList();
        entityManager.close();
        return list;
    }

    @Override
    public Person findById(long id) {
        return (Person) entityManager.createQuery("from Person where id = "
                + id).getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> findByName(String name) {
        return (List<Person>) entityManager.createQuery("from Person where name = '" + name + "'").getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> find(String fstr) {
        List<Person> list = null;
        String qstr = "from Person where id = :fstr";
        Query query = entityManager.createQuery(qstr).setParameter("fstr", Long.parseLong(fstr));
        list = query.getResultList();
        return list;
    }

}