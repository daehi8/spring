package spring.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService{
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/orcl");
		return ds.getConnection();
	}
	
	private void closeAll() {
		if(rs != null) {try {rs.close();}catch(SQLException s) {}}
		if(pstmt != null) {try {pstmt.close();}catch(SQLException s) {}}
		if(conn != null) {try {conn.close();}catch(SQLException s) {}}
	}
	
	@Override
	public int fileInsert(FileDTO dto) throws Exception {
		int num = 0;
		try {
			conn = getConnection();
			String sql = "insert into fileList(num, id, orgname, reg) values(fileList_seq.nextval,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getOrgname());
			pstmt.executeUpdate();
			
			sql = "select max(num) from fileList";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return num;
	}

	@Override
	public FileDTO selectNum(int num) throws Exception {
		FileDTO dto = new FileDTO();
		try {
			conn = getConnection();
			String sql = "select * from fileList where num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setNum(rs.getInt("num"));
				dto.setId(rs.getString("id"));
				dto.setOrgname(rs.getString("orgname"));
				dto.setSavename(rs.getString("savename"));
				dto.setReg(rs.getTimestamp("reg"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return dto;
	}

	@Override
	public List selectId(String id) throws Exception {
		return null;
	}

	@Override
	public void fileUpdate(FileDTO dto) throws Exception {
		try {
			conn = getConnection();
			String sql = "update fileList set savename=? where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSavename());
			pstmt.setInt(2, dto.getNum());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
	}

	@Override
	public void fileDelete(int num) throws Exception {
		
	}

	@Override
	public List selectAll() throws Exception {
		List list = new ArrayList();
		try {
			conn = getConnection();
			String sql = "select * from fileList order by reg desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FileDTO dto = new FileDTO();
				dto.setNum(rs.getInt("num"));
				dto.setId(rs.getString("id"));
				dto.setOrgname(rs.getString("orgname"));
				dto.setSavename(rs.getString("savename"));
				dto.setReg(rs.getTimestamp("reg"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return list;
	}
}
