package com.zzq.beauty.service;

import com.zzq.beauty.model.Broker;

public interface BrokerService {
    void insert (Broker broker);

    /**
     * 更新
     * @param  broker
     */
    void update(Broker broker);


    void updateBrokerSelective(Broker broker);

    /**
     * 更新最后的推荐人
     * @param clientID
     */
    void updateLasterBrokerEndDate(Integer clientID);


}
