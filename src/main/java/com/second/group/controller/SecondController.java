package com.second.group.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.second.group.dto.SecondCommentDto;
import com.second.group.dto.SecondFileDto;
import com.second.group.dto.SecondRecipeDto;
import com.second.group.service.SecondService;

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
	
	@RequestMapping("/second/secondList")
	public ModelAndView SecondList() throws Exception {
		ModelAndView mv = new ModelAndView("/second/secondList");
		
		List<SecondRecipeDto> recipeList = secondService.selectSecondRecipeList();
		
		mv.addObject("list", recipeList);
		
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
	public String SecondInsert(SecondRecipeDto recipe) throws Exception {
		
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
		
		List<SecondRecipeDto> list = secondService.selectSecondHomeList();
		List<SecondCommentDto> comment = secondService.selectCommentHomeList();
		
		mv.addObject("comment", comment);
		mv.addObject("datas", list);
		return mv;
	}
	
	

	@RequestMapping(value="/second/SecondLogin", method=RequestMethod.GET)
	public String SecondLogin() throws Exception {
		return "/second/SecondLogin";
	}
	
	@RequestMapping(value="/second/SecondJoin", method=RequestMethod.GET)
	public String SecondJoin() throws Exception {
		return "/second/SecondJoin";

	}
	
}





















