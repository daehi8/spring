package spring.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestBean {
	
	@RequestMapping("/test/main.do")
	public String main() throws Exception{
		Class c = Class.forName("oracle.jdbc.driver.OracleDriver");
		Object cn = c.newInstance();
		System.out.println(cn);
		return "test/main";
	}
}
