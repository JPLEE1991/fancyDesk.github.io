package com.boot.fancyDesk.user.model.dao;

import com.boot.fancyDesk.user.model.vo.User;

public interface UserDao {
	int enrollUser(User user);

	User selectOneUser(String id);
}
