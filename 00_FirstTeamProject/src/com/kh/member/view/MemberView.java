package com.kh.member.view;

import java.util.List;
import java.util.Scanner;

import com.kh.member.controller.MemberController;
import com.kh.member.model.vo.Member;

public class MemberView {
	Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	
	public void mainMenu() {
		System.out.println(" ---- 회원관리 프로그램 ---- ");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 아이디 찾기");
		System.out.println("4. 비밀번호 변경");
		System.out.println("5. 전체회원 조회(관리자용)");
		System.out.println("9. 프로그램 종료");
		System.out.print("메뉴를 선택해주세요 > ");
		int menuNo = sc.nextInt();
		sc.nextLine();
		
		switch(menuNo) {
		case 1 : signUp(); break;
		case 2 : login(); break;
		case 3 : findId(); break;
		case 4 : updatePwd(); break;
		case 5 : findAll(); break;
		case 9 : System.out.println("안녕히 가세요"); break;
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
			System.out.println(userId + "님 축하드립니다. 회원가입에 성공하셨습니다.");
		} else {
			System.out.println("회원가입에 실패하셨습니다. 다시 한 번 시도해주세요.");
		}
	}
	
	public void login() {
		System.out.println(" ---- 로그인 하시겠습니까? ---- ");
		System.out.print("아이디 > ");
		String userId = sc.nextLine();
		System.out.print("비밀번호 > ");
		String userPwd = sc.nextLine();
		
		Member member = mc.login(userId, userPwd);
		
		if(member != null) {
			System.out.println(member.getUserName() + "님 환영합니다.");
			System.out.println("즐거운 쇼핑시간 되세요~♡");
		} else {
			System.out.println("로그인에 실패하였습니다. 다시 한 번 시도해주세요.");
		}
	}
	
	public void findId() {
		System.out.println(" ---- 아이디 찾기 ---- ");
		System.out.print("이름 > ");
		String userName = sc.nextLine();
		System.out.print("연락처 (예) 010-XXXX-XXXX > ");
		String phone = sc.nextLine();
		
		Member member = mc.findId(userName, phone);
		
		if(member != null) {
			System.out.println("찾으시는 아이디는 " + member.getUserId() + " 입니다.");
		} else {
			System.out.println("일치하는 정보가 없습니다.");
		}
	}
	
	public void updatePwd() {
		System.out.println(" ---- 비밀번호 변경하기 ---- ");
		System.out.println("아이디 > ");
		String userId = sc.nextLine();
		System.out.println("기존 비밀번호 > ");
		String userPwd = sc.nextLine();
		System.out.println("새로운 비밀번호 > ");
		String userNewPwd = sc.nextLine();
		
		int result = mc.updatePwd(userId, userPwd, userNewPwd);
		
		if(result > 0) {
			System.out.println("비밀번호가 성공적으로 변경되었습니다.");
		} else {
			System.out.println("비밀번호 변경에 실패하였습니다.");
		}
		}
	
	public void findAll() {
		System.out.println(" ---- 관리자용 조회 서비스 ---- ");
		System.out.print("아이디 > ");
		String adminId = sc.nextLine();
		System.out.print("비밀번호 > ");
		String adminPwd = sc.nextLine();
		
		List<Member> members = mc.findAll(adminId, adminPwd);
		
		if(!members.isEmpty()) {
			System.out.println("전체 회원 수는 총 : " + members.size() + "명 입니다.");
			for(Member member : members) {
				System.out.println("아이디 : " + member.getUserId());
				System.out.println("이름 : " + member.getUserName());
				System.out.println("연락처 : " + member.getPhone());
				System.out.println("주소 : " + member.getAddress());
			}
			
		}
		}
	}
	

