package com.second.group.controller;


import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.second.group.dto.SecondCommentDto;
import com.second.group.dto.SecondFileDto;
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
	public String SecondMypage(HttpServletRequest request) throws Exception {
		
		return "/second/mypage";
	}

	@RequestMapping(value = "/second/myBoard", method = RequestMethod.GET)
	public ModelAndView SelectSecondList(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("/second/myBoard");
		HttpSession session = request.getSession();
		
		String userId = "";
		if (session.getAttribute("userId") != null) {
			userId = session.getAttribute("userId").toString();
			List<SecondRecipeDto> list = secondService.selectSecondList(userId);
			mv.addObject("data", list);
		}
		List<SecondRecipeDto> list = secondService.selectSecondList(userId);
		mv.addObject("data", list);
		
		return mv;
	}
	
	@RequestMapping(value = "/second/mySearch", method = RequestMethod.GET)
	public ModelAndView SearchSecondList(HttpServletRequest request, String keyword) throws Exception {
		ModelAndView mv = new ModelAndView("/second/myBoard");
		HttpSession session = request.getSession();
		String userId = "";
		
		try {
			userId = session.getAttribute("userId").toString();
			List<SecondRecipeDto> list = secondService.searchSecondList(userId, keyword);
			mv.addObject("data", list);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return mv;
	}
	
	@RequestMapping("/second/secondList")
	public ModelAndView SecondList() throws Exception {
		ModelAndView mv = new ModelAndView("/second/secondList");
		
		List<SecondRecipeDto> recipeList = secondService.selectSecondRecipeList();
		
//		mv.addObject("list", recipeList);
		
		return mv;
	}
	
	@RequestMapping("/second/secondDetail")
	public ModelAndView SecondDetail(@RequestParam int idx) throws Exception {
		ModelAndView mv = new ModelAndView("/second/secondDetail");
		
		SecondRecipeDto recipe = secondService.selectRecipeDetail(idx);
		
		mv.addObject("recipe", recipe);
		
		return mv;
	}
	
	@RequestMapping("/second/secondWrite")
	public String SecondWrite() throws Exception {
		
		return "/second/secondWrite";
	}
	
	@RequestMapping("/second/recipeInsert")
	public String SecondInsert(SecondRecipeDto recipe, HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		
		session.getAttribute("userId");
		recipe.setUserUserId(session.getAttribute("userId").toString());
		secondService.insertRecipe(recipe);
		
		return "redirect:/second/secondList";
	}

	
	@RequestMapping("/second/secondEdit")
	public ModelAndView SecondEdit(@RequestParam int idx) throws Exception {
		ModelAndView mv = new ModelAndView("/second/secondEdit");
		
		SecondRecipeDto recipe = secondService.selectRecipeDetail(idx);
		
		mv.addObject("recipe", recipe);
		
		return mv;
	}
	
	@RequestMapping("/second/secondUpdate")
	public String SecondUpdate(SecondRecipeDto recipe) throws Exception {
		secondService.updateRecipe(recipe);
		
		return "redirect:/second/secondList";
	}
	
	@RequestMapping("/second/secondRemove")
	public ModelAndView SecondRemove(@RequestParam int idx) throws Exception {
		ModelAndView mv = new ModelAndView("/second/secondRemove");
		
		SecondRecipeDto recipe = secondService.selectRecipeDetail(idx);
		
		mv.addObject("recipe", recipe);
		
		return mv;
	}
	
	@RequestMapping("/second/secondFileDownload")
	public void SecondFileDownload(@RequestParam int fidx, @RequestParam int boardIdx, HttpServletResponse response) throws Exception {
		SecondFileDto secondFile = secondService.selectSecondFileInformation(fidx, boardIdx);
		
		if (ObjectUtils.isEmpty(secondFile) == false) {
			
			String fileName = secondFile.getFileName();
			
			byte[] files = FileUtils.readFileToByteArray(new File(secondFile.getStoredFilePath()));
			
			response.setContentType("application/octet-stream");
			response.setContentLength(files.length);
			response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(fileName, "UTF-8") + "\";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			
			response.getOutputStream().write(files);
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
			
		}
		
	}
	
	
	
	
	
	@RequestMapping("/second/secondDelete")
	public String SecondDelete(int idx) throws Exception {
		secondService.deleteRecipe(idx);
		
		return "redirect:/second/secondList";
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

	
//	로그인
	@RequestMapping(value = "/second/SecondLogin", method=RequestMethod.GET)
	public String SecondLogin() throws Exception {
		return "/second/SecondLogin";
	}
	
	@RequestMapping(value="/second/loginCheck", method=RequestMethod.POST)
	public String loginCheck(@RequestParam String userId, @RequestParam String userPw, HttpServletRequest request) throws Exception {
		
		System.out.println(userId + userPw);
		int count = secondService.selectUserInfoYn(userId, userPw); 
		if (count == 1) {
			SecondUserDto userInfo = secondService.selectUserInfo(userId, userPw);
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			session.setAttribute("userYear", userInfo.getUserYear().toString());
			session.setAttribute("userPhone", userInfo.getUserPhone().toString());
			session.setAttribute("userGender", userInfo.getUserGender().toString());
			session.setMaxInactiveInterval(600);
			
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
	
//	회원가입
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
	
	@RequestMapping(value = "/second/mypageUpdate", method = {RequestMethod.GET, RequestMethod.PUT})
	public String mypageUpdate() throws Exception {

		return "/second/mypageUpdate";
	}
	
	@RequestMapping(value = "/second/myPageDelete", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String deleteMypage(@RequestParam("idx") List<String> idx) throws Exception {
		if (idx == null || idx.size() > 0) {
			for(String id : idx) {
				int ids = Integer.parseInt(id);
				secondService.deleteMypage(ids);
			}
		}
		
		return "redirect:/second/myBoard";
	}
	
}













