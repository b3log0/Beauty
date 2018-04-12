package com.zzq.beauty.service.impl;

import com.zzq.beauty.mapper.BrokerMapper;
import com.zzq.beauty.model.Broker;
import com.zzq.beauty.service.BrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BrokerServiceImpl implements BrokerService{
    @Autowired
    private BrokerMapper brokerMapper;
    @Override
    public void insert(Broker broker) {
        brokerMapper.insert(broker);
    }

    @Override
    public void update(Broker broker) {
        brokerMapper.updateByPrimaryKey(broker);
    }

    @Override
    @Transactional
    public void updateLasterBrokerEndDate(Integer clientID) {

    }
}
