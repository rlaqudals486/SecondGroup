package com.second.group.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.second.group.dto.SecondCommentDto;
import com.second.group.dto.SecondRecipeDto;
import com.second.group.dto.SecondUserDto;
import com.second.group.service.SecondService;

@Controller
public class SecondController {
	@Autowired
	private SecondService secondService;
	

	
	@RequestMapping("/second/SecondBoardList")
	public String SecondBoardList() throws Exception {
		return "/second/SecondBoardList";
	}
	

	@RequestMapping(value="/second/mypage", method=RequestMethod.GET)
	public String SecondMypage() throws Exception {
		return "/second/mypage";
	}

	@RequestMapping(value = "/second/myBoard", method = RequestMethod.GET)
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
		
		List<SecondRecipeDto> lists = secondService.selectSecondHomeList();
		List<SecondCommentDto> comment = secondService.selectCommentHomeList();
		
		
		//images test용(img폴더 설정되면 지우고 lists에 연결 해야됨.)
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
		mv.addObject("data", lists);
		return mv;

	}
	



	@RequestMapping(value = "/second/SecondLogin", method=RequestMethod.GET)
	public String SecondLogin() throws Exception {
		return "/second/SecondLogin";
	}
	

	@RequestMapping(value="/second/loginCheck", method=RequestMethod.POST)
	public String loginCheck(@RequestParam String userId, @RequestParam String userPw, HttpServletRequest request) throws Exception {
		
		System.out.println(userId + userPw);
		int count = secondService.selectUserInfoYn(userId, userPw); 
		if (count == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			session.setMaxInactiveInterval(5); 
			
			return "redirect:/second/loginOK";
		}
		else {
			return "redirect:/second/loginFail";
		}
  }
	
	@RequestMapping(value="/second/loginOK", method=RequestMethod.GET)
	public String loginOK(HttpServletRequest request) throws Exception {
		return "/second/loginOK";
	}
	
	@RequestMapping(value="/second/loginFail", method=RequestMethod.GET)
	public String loginFail() throws Exception {
		return "/second/loginFail";
	}
	
	@RequestMapping(value="/second/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("userId");
		session.invalidate();
		
		return "/second/logout";
	}
	
	@RequestMapping(value = "/second/SecondJoin", method = RequestMethod.GET)
	public String writeSecondJoin() throws Exception {
		return "/second/SecondJoin";
	}

	@RequestMapping(value = "/second/SecondJoin", method = RequestMethod.POST)
	public String insertSecondJoin(SecondUserDto userData) throws Exception {
		secondService.insertSecondJoin(userData);

		return "redirect:/second/SecondLogin";
	}

//	아이디 중복검사
	@RequestMapping(value="/second/idCheck", method=RequestMethod.POST)
	@ResponseBody public String idCheck(String userId) throws Exception {
		
		int result = secondService.idCheck(userId);
		
		if(result != 0) { return "fail"; } else { return "success"; } 
		
	}
		

}
