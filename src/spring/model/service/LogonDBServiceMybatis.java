package spring.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch11.logon.LogonDataBean;

@Service("dao")
public class LogonDBServiceMybatis implements LogonDBService {

	@Autowired
	private SqlSessionTemplate dao = null;
	
	@Override
	public void insertMember(LogonDataBean dto) throws Exception {
		dao.update("member.insertMember", dto);
	}

	@Override
	public int userCheck(String id, String passwd) throws Exception {
		Map map = new HashMap();
		map.put("id", id);
		map.put("passwd", passwd);
		return dao.selectOne("member.userCheck", map);
	}

	@Override
	public int confirmId(LogonDataBean dto) throws Exception {
		return dao.selectOne("member.userCheck", dto);
	}

	@Override
	public LogonDataBean getMember(String id) throws Exception {
		return dao.selectOne("member.getMember", id);
	}

	@Override
	public void updateMember(LogonDataBean dto) throws Exception {
		dao.update("member.updateMember", dto);
	}

	@Override
	public void deleteMember(String id) throws Exception {
		dao.delete("member.deleteMember", id);
	}

	@Override
	public List selectAllMember() throws Exception {
		return dao.selectList("member.selectAllMember");
	}

}
