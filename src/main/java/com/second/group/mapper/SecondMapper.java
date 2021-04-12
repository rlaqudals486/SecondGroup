package com.second.group.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.second.group.dto.SecondRecipeDto;

@Mapper
public interface SecondMapper {
	List<SecondRecipeDto> selectSecondList() throws Exception;
}
