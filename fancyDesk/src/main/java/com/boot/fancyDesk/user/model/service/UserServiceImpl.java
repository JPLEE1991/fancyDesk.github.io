package com.boot.fancyDesk.user.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.fancyDesk.user.model.dao.UserDao;
import com.boot.fancyDesk.user.model.vo.User;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Override
	public int enrollUser(User user) {
		log.debug("Service단입니다.");
		int result = userDao.enrollUser(user);
		return result;
	}
	
	@Override
	public User selectOneUser(String id) {
		log.debug("Service단입니다.");
		User user = userDao.selectOneUser(id);
		return user;
	}

}
