package com.project.Switch;

import java.util.List;
import java.util.Scanner;

import com.project.users.NewUsersDAO;
import com.project.users.UsersVO;

public class Case1 {
	Scanner sc = new Scanner(System.in);
	String id = "";
	String pw = "";
	String name = "";
	String rrn = "";
	boolean is = true;
	NewUsersDAO nu = new NewUsersDAO();  
	List<UsersVO> list = null;
	public void menu1(int num) {
		if(num == 1) {
			System.out.print("ID : ");
			id = sc.nextLine();
			System.out.print("PW : ");
			pw = sc.nextLine();
			System.out.print("이름 : ");
			name = sc.nextLine();
			System.out.print("주민번호 : ");
			rrn = sc.nextLine();
			System.out.print("이메일 : ");
			String email = sc.nextLine();
			System.out.print("폰번호 : ");
			String phone = sc.nextLine();
			System.out.print("주소 : ");
			String address = sc.nextLine();
			nu = new NewUsersDAO();
			UsersVO vo = new UsersVO(id, pw, name, rrn, email, phone, address);	
			list = nu.UserSelectID();
			
			if(list.size() == 0) { // 최초 회원가입
				int insertCount = nu.insert(vo);
                if (insertCount == 1)
                   System.out.println("회원가입이 완료되었습니다.");
			} 
	         for (UsersVO users : list) {
	             if (id.equalsIgnoreCase(users.getId())) {
	                System.out.println("중복된 데이터가 존재합니다.");
	             }
	             else {
	                int insertCount = nu.insert(vo);
	                if (insertCount == 1)
	                   System.out.println("회원가입이 완료되었습니다.");
	             }
	          }
		}
	}
}

