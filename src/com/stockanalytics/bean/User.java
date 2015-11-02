package com.stockanalytics.bean;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class User {
	private String _id;
	private String name;
	private int age;
	public String getId() {
		return _id;
	}
	public void setId(String id) {
		this._id = id;
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
	@Override
	public String toString() {
		return "User [id=" + _id + ", name=" + name + ", age=" + age + "]";
	}
	
}
