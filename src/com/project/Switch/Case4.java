package com.project.Switch;

import java.util.Scanner;

import com.project.orders.DeleteOrders;
import com.project.users.NewUsersDAO;


public class Case4 {
	public void menu4(int num) {
		Scanner sc = new Scanner(System.in);
		NewUsersDAO nu = new NewUsersDAO();  
		if(num == 4) {
			DeleteOrders deleter = new DeleteOrders();
			System.out.print("탈퇴할 유저 ID : ");
			String id = sc.nextLine();
			System.out.print("탈퇴할 유저 NAME : ");
			String name = sc.nextLine();
			System.out.print("탈퇴할 유저 RRN : ");
			String rrn = sc.nextLine();


			int deletionResult = deleter.delete(id, name, rrn);

			if (deletionResult > 0) {
			    System.out.println("데이터 삭제 완료");
			} else {
			    System.out.println("데이터 삭제 실패");
			    }
		}
	}
	
}
