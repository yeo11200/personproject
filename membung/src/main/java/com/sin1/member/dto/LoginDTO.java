package com.sin1.member.dto;

public class LoginDTO {
	private String id, pw, name;
	private int grade;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "LoginDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", grade=" + grade + "]";
	}
}