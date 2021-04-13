package com.second.group.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.second.group.dto.SecondRecipeDto;
import com.second.group.dto.SecondUserDto;

@Mapper
public interface SecondMapper {
	List<SecondRecipeDto> selectSecondList() throws Exception;
	
	void insertSecondJoin(SecondUserDto userData) throws Exception;
}
