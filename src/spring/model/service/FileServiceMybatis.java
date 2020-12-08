package spring.model.service;

import java.util.List;

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
		return null;
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

}
