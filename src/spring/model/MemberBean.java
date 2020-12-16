package spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch11.logon.LogonDBBean;
import ch11.logon.LogonDataBean;
import spring.model.service.LogonDBService;

@Controller
@RequestMapping("/member/")
public class MemberBean {
	
	@Autowired
	private LogonDBService dao = null;
	
	@Autowired
	private LogonDataBean memberDTO = null;
	
	@RequestMapping("main.do")
	public String main() {
		return "member/main";
	}
	
	@RequestMapping("confirmId.do")
	public String confirmId(LogonDataBean dto, Model model) throws Exception {
		
		int check = dao.confirmId(dto);
		model.addAttribute("check", check);
		model.addAttribute("id", dto.getId());
		
		return "member/confirmId";
	}
	
	@RequestMapping("inputForm.do")
	public String inputForm() {
		return "member/inputForm";
	}
	
	@RequestMapping(value="inputPro.do", method=RequestMethod.POST)
	public String inputPro(LogonDataBean dto) throws Exception{
		
		dao.insertMember(dto);
		
		return "member/inputPro";
	}
	
	@RequestMapping("loginForm.do")
	public String loginForm() {
		return "member/loginForm";
	}
	
	@RequestMapping(value="loginPro.do", method=RequestMethod.POST)
	public String loginPro(
			String id,
			String passwd,
			HttpSession session, 
			Model model) throws Exception {

		int check = dao.userCheck(id, passwd);
		if(check == 1) {
			session.setAttribute("memId", id);
		}
		model.addAttribute("check", check);
		
		return "member/loginPro";
	}
	
	// 로그인 후 사용 가능 메서드 이름 앞에 logon_ 를 붙여준다.
	@RequestMapping("logout.do")
	public String logon_logout(HttpSession session) {
		
		session.invalidate();
		
		return "member/logout";
	}
	
	@RequestMapping("modify.do")
	public String logon_modify() {
		return "member/modify";
	}
	
	@RequestMapping("modifyForm.do")
	public String logon_modifyForm(HttpSession session, Model model) throws Exception {
		
		String id = (String) session.getAttribute("memId");
		memberDTO = dao.getMember(id);
		model.addAttribute("dto", memberDTO);
		
		return "member/modifyForm";
	}
	
	@RequestMapping("modifyPro.do")
	public String logon_modifyPro(LogonDataBean dto, 
			HttpSession session, 
			Model model) throws Exception {
		
		String sessionId = (String)session.getAttribute("memId");
		dto.setId(sessionId);
		dao.updateMember(dto);

		return "member/modifyPro";
	}
	
	@RequestMapping("deleteForm.do")
	public String logon_deleteForm() {
		return "member/deleteForm";
	}
	
	@RequestMapping("deletePro.do")
	public String logon_deletePro(String passwd, HttpSession session, Model model) throws Exception {
		
		String id = (String)session.getAttribute("memId");
		int check = dao.userCheck(id, passwd);
		if(check == 1) {
			dao.deleteMember(id);
			session.invalidate();
		}
		model.addAttribute("check", check);
		
		return "member/deletePro";
	}
	
	@RequestMapping("allmember.do")
	public String selectAllMember(Model model) throws Exception{
		model.addAttribute("memlist", dao.selectAllMember());
		return "member/selectAllMember";	
	}
}
