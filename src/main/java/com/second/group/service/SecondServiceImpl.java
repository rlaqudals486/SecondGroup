package com.second.group.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.second.group.common.FileUtil;
import com.second.group.dto.SecondCommentDto;
import com.second.group.dto.SecondFileDto;
import com.second.group.dto.SecondRecipeDto;
import com.second.group.dto.SecondUserDto;
import com.second.group.mapper.SecondMapper;

@Service
public class SecondServiceImpl implements SecondService {


	@Autowired
	SecondMapper secondMapper;
	
	@Autowired
	FileUtil fileUtil;
	
	@Override
	public List<SecondRecipeDto> selectSecondHomeList() throws Exception {
		return secondMapper.selectSecondHomeList();
	}
	
	@Override
	public void insertSecondJoin(SecondUserDto userData) throws Exception {
		secondMapper.insertSecondJoin(userData);
	}
	
	@Override
	public int idCheck(String userId) throws Exception {
		return secondMapper.idCheck(userId);
	}
	
	@Override
	public int selectUserInfoYn(String userId, String userPw) throws Exception {
		return secondMapper.selectUserInfoYn(userId, userPw);
	}
	
	@Override
	public SecondUserDto selectUserInfo(String userId, String userPw) throws Exception {
		return secondMapper.selectUserInfo(userId, userPw);
	}
	
	public List<SecondUserDto> selectUserList() throws Exception{
		return secondMapper.selectUserList();
	}
  
	@Override
	public List<SecondCommentDto> selectCommentHomeList() throws Exception{
		return secondMapper.selectCommentHomeList();
	}
	
	@Override
	public List<SecondRecipeDto> selectSecondRecipeList() throws Exception {
		return secondMapper.selectSecondRecipeList();
	}


	@Override
	public SecondRecipeDto selectRecipeDetail(int idx) throws Exception {
		
		SecondRecipeDto recipe = secondMapper.selectRecipeDetail(idx);
		
		List<SecondFileDto> fileList = secondMapper.selectSecondFileList(idx);
		recipe.setFileList(fileList);
		
		
		return recipe;
	}

	@Override
	public void insertRecipe(SecondRecipeDto recipe, MultipartHttpServletRequest uploadFiles) throws Exception {
		
		List<SecondFileDto> fileList = fileUtil.parseFileInfo(recipe.getIdx(), uploadFiles);
		
		if (CollectionUtils.isEmpty(fileList) == false) {
			secondMapper.insertSecondFileList(fileList);
		}
		
		secondMapper.insertRecipe(recipe);
		
	}
	
	@Override
	public void insertSecondFileList(SecondRecipeDto recipe, MultipartHttpServletRequest uploadFiles) throws Exception {
		
		List<SecondFileDto> fileList = fileUtil.parseFileInfo(recipe.getIdx(), uploadFiles);
		
		if (CollectionUtils.isEmpty(fileList) == false) {
			secondMapper.insertSecondFileList(fileList);
		}
		
	}
	
	

	public List<SecondRecipeDto> selectSecondList(String userId) throws Exception {

		return secondMapper.selectSecondList(userId);
	}

	@Override
	public void updateRecipe(SecondRecipeDto recipe) throws Exception {
		secondMapper.updateRecipe(recipe);
		
	}

	@Override
	public void deleteRecipe(int idx) throws Exception {
		secondMapper.deleteRecipe(idx);
	}

	@Override
	public SecondFileDto selectSecondFileInformation(int fidx, int boardIdx) throws Exception {
		return secondMapper.selectSecondFileInformation(fidx, boardIdx);
	}
	
	public List<SecondRecipeDto> searchSecondList(String userId, String keyword) throws Exception {
		return secondMapper.searchSecondList(userId, keyword);
	}
	
	public void deleteMypage(int idx) throws Exception {
		secondMapper.deleteMypage(idx);
	}
	
	public void bannedUser(String userId) throws Exception {
		secondMapper.bannedUser(userId);
	}
	
	public List<SecondUserDto> searchAdminUser(String keyword) throws Exception {
		return secondMapper.searchAdminUser(keyword);
	}



}