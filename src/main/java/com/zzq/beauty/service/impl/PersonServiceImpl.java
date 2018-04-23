package com.zzq.beauty.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzq.beauty.mapper.BrokerMapper;
import com.zzq.beauty.mapper.PersonMapper;
import com.zzq.beauty.model.Broker;
import com.zzq.beauty.model.Person;
import com.zzq.beauty.service.PersonService;
import com.zzq.beauty.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    PersonMapper personMapper;
    @Autowired
    BrokerMapper brokerMapper;

    @Override
    @Transactional
    public void insert(Person person) {
        personMapper.insert(person);
        Broker broker = new Broker();
        System.out.println("===================="+person.getId());
        broker.setClient(person.getId());
        broker.setPuller(person.getUserid());
        broker.setStartdate(new Date());
        brokerMapper.insert(broker);

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

    @Override
    @Transactional
    public void updatePersonSelectiveAndbroker(Person person) {
        Person p =getPersonById(person.getId());
        if(p.getUserid().intValue()!=person.getUserid().intValue()){
            Broker broker=brokerMapper.selectLaster(person.getId());
            if(broker!=null){
                broker.setEnddate(new Date());
                brokerMapper.updateByPrimaryKeySelective(broker);
            }
            broker = new Broker();
            broker.setClient(person.getId());
            broker.setPuller(person.getUserid());
            broker.setStartdate(new Date());
            brokerMapper.insert(broker);
        }
        personMapper.updateByPrimaryKeySelective(person);
    }
    @Transactional
    public void updatePersonSelective(Person person) {
        personMapper.updateByPrimaryKeySelective(person);
    }

    @Override
    public long getBetweenTimePerson(String startDate, String endDate) {
        return personMapper.getBetweenTimePerson(startDate,endDate);
    }
}
