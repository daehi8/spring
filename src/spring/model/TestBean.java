package spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.model.service.DaoService;

@Controller
public class TestBean {
	
	@Autowired
	private DaoService boardDaoImpl = null;
	
	@RequestMapping("/test/service.do")
	public String service() {
		System.out.println(boardDaoImpl);
		return "";
	}
	
	
	@RequestMapping("/test/main.do")
	public String main() throws Exception{
		Class c = Class.forName("oracle.jdbc.driver.OracleDriver");
		Object cn = c.newInstance();
		System.out.println(cn);
		return "test/main";
	}
}
