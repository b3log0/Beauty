package com.zzq.beauty.service.impl;

import com.github.pagehelper.PageHelper;
import com.zzq.beauty.mapper.UserMapper;
import com.zzq.beauty.model.User;
import com.zzq.beauty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	public void insert(User user){
		userMapper.insert(user);
	}
	@Override
	public List<Map<String,Object>> getUserList(int pageNum, int pageSize,String username){
		PageHelper.startPage(pageNum,pageSize);
		return userMapper.getUserList(username);
	}

	@Override
	public int isHaveUserName(String username) {
		return userMapper.isHaveUserName(username).intValue();
	}

	@Override
	public User getUserById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}
}
