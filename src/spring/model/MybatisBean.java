package spring.model;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mybatis/")
public class MybatisBean {

	@Autowired
	private SqlSessionFactory dao = null;
	
	@RequestMapping("test.do")
	public String test() {
		System.out.println(dao);
		return "1208/test";
	}
}
