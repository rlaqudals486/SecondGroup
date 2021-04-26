package com.second.group.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.second.group.dto.SecondCommentDto;
import com.second.group.dto.SecondFileDto;
import com.second.group.dto.SecondRecipeDto;
import com.second.group.dto.SecondUserDto;

public interface SecondService {
	
	void insertSecondJoin(SecondUserDto userData, MultipartHttpServletRequest uploadFiles) throws Exception; // 회원가입
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
	List<SecondCommentDto> selectCommentList(int cmtidx) throws Exception;
	
	SecondRecipeDto selectRecipeDetail(int idx) throws Exception;
	void updateRecommend(int idx) throws Exception;
	
	void createComment(int recipeIdx, String cmtComment) throws Exception;
	void updateComment(SecondCommentDto cDto) throws Exception;
	void deleteComment(int cmtidx) throws Exception;
	int CommentCount(int recipeIdx) throws Exception;
	

	public void insertRecipe(SecondRecipeDto recipe/* , MultipartHttpServletRequest uploadFiles */) throws Exception;
	public void insertSecondFileList(SecondRecipeDto recipe, MultipartHttpServletRequest uploadFiles) throws Exception;
	public void insertSecondFileList2(SecondRecipeDto recipe, MultipartHttpServletRequest uploadFiles) throws Exception;
	List<SecondRecipeDto> searchSecondList1(String search) throws Exception;
	void updateRecipe(SecondRecipeDto recipe) throws Exception;
	
	void deleteRecipe(int idx) throws Exception;
	void deleteMypage(int idx) throws Exception;
	void bannedUser(String userId) throws Exception;
	SecondFileDto selectSecondFileInformation(int fidx, int boardIdx) throws Exception;
	
	SecondUserDto MypageList(String userId1) throws Exception;
	void MypageUpdate(SecondUserDto userId, MultipartHttpServletRequest uploadFiles) throws Exception;

}
