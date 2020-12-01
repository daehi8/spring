package spring.model;

public class DTO {
	private String name;
	private int num;

	public DTO() {
		System.out.println("DTO 생성");
		this.name = "guest";
		this.num = 20;		
	}
	public DTO(String name) {
		this.name = name;
		this.num = 20;
	}
	public DTO(String name, int num) {
		this.name = name;
		this.num = num;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
