package spring.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.model.FileDTO;

@Service("testDAO")
public class TestServiceMybatis implements TestService{

	@Autowired
	private SqlSessionTemplate dao = null;
	
	@Override
	public List select(FileDTO dto) throws Exception {
		return dao.selectList("mybatis.selectColumn", dto);
	}

	@Override
	public void update(FileDTO dto) throws Exception {
		dao.update("mybatis.updateFile", dto);
	}

	@Override
	public List select(Object obj) throws Exception {
		return dao.selectList("mybatis.selectFor", obj);
	}

}
