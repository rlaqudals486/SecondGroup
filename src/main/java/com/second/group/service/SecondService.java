package com.second.group.service;

import java.util.List;


import com.second.group.dto.SecondCommentDto;
import com.second.group.dto.SecondRecipeDto;
import com.second.group.dto.SecondUserDto;

public interface SecondService {
	
	void insertSecondJoin(SecondUserDto userData) throws Exception; // 회원가입
	int idCheck(String userId) throws Exception; // 아이디 중복 검사
	int selectUserInfoYn(String userId, String userPw) throws Exception; // 로그인
    SecondUserDto selectUserInfo(String userId, String userPw) throws Exception;

	List<SecondRecipeDto> selectSecondHomeList() throws Exception;
	List<SecondRecipeDto> selectSecondList() throws Exception;
	List<SecondUserDto> selectUserList() throws Exception;
	List<SecondCommentDto> selectCommentHomeList() throws Exception;
	
	SecondRecipeDto selectRecipeDetail(int idx) throws Exception;
	
	public void insertRecipe(SecondRecipeDto recipe) throws Exception;
	List<SecondRecipeDto> searchSecondList(String search) throws Exception;
	
}
