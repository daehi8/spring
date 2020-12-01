package spring.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberBean {
	
	@RequestMapping("/member/main.do")
	public String main() {
		return "/WEB-INF/view/member/main.jsp";
	}
}
