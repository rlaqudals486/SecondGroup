package com.second.group.service;

import java.util.List;

import com.second.group.dto.SecondCommentDto;
import com.second.group.dto.SecondFileDto;
import com.second.group.dto.SecondRecipeDto;
import com.second.group.dto.SecondUserDto;

public interface SecondService {
	List<SecondRecipeDto> selectSecondHomeList() throws Exception;
	List<SecondRecipeDto> selectSecondList() throws Exception;
	List<SecondUserDto> selectUserList() throws Exception;
	List<SecondCommentDto> selectCommentHomeList() throws Exception;
	List<SecondRecipeDto> selectSecondRecipeList() throws Exception;
	
	SecondRecipeDto selectRecipeDetail(int idx) throws Exception;
	
	public void insertRecipe(SecondRecipeDto recipe) throws Exception;
	
	void updateRecipe(SecondRecipeDto recipe) throws Exception;
	
	void deleteRecipe(int idx) throws Exception;
	
	SecondFileDto selectSecondFileInformation(int fidx, int boardIdx) throws Exception;

}
