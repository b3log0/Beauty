package com.zzq.beauty.service.impl;

import com.zzq.beauty.mapper.PersonMapper;
import com.zzq.beauty.model.Person;
import com.zzq.beauty.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    PersonMapper personMapper;

    @Override
    public void insert(Person person) {
        personMapper.insert(person);
    }

    @Override
    public Person getPersonById(Integer id) {
        return personMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updatePerson(Person person) {
         personMapper.updateByPrimaryKeySelective(person);
    }
}
