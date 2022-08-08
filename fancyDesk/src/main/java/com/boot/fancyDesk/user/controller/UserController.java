package com.boot.fancyDesk.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boot.fancyDesk.user.model.service.UserService;
import com.boot.fancyDesk.user.model.vo.User;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/user/enroll.do")
	public String enrollUser(User user, RedirectAttributes redirect) {
		
		log.debug("여기는 userController입니다.");
		int result = userService.enrollUser(user); 
		String enrollResult = result>-1? "실패":"성공"; 
		System.out.println("사용자등록 결과: "+enrollResult);
		return "redirect:/";             
	}
	
	@PostMapping("/user/userLogin.do")
	public String userLogin(HttpServletRequest request,@RequestParam String id,@RequestParam String password,Model model,RedirectAttributes redirectAttr) {
		log.debug("여기는 userController userLogin 메서드입니다.");
		log.debug("전달받은 id는 "+id+", pw는 "+password+"입니다");
		User user = userService.selectOneUser(id);
		
		String msg = "";
		msg = user.getPassword().equals(password)? "비밀번호 일치!":"비밀번호를 잘못 입력하셨습니다";
		log.debug("msg의 내용은 " + msg);
		model.addAttribute("msg",msg);
		
		if("비밀번호를 잘못 입력하셨습니다".equals(msg)) {
			//로그인 실패
			user = new User();
			System.out.println("if문 들어옵니까!!!!!!!!!!!/");
		}
		User loginMember = user;
		
		redirectAttr.addFlashAttribute("loginMember", loginMember);
		redirectAttr.addFlashAttribute("msg", msg);
//		model.addAttribute("loginMember", loginMember);

		System.out.println("나가기 전 user.getId() 체크: "+user.getId());
		
		String url = request.getHeader("Referer");
		System.out.println("url 체크: "+url);
		return "redirect:/";
	}
}
