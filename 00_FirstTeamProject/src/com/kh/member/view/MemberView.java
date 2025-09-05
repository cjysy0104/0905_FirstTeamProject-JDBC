package com.kh.member.view;

import java.util.Scanner;

import com.kh.member.controller.MemberController;

public class MemberView {
	Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	
	public void mainMenu() {
		System.out.println(" ---- 회원관리 프로그램 ---- ");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 아이디 찾기");
		System.out.println("4. 비밀번호 찾기");
		System.out.println("5. 비밀번호 변경");
		System.out.println("9. 프로그램 종료");
		System.out.print("메뉴를 선택해주세요 > ");
		int menuNo = sc.nextInt();
		sc.nextLine();
		
		switch(menuNo) {
		case 1 : signUp(); break;
		case 2 : break;
		case 3 : break;
		case 4 : break;
		case 5 : break;
		case 9 : break;
		}
		
	}
	
	public void signUp() {
		System.out.println(" ---- 회원가입 서비스 ---- ");
		System.out.print("아이디 > ");
		String userId = sc.nextLine();
		System.out.print("비밀번호 > ");
		String userPwd = sc.nextLine();
		System.out.print("이름 > ");
		String userName = sc.nextLine();
		System.out.print("연락처 > ");
		String phone = sc.nextLine();
		System.out.print("주소 > ");
		String address = sc.nextLine();
		
		int result = mc.signUp(userId, userPwd, userName, phone, address);
		
		if(result > 0) {
			System.out.println(userId + "님 환영합니다. 회원가입에 성공하셨습니다.");
		} else {
			System.out.println("회원가입에 실패하셨습니다. 다시 한 번 시도해주세요.");
		}
	}
	
	
}
