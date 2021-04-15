package com.second.group.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.second.group.dto.SecondCommentDto;
import com.second.group.dto.SecondRecipeDto;
import com.second.group.dto.SecondUserDto;
import com.second.group.mapper.SecondMapper;

@Service
public class SecondServiceImpl implements SecondService {


	@Autowired
	SecondMapper secondMapper;
	
	@Override
	public List<SecondRecipeDto> selectSecondHomeList() throws Exception {
		return secondMapper.selectSecondHomeList();
	}
  
  public List<SecondRecipeDto> selectSecondList() throws Exception {
		return secondMapper.selectSecondList();
	}
	
	@Override
	public List<SecondUserDto> selectUserList() throws Exception{
		return null;
	}
	@Override
	public List<SecondCommentDto> selectCommentHomeList() throws Exception{
		return secondMapper.selectCommentHomeList();
	}

	@Override
	public SecondRecipeDto selectRecipeDetail(int idx) throws Exception {
		
		SecondRecipeDto recipe = secondMapper.selectRecipeDetail(idx);
		
		return recipe;
	}

	@Override
	public void insertRecipe(SecondRecipeDto recipe) throws Exception {
		
		secondMapper.insertRecipe(recipe);
		
	}
	
//
//	
//	@Override
//	public List<RecipeDto> selectSecondList() throws Exception {
//		return secondMapper.selectSecondList();
//	}

}