package spring.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aop/")
public class AopBean {
	
	@RequestMapping("main.do")
	public String main() {
		System.out.println("aop main.do");
		return "1214/main";
	}
	
	@RequestMapping("home.do")
	public String home() {
		System.out.println("aop home.do");
		return "1214/home";
	}
}
