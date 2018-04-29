package com.zzq.beauty.mapper;

import com.github.pagehelper.Page;
import com.zzq.beauty.model.Person;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

    Page<List<Map<String,Object>>> getPersonAndReCommender(@Param("keyWord")String keyWord,@Param("where")String where);

    List<Person> getSalesmanList();


    @Select("SELECT COUNT(*) FROM person WHERE person.createDate >=#{startDate} AND person.createDate <=#{endDate} AND person.type=1")
    long getBetweenTimePerson(@Param("startDate") String startDate,@Param("endDate") String endDate);


    @Select("SELECT COUNT(*) FROM person WHERE person.lastCareDate >=#{startDate} AND person.lastCareDate <=#{endDate} AND person.type=1")
    long getCareOutTimeTimePerson(@Param("startDate") String startDate,@Param("endDate") String endDate);
}