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
	
	SecondRecipeDto selectRecipeDetail(int idx) throws Exception;
	
	void insertRecipe(SecondRecipeDto recipe) throws Exception;
	
	void insertSecondFileList(List<SecondFileDto> fileList) throws Exception;
	
	List<SecondFileDto> selectSecondFileList(int boardIdx) throws Exception;
	
	void updateRecipe(SecondRecipeDto recipe) throws Exception;
	
	void deleteRecipe(int idx) throws Exception;
	
	SecondFileDto selectSecondFileInformation(@Param("fidx") int fidx, @Param("boardIdx") int boardIdx) throws Exception;
}
