package com.second.group.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.second.group.dto.SecondCommentDto;
import com.second.group.dto.SecondRecipeDto;
import com.second.group.dto.SecondUserDto;

@Mapper
public interface SecondMapper {
	List<SecondRecipeDto> selectSecondHomeList() throws Exception;
	List<SecondUserDto> selectUserList() throws Exception;
	List<SecondCommentDto> selectCommentHomeList() throws Exception;
	List<SecondRecipeDto> selectSecondList() throws Exception;
}
