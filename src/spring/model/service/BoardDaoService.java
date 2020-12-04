package spring.model.service;

import java.sql.Connection;
import java.util.List;

public interface BoardDaoService {
	
	// DB 연결 정보
	public Connection getConnection() throws Exception;
	
	// 글작성
	public void insertArticle(BoardDataBean article) throws Exception;
	
	// 전체 게시글 수 조회
	public int getArticleCount() throws Exception;
	
	// 페이지에 표시할 게시글 저장
	public List getArticles(int start, int end) throws Exception;
	
	// 게시글 조회
	public BoardDataBean getArticle(int num) throws Exception;
	
	// 게시글 정보 불러오기
	public BoardDataBean updateGetArticle(int num) throws Exception;
	
	// 게시글 수정
	public int updateArticle(BoardDataBean article) throws Exception;
	
	// 게시글 삭제
	public int deleteArticle(int num, String passwd) throws Exception;
}
