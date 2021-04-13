package com.second.group.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.group.dto.CommentDto;
import com.second.group.dto.RecipeDto;
import com.second.group.dto.UserDto;
import com.second.group.mapper.SecondMapper;


@Service
public class SecondServiceImpl implements SecondService {
	@Autowired
	SecondMapper secondMapper;
	
	@Override
	public List<RecipeDto> selectSecondList() throws Exception {
		return secondMapper.selectSecondList();
	}
	
	@Override
	public List<UserDto> selectUserList() throws Exception{
		return null;
	}
	@Override
	public List<CommentDto> selectCommentList() throws Exception{
		return secondMapper.selectCommentList();
	}
	
	
	
//
//	
//	@Override
//	public List<RecipeDto> selectSecondList() throws Exception {
//		return secondMapper.selectSecondList();
//	}

}