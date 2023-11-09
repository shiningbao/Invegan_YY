package kr.co.invegan.main.controller;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.invegan.admin.service.FoodService;
import kr.co.invegan.diet.dto.FoodDataDTO;
import kr.co.invegan.diet.dto.MyRecipeDTO;
import kr.co.invegan.diet.service.MyRecipeService;
import kr.co.invegan.main.service.MainService;
import kr.co.invegan.member.dto.MemberDTO;

@Controller
public class MainController {
	
	@Autowired MainService service;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value = {"/","/main"})
	public String main(HttpSession session) {
		return "main";
	}
	
	@RequestMapping(value = "/main/header")
	public String mainHeader(Model model, HttpSession session) {
		MemberDTO loginInfo = (MemberDTO) session.getAttribute("loginInfo");
		if(loginInfo != null) {			
			logger.info("loginId: "+loginInfo.getId()+" / user_no: "+loginInfo.getUser_no()+" / admin: "+loginInfo.getIs_admin());
			logger.info(loginInfo.getProfile_img());
		}else {
			logger.info("비회원");
		}
		
		/*
		if(loginInfo != null) {
			memberInfo = service.merberInfo(loginInfo.getId());
		}
		session.setAttribute("memberInfo", memberInfo);
		session.setAttribute("id", memberInfo.getId());
		logger.info("id : "+session.getAttribute("id")); 
		 */
		return "main/header";
	}
	
	@RequestMapping(value = "/main/footer")
	public String mainFooter(Model model) {
		return "main/footer";
	}
	

}
