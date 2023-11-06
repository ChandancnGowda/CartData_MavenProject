package com.maven.Maven_Cart_project;

import java.util.*;

public class Cart {
	private String name;
	private int age;
	private String experience;
	private double salary;
	
    
    
	public Cart(String name, int age, String experience, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.experience = experience;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
