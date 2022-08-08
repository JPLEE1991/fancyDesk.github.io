package com.boot.fancyDesk.user.model.service;

import com.boot.fancyDesk.user.model.vo.User;

public interface UserService {
	
	int enrollUser(User user);

	User selectOneUser(String id);

}
