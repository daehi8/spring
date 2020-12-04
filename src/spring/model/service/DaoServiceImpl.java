package spring.model.service;

import java.sql.Connection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Service;

// *Impl - 서비스를 구현한 클래스
// 컨트롤러에 등록하지 않아도 Autowired 연결
@Service
public class DaoServiceImpl implements DaoService {

	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup(DaoService.dbConnect);
		return ds.getConnection();
    }
	
	@Override
	public List selectALl()throws Exception{
		return null;
	}
	
	@Override
	public Object selectOne(String id)throws Exception{
		return null;	
	}
}
