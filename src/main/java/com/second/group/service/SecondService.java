package com.second.group.service;

import java.util.List;

import com.second.group.dto.SecondRecipeDto;
import com.second.group.dto.SecondUserDto;

public interface SecondService {
	List<SecondRecipeDto> selectSecondList() throws Exception;
	
	void insertSecondJoin(SecondUserDto userData) throws Exception;
}
