package com.second.group.service;

import java.util.List;

import com.second.group.dto.CommentDto;
import com.second.group.dto.RecipeDto;
import com.second.group.dto.UserDto;

public interface SecondService {

	List<RecipeDto> selectSecondList() throws Exception;
	List<UserDto> selectUserList() throws Exception;
	List<CommentDto> selectCommentList() throws Exception;

}
