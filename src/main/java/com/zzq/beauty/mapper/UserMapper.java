package com.zzq.beauty.mapper;

import com.zzq.beauty.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 获取所有管理元
     * @return
     */
    List<Map<String,Object>> getUserList(String username);

    /**
     * 判断当前账号是否已经存在
     */
    Long isHaveUserName(String userName);
}