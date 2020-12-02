package spring.model;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch11.logon.LogonDBBean;
import ch11.logon.LogonDataBean;

@Controller
@RequestMapping("/member/")
public class MemberBean {
	
	@Autowired
	private LogonDBBean memberDAO = null;
	
	@RequestMapping("main.do")
	public String main() {
		return "member/main";
	}
	
	@RequestMapping("inputForm.do")
	public String inputForm() {
		return "member/inputForm";
	}
	
	@RequestMapping(value="inputPro.do", method=RequestMethod.POST)
	public String inputPro(LogonDataBean dto) throws Exception{
		
		memberDAO.insertMember(dto);
		
		return "member/inputPro";
	}
	
	@RequestMapping("loginForm.do")
	public String loginForm() {
		return "member/loginForm";
	}
	
	@RequestMapping(value="loginPro.do", method=RequestMethod.POST)
	public String loginPro(LogonDataBean dto, HttpSession session, Model model) throws Exception {
		
		String id = dto.getId();
		String passwd = dto.getPasswd();
		
		int check = memberDAO.userCheck(id, passwd);
		if(check == 1) {
			session.setAttribute("memId", id);
		}
		model.addAttribute("check", check);
		return "member/loginPro";
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "member/logout";
	}
	
	@RequestMapping("modify.do")
	public String modify() {
		return "member/modify";
	}
	
	@RequestMapping("modifyForm.do")
	public String modifyForm() {
		return "member/modifyForm";
	}
	
	@RequestMapping("modifyPro.do")
	public String modifyPro() {
		return "member/modifyPro";
	}
	
	@RequestMapping("deleteForm.do")
	public String deleteForm() {
		return "member/deleteForm";
	}
	
	@RequestMapping("deletePro.do")
	public String deletePro() {
		return "member/deletePro";
	}
	
	@RequestMapping("confirmId.do")
	public String confirmId() {
		return "member/confirmId";
	}
}
