package ch11.logon;

// 표준화 인터페이스
public interface LogonDBBeanService {
	public static final String serverName="orcle.jdbc.driver.OracleDriver";
	public static final String user="java05";
	public static final String pass="java";
	public static final String url="jdbc:oracle:thin:@masternull.iptime.org:1521:orcl";

	/*
	 * id / passwd - 필수항목
	 * name - 인코딩처리
	 * reg_date - 현재시간
	 * age - 기본값 0
	 * 위의 정보를 포함하는 메소드를 오버라이딩해서 생성
	 * 협업과 유지보수를 위해  인터페이스로 표준화해서 생성
	 */
	public void insertMember(LogonDataBean member)throws Exception;
	public int userCheck(String id, String passwd)throws Exception;
	public int confirmId(String id)throws Exception;
	public LogonDataBean getMember(String id)throws Exception;
	public void updateMember(LogonDataBean member)throws Exception;
	public int deleteMember(String id, String passwd)throws Exception;
}
