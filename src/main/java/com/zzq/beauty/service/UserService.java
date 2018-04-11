package com.zzq.beauty.service;

import com.zzq.beauty.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
	void insert(User user);
	List<Map<String,Object>> getUserList(int pageNum, int pageSize,String username);
	int isHaveUserName(String username);
}
