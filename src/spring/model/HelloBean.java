package spring.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 어노테이션으로 spring-servlet.xml 컨트롤의 요청을 받는다.
@Controller
public class HelloBean {
	
	// 컨트롤러의 요청이 해당 URL로 들어올경우 JSP페이지를 리턴시킨다.
	// 처음 실행시 RequestMapping을 모두 로딩
	@RequestMapping("/hello.do")
	public String hello() {
		return "/WEB-INF/view/1130/hello.jsp";
	}
	
	// 파라미터를 받는 방법
	@RequestMapping("/pro.do")
	public String text(DTO dto, String name, int num) {
		System.out.println(dto.getName()+""+dto.getNum());
		System.out.println(name+""+num);
		return "/WEB-INF/view/1130/pro.jsp";
	}
}
