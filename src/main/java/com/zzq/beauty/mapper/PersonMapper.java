package com.zzq.beauty.mapper;

import com.github.pagehelper.Page;
import com.zzq.beauty.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PersonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);

    Page<List<Map<String,Object>>> getPersonAndReCommender(String keyWord);

    List<Person> getSalesmanList();
}