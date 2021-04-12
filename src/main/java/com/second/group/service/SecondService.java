package com.second.group.service;

import java.util.List;

import com.second.group.dto.SecondRecipeDto;

public interface SecondService {
	List<SecondRecipeDto> selectSecondList() throws Exception;
}
