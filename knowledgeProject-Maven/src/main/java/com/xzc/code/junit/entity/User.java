package com.xzc.code.junit.entity;

public class User {
	private Long sid;
	private String name;
    private int sex;
    private int age;
	@Override
	public String toString() {
		return "User [sid=" + sid + ", name=" + name + ", sex=" + sex
				+ ", age=" + age + "]";
	}
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
    
}
