package spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 어노테이션으로 spring-servlet.xml 컨트롤의 요청을 받는다.
@Controller
public class HelloBean {
	
	// @Autowired - 컨트롤과 연결 시켜주는 어노테이션
	// DTO를 인스턴스 변수로 선언
	// 컨트롤러에 있는 Bean DTO객체를 @Autowired DTO에 대입
	// DI - dependency Injection
	// 객체를 미리 생성해 놓은 후 필요한 부분만 받아서 사용하는 형식
	@Autowired
	private DTO dto = null;	
	
	@Autowired
	private DTO dto2 = null;	
	
	@Autowired
	private DTO dto3 = null;
	
	// 컨트롤러의 요청이 해당 URL로 들어올경우 JSP페이지를 리턴시킨다.
	// 처음 실행시 RequestMapping을 모두 로딩
	@RequestMapping("/hello.do")
	public String hello() {
		System.out.println(dto.getName());
		System.out.println(dto2.getName());
		System.out.println(dto3.getName());
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
