package com.second.group.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.group.dto.SecondRecipeDto;
import com.second.group.dto.SecondUserDto;
import com.second.group.mapper.SecondMapper;

@Service
public class SecondServiceImpl implements SecondService {
	
	@Autowired
	SecondMapper secondMapper;
	
	@Override
	public List<SecondRecipeDto> selectSecondList() throws Exception {
		return secondMapper.selectSecondList();
	}
	
	@Override
	public void insertSecondJoin(SecondUserDto userData) throws Exception {
		secondMapper.insertSecondJoin(userData);
	}

}
