package com.second.group.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.second.group.dto.SecondCommentDto;
import com.second.group.dto.SecondFileDto;
import com.second.group.dto.SecondRecipeDto;
import com.second.group.dto.SecondUserDto;

@Mapper
public interface SecondMapper {
	List<SecondRecipeDto> selectSecondHomeList() throws Exception;

	List<SecondUserDto> selectUserList() throws Exception;

	List<SecondCommentDto> selectCommentHomeList() throws Exception;


	List<SecondRecipeDto> selectSecondList() throws Exception;
	
	List<SecondRecipeDto> selectSecondRecipeList() throws Exception;
  
	List<SecondRecipeDto> selectSecondList(@Param("userId") String userId) throws Exception;
  
	List<SecondRecipeDto> searchSecondList(@Param("userId") String userId, @Param("keyword") String keyword) throws Exception;
  
	List<SecondFileDto> selectSecondFileList(int boardIdx) throws Exception;
	
	SecondRecipeDto selectRecipeDetail(int idx) throws Exception;
	
	void insertRecipe(SecondRecipeDto recipe) throws Exception;
	
	void insertSecondFileList(List<SecondFileDto> fileList) throws Exception;
	
	void updateRecipe(SecondRecipeDto recipe) throws Exception;
	
	void deleteRecipe(int idx) throws Exception;
  
	void insertSecondJoin(SecondUserDto userData) throws Exception; // 회원가입
  
	int idCheck(String userId); // 아이디 중복검사
  
	int selectUserInfoYn(@Param("userId") String userId, @Param("userPw") String userPw) throws Exception; // 로그인
  
	SecondUserDto selectUserInfo(@Param("userId") String userId, @Param("userPw") String userPw) throws Exception;
 
	SecondFileDto selectSecondFileInformation(@Param("fidx") int fidx, @Param("boardIdx") int boardIdx) throws Exception;
	
	void deleteMypage(@Param("idx") int idx) throws Exception;
	
	void bannedUser(@Param("userId") String userId) throws Exception;
	
	List<SecondUserDto> searchAdminUser(@Param("keyword") String keyword) throws Exception;
	
	List<SecondUserDto> MypageFile() throws Exception;

	List<SecondRecipeDto> searchSecondList(@Param("search") String search) throws Exception;

	
}

