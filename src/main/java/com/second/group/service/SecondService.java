package com.second.group.service;

import java.util.List;

import com.second.group.dto.SecondRecipeDto;
import com.second.group.dto.SecondUserDto;

public interface SecondService {
	List<SecondRecipeDto> selectSecondList() throws Exception;
	
	void insertSecondJoin(SecondUserDto userData) throws Exception;
	
//	아이디 중복 검사
	int idCheck(String userId) throws Exception;
	
	int selectUserInfoYn(String userId, String userPw) throws Exception;
}
