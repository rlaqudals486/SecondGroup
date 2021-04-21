package com.second.group.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.second.group.dto.SecondCommentDto;
import com.second.group.dto.SecondRecipeDto;
import com.second.group.dto.SecondUserDto;

@Mapper
public interface SecondMapper {
	List<SecondRecipeDto> selectSecondHomeList() throws Exception;

	List<SecondUserDto> selectUserList() throws Exception;

	List<SecondCommentDto> selectCommentHomeList() throws Exception;

	List<SecondRecipeDto> selectSecondList() throws Exception;

	void insertSecondJoin(SecondUserDto userData) throws Exception; // 회원가입

	int idCheck(String userId); // 아이디 중복검사

	int selectUserInfoYn(@Param("userId") String userId, @Param("userPw") String userPw) throws Exception; // 로그인

	void insertRecipe(SecondRecipeDto recipe) throws Exception;

	SecondUserDto selectUserInfo(@Param("userId") String userId, @Param("userPw") String userPw) throws Exception;

	SecondRecipeDto selectRecipeDetail(int idx) throws Exception;

	List<SecondRecipeDto> searchSecondList(@Param("search") String search) throws Exception;

	
}