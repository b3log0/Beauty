package com.zzq.beauty.mapper;

import com.zzq.beauty.model.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);


}