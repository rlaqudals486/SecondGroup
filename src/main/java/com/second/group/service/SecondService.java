package com.second.group.service;

import java.util.List;

import com.second.group.dto.SecondCommentDto;
import com.second.group.dto.SecondFileDto;
import com.second.group.dto.SecondRecipeDto;
import com.second.group.dto.SecondUserDto;

public interface SecondService {
	
	void insertSecondJoin(SecondUserDto userData) throws Exception; // 회원가입
	int idCheck(String userId) throws Exception; // 아이디 중복 검사
	int selectUserInfoYn(String userId, String userPw) throws Exception; // 로그인
	SecondUserDto selectUserInfo(String userId, String userPw) throws Exception;
	
	List<SecondRecipeDto> selectSecondHomeList() throws Exception;
	List<SecondRecipeDto> selectSecondList(String userId) throws Exception;
	List<SecondRecipeDto> searchSecondList(String userId,String keyword) throws Exception;
	List<SecondUserDto> searchAdminUser(String keyword) throws Exception; // 마이페이지 회원검색
	List<SecondUserDto> selectUserList() throws Exception;
	List<SecondCommentDto> selectCommentHomeList() throws Exception;
	List<SecondRecipeDto> selectSecondRecipeList() throws Exception;
	
	SecondRecipeDto selectRecipeDetail(int idx) throws Exception;
	
	public void insertRecipe(SecondRecipeDto recipe) throws Exception;
	
	void updateRecipe(SecondRecipeDto recipe) throws Exception;
	
	void deleteRecipe(int idx) throws Exception;
	void deleteMypage(int idx) throws Exception;
	void bannedUser(String userId) throws Exception;
	SecondFileDto selectSecondFileInformation(int fidx, int boardIdx) throws Exception;
	
	List<SecondUserDto> MypageFile() throws Exception;
	

}
