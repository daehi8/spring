package spring.model;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxBean {
	
	@RequestMapping("date.do")
	public String date() {
		return "1216/date";
	}
	
	@RequestMapping("time.do")
	public String time(Model model) {
		model.addAttribute("time", new Date());
		return "1216/time";
	}
	
	@RequestMapping("time2.do")
	public @ResponseBody String time2() {
		Date d = new Date();
		// @ResponseBody는 숫자와 영문만 전송가능
		// 주로 간단한 결과를 보내는 데 사용
		// 디자인이 많이 필요한 경우에는 권장하지 않음
		return d.toString();
	}
}
