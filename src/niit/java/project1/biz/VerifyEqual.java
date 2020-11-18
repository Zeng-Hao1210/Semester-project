package niit.java.project1.biz;

import java.util.Scanner;

public class VerifyEqual {
	 
	/**
	 * 空构造方法
	 * 
	 */
	public VerifyEqual() {
	}
 
//仅仅验证用户名与密码是否匹配，必须同时匹配才可以
	public boolean verify(String username, String password) {
		
		// 由用户输入用户名
		System.out.print("请输入用户名：");
		Scanner scanner = new Scanner(System.in);
		String un = scanner.next();
		
		// 由用户输入密码
		System.out.print("请输入密码：");
		scanner = new Scanner(System.in);
		String pw= scanner.next();
		
		// 判断用户输入的信息是否和已有的信息一致
		return un.equals(username) && pw.equals(password);
	}
}
