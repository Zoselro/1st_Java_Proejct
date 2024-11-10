package com.project.Switch;

import java.util.List;
import java.util.Scanner;

import com.project.admin.AdminVO;
import com.project.admin.NewAdmin;
import com.project.book.BookDAO;
import com.project.book.BookVO;
import com.project.book.GeneralUser;

public class Case5 {
	Scanner sc = new Scanner(System.in);
	String codenumber = "";
	String password = "";
	List<AdminVO> list2 = null;
	String bname = "";
	String bgenre = "";
	String bwriter = "";
	String bprice = "";
	String btype = "";
	int result = 0;
	boolean is = false;
	BookVO bv = new BookVO();
	BookDAO bo = new BookDAO();
	GeneralUser gu = new GeneralUser();
	public void menu5(int num) {
		if (num == 5) {
			System.out.println("관리자 메뉴입니다");
			System.out.print("Codenumber : ");
			codenumber = sc.nextLine();
			System.out.print("PassWord : ");
			password = sc.next();
			sc.nextLine();
			list2 = new NewAdmin().adminlogin(codenumber, password);

			boolean isLogIn = false;
			for (AdminVO adv : list2) {
				if (adv.getCodenumber().equalsIgnoreCase(codenumber) && adv.getPassword().equals(password)) {
					System.out.println("관리자로 로그인 되었습니다.");
					isLogIn = true;
					while (true) {
						System.out.print("1. 책 추가 2. 책 삭제 0. 되돌아가기 - ");

						if (sc.hasNextInt()) {
							int submenuNum = sc.nextInt();
							sc.nextLine();
							switch (submenuNum) {
							case 1:
								System.out.print("책이름 : ");
								String name = sc.nextLine();
								System.out.print("책장르 : ");
								String genre = sc.nextLine();
								System.out.print("책작가 : ");
								String writer = sc.nextLine();
								System.out.print("책가격 : ");
								String price = sc.nextLine();
								System.out.print("책타입 : ");
								String type = sc.nextLine();
								int result = gu.selectBook(name, genre, writer, price, type);
								break;
								
							case 2:
								System.out.print("삭제 할 책 제목 : ");
								bname = sc.nextLine();
								System.out.print("책 타입 명 : ");
								btype = sc.nextLine();
								bv = new BookVO(bname, btype);
								result = bo.bookdelete(bv);
								System.out.println("책 삭제 완료 - " + result + "건");
								is = true;
								break;
							case 0:
								System.out.println("되돌아갑니다.");
								return;
							default:
								System.out.println("잘못된 메뉴 번호입니다.");
								break;
							}
						} else {
							System.out.println("숫자를 입력해주세요.");
							sc.nextLine();
							continue;
						}
						break;
					}
				}
			}
			if (isLogIn == false) {
				System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
			}
		}
	}
}
