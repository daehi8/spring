package spring.model;

import java.util.Date;

public class DTO {
	private String name;
	private int num;
	private Date day;
	
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
	
	public DTO(String name, int num, Date day) {
		this(name, num);
		this.day = day;
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
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
}
