package com.second.group.service;

import java.util.List;


import com.second.group.dto.SecondCommentDto;
import com.second.group.dto.SecondRecipeDto;
import com.second.group.dto.SecondUserDto;

public interface SecondService {
	List<SecondRecipeDto> selectSecondHomeList() throws Exception;
	List<SecondCommentDto> selectCommentHomeList() throws Exception;

}
