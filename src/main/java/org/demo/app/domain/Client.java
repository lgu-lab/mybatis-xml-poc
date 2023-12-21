package org.demo.app.domain;

public class Client {
    private int id;
    private String lastName;
    private String firstName;
    private int age;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", lastname=" + lastName + ", firstname=" + firstName + ", age=" + age + "]";
	}
    
    
}
