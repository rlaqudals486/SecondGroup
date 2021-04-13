package com.second.group.service;

import java.util.List;

import com.second.group.dto.SecondCommentDto;
import com.second.group.dto.SecondRecipeDto;
import com.second.group.dto.SecondUserDto;

public interface SecondService {

	List<SecondRecipeDto> selectSecondList() throws Exception;
	List<SecondUserDto> selectUserList() throws Exception;
	List<SecondCommentDto> selectCommentList() throws Exception;

}
