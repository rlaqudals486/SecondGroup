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
	public List<SecondCommentDto> selectCommentList(int cmtidx) throws Exception {
		
		return secondMapper.selectCommentList(cmtidx);
	}
	

	@Override
	public SecondRecipeDto selectRecipeDetail(int idx) throws Exception {
		
		SecondRecipeDto recipe = secondMapper.selectRecipeDetail(idx);
		
		List<SecondFileDto> fileList = secondMapper.selectSecondFileList(idx);
		recipe.setFileList(fileList);
		
		
		return recipe;
	}
	
	@Override
	public void createComment(int recipeIdx, String cmtContent) throws Exception {
		
		secondMapper.createComment(recipeIdx, cmtContent);
	}
	
	@Override
	public void updateComment(SecondCommentDto cDto) throws Exception {
		
		secondMapper.updateComment(cDto);
		
	}

	@Override
	public void deleteComment(int cmtidx) throws Exception {
		
		secondMapper.deleteComment(cmtidx);
		
	}

	@Override
	public int CommentCount(int recipeIdx) throws Exception {
		
		return 0;
	}
	
	
	
	@Override
	public void updateRecommend(int idx) throws Exception {

		secondMapper.updateRecommend(idx);
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
	
	@Override
	public void insertSecondFileList2(SecondRecipeDto recipe, MultipartHttpServletRequest uploadFiles) throws Exception {
		
		List<SecondFileDto> fileList = fileUtil.parseFileInfo(recipe.getIdx(), uploadFiles);
		
		if (CollectionUtils.isEmpty(fileList) == false) {
			secondMapper.insertSecondFileList(fileList);
		}
		
	}
	
	@Override
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
	
	@Override
	public List<SecondRecipeDto> searchSecondList(String userId, String keyword) throws Exception {
		return secondMapper.searchSecondList(userId, keyword);
	}
	
	@Override
	public void deleteMypage(int idx) throws Exception {
		secondMapper.deleteMypage(idx);
	}
	
	@Override
	public void bannedUser(String userId) throws Exception {
		secondMapper.bannedUser(userId);
	}
	
	@Override
	public List<SecondUserDto> searchAdminUser(String keyword) throws Exception {
		
		return secondMapper.searchAdminUser(keyword);
	}
	
	@Override
	public SecondUserDto MypageList(String userId1) throws Exception {
		return secondMapper.MypageList(userId1);
	}
  
	@Override
	public List<SecondRecipeDto> searchSecondList1(String search) throws Exception{
	    return secondMapper.searchSecondList1(search);
	}
	
	@Override
	public void MypageUpdate(SecondUserDto userId, MultipartHttpServletRequest uploadFiles) throws Exception {
		
		List<SecondFileDto> fileList = fileUtil.parseFileInfo(userId.getUserIdx(), uploadFiles);
		
		if (CollectionUtils.isEmpty(fileList) == false) {
			secondMapper.insertSecondFileList(fileList);
			for (SecondFileDto item : fileList) {
				userId.setFileName(item.getFileName());
				userId.setStoredFilePath(item.getStoredFilePath());
			}
		}
		
		secondMapper.MypageUpdate(userId);
	}
}