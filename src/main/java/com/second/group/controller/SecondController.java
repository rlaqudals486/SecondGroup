package com.second.group.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.second.group.dto.SecondRecipeDto;
import com.second.group.service.SecondService;
import com.second.group.dto.SecondCommentDto;

@Controller
public class SecondController {

	@Autowired
	private SecondService secondService;
	
	@RequestMapping(value="/second/mypage", method=RequestMethod.GET)
	public String SecondBoardList() throws Exception {
		return "/second/mypage";
	}
	
	@RequestMapping(value="/second/myBoard", method=RequestMethod.GET)
	public ModelAndView SelectSecondList() throws Exception {
		ModelAndView mv = new ModelAndView("/second/myBoard");
		List<SecondRecipeDto> list = secondService.selectSecondList();
		mv.addObject("data", list);
		return mv;
	}
	
	@RequestMapping("/second/recipeDetailed")
	public String SecondDetail() throws Exception {
		return "/second/recipeDetailed";
	}
	
	@RequestMapping(value="/second", method=RequestMethod.GET)
	public ModelAndView HomeList() throws Exception{
		ModelAndView mv = new ModelAndView("/second/Home");
		
//		List<SecondRecipeDto> list = secondService.selectSecondHomeList();
		List<SecondCommentDto> comment = secondService.selectCommentHomeList();
		
		
		//images test용
		List<SecondRecipeDto> list = new ArrayList<SecondRecipeDto>();
		SecondRecipeDto item1 = new SecondRecipeDto();
		SecondRecipeDto item2 = new SecondRecipeDto();
		SecondRecipeDto item3 = new SecondRecipeDto();
		SecondRecipeDto item4 = new SecondRecipeDto();
		item1.setRecipeFilePath("/img/001.jpg");
		item2.setRecipeFilePath("/img/002.jpg");
		item3.setRecipeFilePath("/img/003.jpg");
		item4.setRecipeFilePath("/img/004.jpg");
		list.add(item1);
		list.add(item2);
		list.add(item3);
		list.add(item4);
		
		
		mv.addObject("comment", comment);
		mv.addObject("datas", list);
		return mv;

	@RequestMapping(value="/second/SecondLogin", method=RequestMethod.GET)
	public String SecondLogin() throws Exception {
		return "/second/SecondLogin";
	}
	
	@RequestMapping(value="/second/SecondJoin", method=RequestMethod.GET)
	public String SecondJoin() throws Exception {
		return "/second/SecondJoin";

	}
	
}





















