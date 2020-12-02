package spring.model;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 어노테이션으로 spring-servlet.xml 컨트롤의 요청을 받는다.
@Controller
public class HelloBean {
	/*
	@Autowired - 컨트롤과 연결 시켜주는 어노테이션
	DTO를 인스턴스 변수로 선언
	컨트롤러에 있는 Bean DTO객체를 @Autowired DTO에 대입
	DI - dependency Injection
	객체를 미리 생성해 놓은 후 필요한 부분만 받아서 사용하는 형식
	@Autowired
	private DTO dto = null;	
	
	변수 이름 = bean id 
	
	bean을 여러개 생성했을때
	변수 이름이 컨트롤러의 bean에 없을경우 에러
	
	bean을 하나만  생성했을 경우는
	변수 이름이 달라도 연결 가능 
	 
	@Autowired
	private DTO d = null;
	*/
	
	// 컨트롤러의 요청이 해당 URL로 들어올경우 JSP페이지를 리턴시킨다.
	// 처음 실행시 RequestMapping을 모두 로딩
	@RequestMapping("/hello.do")
	public String hello() {
		return "1130/hello";
	}
	
	@RequestMapping("/pro.do")
	public String text(DTO dto, String name, int num, 
			HttpServletRequest request, 
			HttpServletResponse response,
			HttpSession session,
			// Model interface
			// 처리한 결과를 뷰로 보내는 용도
			// java.util.map으로 만들어졌다.
			// view에서 ${EL}로 사용할 수 있다.
			Model model) {
		
		model.addAttribute("name",name);
		model.addAttribute("num",num);
		model.addAttribute("dto",dto);
		
		return "1130/pro";
	}
	
	@RequestMapping("/pro2.do")
	public ModelAndView pro2() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("1130/pro");
		mv.addObject("name", "java");
		mv.addObject("num", 300);
		
		return mv;
	}
}















