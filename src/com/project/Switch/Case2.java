package com.project.Switch;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.project.book.BookVO;
import com.project.book.GeneralUser;
import com.project.orders.OrdersBookDAO;
import com.project.orders.OrdersBookVO;
import com.project.users.LogIn;
import com.project.users.NewUsersDAO;
import com.project.users.UsersVO;

public class Case2 {
	Scanner sc = new Scanner(System.in);
	OrdersBookDAO obd = new OrdersBookDAO();
	OrdersBookVO obv = new OrdersBookVO();
	List<OrdersBookVO> list3 = null;
	String id = "";
	String pw = "";
	String name = "";
	String rrn = "";
	String bname = "";
	boolean isLoggedIn = false;
	int bid = 0;
	int result = 0;
	String btype = "";
	String input = "";
	List<UsersVO> list1 = null;
	List<BookVO> list = null;
	LogIn li = new LogIn();
	GeneralUser gus = new GeneralUser();

	public void menu2(int num) {
		//회원 로그인
		if (num == 2) {
			System.out.print("ID : ");
			id = sc.next();
			sc.nextLine();
			System.out.print("PW : ");
			pw = sc.next();
			sc.nextLine();
			list1 = li.login(id, pw);

			isLoggedIn = false;
			NewUsersDAO nu = new NewUsersDAO();
			UsersVO vo = new UsersVO(id);
			list1 = nu.UserSelectID();

			for(UsersVO uvo : list1) {
				if(uvo.getId().equalsIgnoreCase(id) && uvo.getPw().equals(pw)) {
					System.out.println("로그인 되었습니다.");
					isLoggedIn = true;
					break;
				}
			}
			if (isLoggedIn == false) {
			    System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
			}

			if (isLoggedIn == true) {
				while (true) {
					System.out.println("메뉴를 선택해주세요");
					System.out.print("1. 도서목록 조회 2. 장르검색 3. 책 구매 4. 구매한 책 리스트 0. 로그아웃 - ");
					String bookname = "";
					input = sc.nextLine();
					int num2;
					try {
						num2 = Integer.parseInt(input);
					} catch (NumberFormatException e) {
						System.out.println("숫자를 입력해주세요.");
						continue;
					}
					if (num2 == 0) {
						System.out.println("회원정보를 로그아웃 합니다.");
						break;
					}
					//회원 로그인 후 메뉴선택
					switch (num2) {
					case 1:
						System.out.println("모든 도서목록을 조회합니다.");
						list = gus.selectBookname();
						break;
					//-------------------장르검색--------------------
					case 2:
						System.out.println("찾으실 책 장르를 선택해주세요 : ");
						System.out.print("1. 판타지 2. 로맨스 3. 무협 4. 개그 5. 드라마 - ");

						int genereSelation;
						try {
							genereSelation = sc.nextInt();
						} catch (InputMismatchException e) {
							System.out.println("잘못된 입력입니다. 선택지로 돌아갑니다.");
							sc.nextLine();
							continue;
						}
						sc.nextLine(); // 개행 문자 제거
						switch (genereSelation) {
						case 1:
							list = gus.selectGenre(genereSelation);
							break;
						case 2:
							list = gus.selectGenre(genereSelation);
							break;
						case 3:
							list = gus.selectGenre(genereSelation);
							break;
						case 4:
							list = gus.selectGenre(genereSelation);
							break;
						case 5:
							list = gus.selectGenre(genereSelation);
							break;
						default:
							System.out.println("잘못된 숫자입니다. 1에서 5 사이의 숫자를 입력해주세요.");
							continue;
						}
						break;
					case 3:
						System.out.println("---------- 책구매 ------------");
						System.out.println("구매자 ID  : " + id);
						System.out.print("구매하실 책 이름 : ");
						bname = sc.nextLine();
						System.out.print("구매하실 책 타입 : ");
						btype = sc.nextLine();
						list = gus.selectGenre(bname, btype);
						list3 = obd.select(id);	
						for(BookVO bo : list) {
							obv = new OrdersBookVO(id, bname, btype);
							result = obd.salebook(obv);
							System.out.println("책 구매 성공 ! " + result);	
						}
						if(list.isEmpty()) {
							System.out.println("일치하는 책이 존재하지 않습니다.");
						}
						break;
					case 4:
						System.out.println("구매자 아이디 : " + id);
						obv = new OrdersBookVO(id);
						list3 = obd.select(id);
						boolean is = false;
						
						if(!list3.isEmpty()){
							System.out.print("책 이름을 입력해주세요. ");
							bname = sc.nextLine();
							is = false;
							for (OrdersBookVO bvo : list3) {
								if(bvo.getBookname().equals(bname) && bvo.getid().equals(id)) {
									System.out.println("독서 시작");
									
									System.out.print("독서 종료를 하고싶으시면  " + "'독서종료'" + "를 입력해주세요.  - ");
									String doc = sc.nextLine();
									if(doc.equalsIgnoreCase("독서종료")) {
										is = true;
										break;
									}
								}
							}
						}if(is == false) {
							System.out.println("입력하신 책명이 존재하지 않습니다.!! 다시 입력해주세요");
						}

						break;
					default:
						System.out.println("잘못 선택하였습니다.");
					}
				}
			}
		}

	}
}
