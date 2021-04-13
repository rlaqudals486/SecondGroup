package com.second.group.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.second.group.dto.CommentDto;
import com.second.group.dto.RecipeDto;
import com.second.group.service.SecondService;

@Controller
public class SecondController {
	@Autowired
	private SecondService secondService;
	
	
	@RequestMapping("/second/SecondBoardList")
	public String SecondBoardList() throws Exception {
		return "/second/SecondBoardList";
	}
	
	
	@RequestMapping(value="/second", method=RequestMethod.GET)
	public ModelAndView HomeList() throws Exception{
		ModelAndView mv = new ModelAndView("/second/Home");
		
		List<RecipeDto> list = secondService.selectSecondList();
		List<CommentDto> comment = secondService.selectCommentList();
		
		mv.addObject("comment", comment);
		mv.addObject("datas", list);
		return mv;
	}
	
}
