package com.project.Switch;

import java.util.List;
import java.util.Scanner;

import com.project.users.NewUsersDAO;
import com.project.users.UsersVO;

public class SwitchUsers {
	String name = "";
	String rrn = "";
	boolean is = false;
	List<UsersVO> list1 = null;
	NewUsersDAO nu = new NewUsersDAO();

	public void menu() {
		Scanner sc = new Scanner(System.in);
		Case1 ca1 = new Case1();
		Case2 ca2 = new Case2();
		Case3 ca3 = new Case3();
		Case4 ca4 = new Case4();
		Case5 ca5 = new Case5();
	    while (true) {
            System.out.println("============메뉴선택============");
            System.out.println("1. 회원가입 2.로그인 3. 회원정보 조회");
            System.out.println("4. 회원탈퇴 5. 관리자 메뉴");
            System.out.print("번호 입력 : ");
            
            //------------------------------------------------------
            try {
                int num = Integer.parseInt(sc.nextLine()); 
                if (num == 0) {
                    System.out.println("시스템을 종료합니다.");
                    break;
                } else if (num >= 1 && num <= 5) {
                    ca1.menu1(num); // 회원가입 메뉴
                    ca2.menu2(num); // 로그인 메뉴
                    ca3.menu3(num); // 회원정보 조회 메뉴
                    ca4.menu4(num); // 회원탈퇴 메뉴
                    ca5.menu5(num); // 관리자 메뉴
                } else {
                    System.out.println("잘못된 메뉴 번호입니다. 1에서 5 사이의 숫자를 입력해주세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
                continue;
            }
          
        }
    }
}