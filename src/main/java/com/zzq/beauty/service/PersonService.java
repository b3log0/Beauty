package com.zzq.beauty.service;

import com.zzq.beauty.model.Person;

public interface PersonService {
    public void insert(Person person);
    Person getPersonById(Integer id);
    void updatePerson(Person person);
}
