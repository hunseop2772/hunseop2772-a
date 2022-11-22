package day46;

import java.io.Serializable;

public class Day46_1 {

	public static void main(String[] args) {
		
	}
}
class User implements Serializable{
	private String id;
	private String pw;
	private String name;
	public User(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}
	
}