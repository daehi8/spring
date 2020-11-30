package spring.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// spring-servlet.xml 컨트롤의 요청을 받는다.
@Controller
public class HelloBean {
	
	@RequestMapping("/hello.do")
	public String hello() {
		return "/WEB-INF/view/1130/hello.jsp";
	}
	
	@RequestMapping("/pro.do")
	public String text(DTO dto, String name, int num) {
		System.out.println(dto.getName()+""+dto.getNum());
		System.out.println(name+""+num);
		return "/WEB-INF/view/1130/pro.jsp";
	}
}
