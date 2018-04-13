package com.zzq.beauty.service;

import com.zzq.beauty.model.Person;
import com.zzq.beauty.util.PageBean;

import java.util.List;
import java.util.Map;

public interface PersonService {
    public void insert(Person person);
    Person getPersonById(Integer id);

    /**
     * 更新
     * @param person
     */
    void updatePerson(Person person);

    /**
     * 分页返回用户以及推荐人
     * @param pageNum
     * @param pageSize
     * @param keyWord
     * @return
     */
    PageBean<List<Map<String,Object>>> getPersonAndReCommender(int pageNum, int pageSize, String keyWord);

    /**
     * 返回所有业务员
     */
    List<Person> getSalesman();

    void updatePersonSelective(Person person);
}
