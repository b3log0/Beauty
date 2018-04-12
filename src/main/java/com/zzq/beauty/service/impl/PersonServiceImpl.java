package com.zzq.beauty.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzq.beauty.mapper.PersonMapper;
import com.zzq.beauty.model.Person;
import com.zzq.beauty.service.PersonService;
import com.zzq.beauty.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


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

    @Override
    public PageBean<List<Map<String, Object>>> getPersonAndReCommender(int pageNum, int pageSize, String keyWord) {
        PageHelper.startPage(pageNum,pageSize);
        Page page = personMapper.getPersonAndReCommender(keyWord);
        return new PageBean<List<Map<String, Object>>>(page.getPageNum(),page.getPageSize(),page.getTotal(),page.getPages(),page.getResult());
    }

    @Override
    public List<Person> getSalesman() {
        return personMapper.getSalesmanList();
    }
}
