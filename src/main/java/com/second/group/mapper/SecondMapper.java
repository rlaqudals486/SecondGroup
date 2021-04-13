package com.second.group.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.second.group.dto.CommentDto;
import com.second.group.dto.RecipeDto;
import com.second.group.dto.UserDto;

@Mapper
public interface SecondMapper {
	List<RecipeDto> selectSecondList() throws Exception;
	List<UserDto> selectUserList() throws Exception;
	List<CommentDto> selectCommentList() throws Exception;
}
