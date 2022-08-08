package com.boot.fancyDesk.user.model.dao;



import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boot.fancyDesk.user.model.vo.User;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserDaoImpl implements UserDao{
	
	@Autowired
	SqlSession sql;
	
    public void testXML() {
        System.out.print("--------------server started--------------");
        String testTXT = sql.selectOne("user.testXML");
        System.out.println("TIMESTAMP: " + testTXT);
    }
	
	@Override
	public int enrollUser(User user) {
		log.debug("Dao입니다. 매개변수는 "+user+"입니다.");
		int result = sql.insert("enrollUser", user);
		log.debug("Dao에서의 result 값은 "+result);
		return result;
	}

	@Override
	public User selectOneUser(String id) {
		User user = sql.selectOne("selectOneUser", id);
		log.debug("조회된 User의 객체는 "+user+"입니다");
		return user;
	}
	
}
