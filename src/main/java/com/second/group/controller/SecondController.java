package com.second.group.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.second.group.dto.SecondRecipeDto;
import com.second.group.service.SecondService;

@Controller
public class SecondController {
	
	@Autowired
	SecondService secondService;
	
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
	
}
