package com.project.Switch;

import java.util.List;
import java.util.Scanner;

import com.project.users.NewUsersDAO;
import com.project.users.UsersVO;
public class Case3 {
	Scanner sc = new Scanner(System.in);
	String name = "";
	String rrn = "";
	List<UsersVO> list1 = null;
	NewUsersDAO nu = new NewUsersDAO(); 
	boolean is = false;
	public void menu3(int num) {
		if(num == 3) {
			System.out.println("회원정보를 조회해볼 수 있습니다. (이름, 주민번호) ");
			System.out.print("이름 : ");
			name = sc.nextLine();
			System.out.print("주민번호 : ");
			rrn = sc.nextLine();
			list1 = nu.UserSelectID(name, rrn);
			for (UsersVO users : list1) {
				System.out.println(users);
				is = true;
			}
			if(is == false) {
				System.out.println("회원정보를 찾을 수 없습니다.");
			}
		}
	}
}
