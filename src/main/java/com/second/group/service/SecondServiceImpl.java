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
	
	@Override
	public void insertSecondJoin(SecondUserDto userData) throws Exception {
		secondMapper.insertSecondJoin(userData);
	}
	
	@Override
	public int idCheck(String userId) throws Exception {
		return secondMapper.idCheck(userId);
	}
	
	@Override
	public int selectUserInfoYn(String userId, String userPw) throws Exception {
		return secondMapper.selectUserInfoYn(userId, userPw);
	}
	
	@Override
	public SecondUserDto selectUserInfo(String userId, String userPw) throws Exception {
		return secondMapper.selectUserInfo(userId, userPw);
	}
  
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

  public List<SecondRecipeDto> selectSecondList() throws Exception {
		return secondMapper.selectSecondList();
	}
  
  @Override
  public List<SecondRecipeDto> searchSecondList(String search) throws Exception{
	  return secondMapper.searchSecondList(search);
	  
  }

}