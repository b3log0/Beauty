package com.zzq.beauty.service;

import com.zzq.beauty.model.Broker;

public interface BrokerService {
    void insert (Broker broker);

    /**
     * 更新
     * @param  broker
     */
    void update(Broker broker);




    void updateLasterBrokerEndDate(Integer clientID);


}
