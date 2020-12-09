package spring.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.model.FileDTO;
import spring.model.FileService;

@Service("fileDAO")
public class FileServiceMybatis implements FileService{

	@Autowired
	private SqlSessionTemplate dao = null;
	
	@Override
	public int fileInsert(FileDTO dto) throws Exception {
		return 0;
	}

	@Override
	public FileDTO selectNum(int num) throws Exception {
		return null;
	}

	@Override
	public List selectId(String id) throws Exception {
		return dao.selectList("test.selectList", id);
	}

	@Override
	public void fileUpdate(FileDTO dto) throws Exception {
		
	}

	@Override
	public void fileDelete(int num) throws Exception {
		
	}

	@Override
	public List selectAll() throws Exception {
		return dao.selectList("test.selectAll");
	}

	@Override
	public String selectId(int num) throws Exception {
		//호출할 sql, parameter 대입값 작성
		return dao.selectOne("test.selectOne", num);
	}

	@Override
	public String selectFile(FileDTO dto) throws Exception {
		//return dao.selectOne("test.selectFile", dto);
		Map map = new HashMap();
		map.put("mid", "java");
		map.put("mnum", "16");
		return dao.selectOne("test.selectMap", map);
	}

	@Override
	public int selectCount() throws Exception {		
		return dao.selectOne("test.selectCount");
	}

}
