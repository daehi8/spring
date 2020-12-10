package spring.model.service;

import ch11.logon.LogonDataBean;

public interface LogonDBService {
	 public void insertMember(LogonDataBean dto) throws Exception;

	 public int userCheck(String id, String passwd) throws Exception;
	 
	 public int confirmId(LogonDataBean dto) throws Exception;
	 
	 public LogonDataBean getMember(String id) throws Exception;
	 
	 public void updateMember(LogonDataBean dto) throws Exception;
	 
	 public void deleteMember(String id) throws Exception;
}
