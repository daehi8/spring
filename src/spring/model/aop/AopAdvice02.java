package spring.model.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

// AOP 어노테이션
@Aspect
public class AopAdvice02 {

	@Around("execution(public * spring.model..logon_*(..))")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		
		// Request 객체 사용
		RequestAttributes  ra = RequestContextHolder.currentRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes)ra;
		
		HttpServletRequest request = sra.getRequest();
		HttpSession session = request.getSession();
		
		System.out.println(request.getRequestURI());
		
		Object view = "member/error";
		if(session != null) {
			if(session.getAttribute("memId") != null) {
				view = jp.proceed();
			}
		}
		return view;
	}
}
