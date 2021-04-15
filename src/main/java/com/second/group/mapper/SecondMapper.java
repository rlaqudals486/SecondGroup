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
	SecondRecipeDto selectRecipeDetail(int idx) throws Exception;
	void insertRecipe(SecondRecipeDto recipe) throws Exception;
	void insertSecondJoin(SecondUserDto userData) throws Exception;
  //	아이디 중복 검사
	int idCheck(String userId);
	int selectUserInfoYn(@Param("userId") String userId, @Param("userPw") String userPw) throws Exception;
}
