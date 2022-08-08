package com.boot.fancyDesk.user.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class User {
	private static final long serialVersionUID = 1L;

	String id;
	String password;
	String name;
	int birth;
	

}
