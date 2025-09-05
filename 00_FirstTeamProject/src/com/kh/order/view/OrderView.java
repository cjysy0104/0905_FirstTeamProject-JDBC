package com.kh.order.view;

import java.util.List;
import java.util.Scanner;

import com.kh.order.controller.OrderController;
import com.kh.order.model.vo.Order;

public class OrderView {
	
	private Scanner sc = new Scanner(System.in);
	private OrderController oc = new OrderController();
	
	public void mainMenu() {
		
		while(true) {
			System.out.println(" ---- 주문 관리 프로그램 ---- ");
			System.out.println(" 1. 주문 전체 조회");
			System.out.println(" 2. 주문 번호로 조회");
			System.out.println(" 3. 주문하기");
			System.out.println(" 4. 주문 삭제");
			System.out.print(" 메뉴를 선택해주세요 > ");
			int menuNo = sc.nextInt();
			sc.nextLine();
			
			switch(menuNo) {
			case 1 : findAll(); break;
			case 2 : findById(); break;
			case 3 : save(); break;
			case 4 : break;
			case 9 : System.out.println("프로그램을 종료합니다."); return;
			default : System.out.println("잘못된 메뉴 선택입니다.");
			}
		}
	}
	
	private void findAll() {
		
		System.out.println("\n주문 전체 조회");
		
		List<Order> orders = oc.findAll();
		
		System.out.println("\n 총 주문 수는 " + orders.size() + "건 입니다.");
		if(orders.isEmpty()) {
			System.out.println("조회 결과가 존재하지 않습니다.");
		} else {
			
			for(Order order : orders) {
				System.out.println("===========================");
				System.out.println(order.getOrder_Id() + "번 주문 정보");
				System.out.print("주문번호 : " + order.getOrder_Id() + ", ");
				System.out.print("회원 아이디 : " + order.getUser_Id() + ", ");
				System.out.print("상품명 : " + order.getProduct_Id() + ", ");
				System.out.print("주문수량 : " + order.getOrder_No() + ", ");
				System.out.print("주문일자 : " + order.getOrder_Date());
				System.out.println();
			}
		}
		
	}
	
	private void findById() {
		
		System.out.println("\n주문번호 조회 서비스");
		System.out.print("주문번호를 입력해주세요 > ");
		String order_Id = sc.nextLine();
		
		Order order = oc.findById(order_Id);
		
		if(order != null) { //주문번호 회원아이디 상품명 주문수량 주문날짜
			System.out.println(order_Id + "번의 검색 결과입니다.");
			System.out.println("==========================");
			System.out.print("주문번호 : " + order.getOrder_Id() + ", ");
			System.out.print("회원아이디 : " + order.getUser_Id() + ", ");
			System.out.print("상품명 : " + order.getProduct_Id() + ", ");
			System.out.print("주문수량 : " + order.getOrder_No() + ", ");
			System.out.print("주문날짜 : " + order.getOrder_Date());
			System.out.println();
		} else {
			System.out.println("존재하지 않는 상품입니다.");
		}
		
		
	}
	
	private void save() {
		
		System.out.println(" ---- 주문하기 ---- ");
		
		System.out.println("주문 번호를 입력해주세요 > ");
		String order_Id = sc.nextLine();
		System.out.println("회원 아이디를 입력해주세요 > ");
		String user_Id = sc.nextLine();
		System.out.println("상품명을 입력해주세요 > ");
		String product_Id = sc.nextLine();
		System.out.println("주문 수량을 입력해주세요 > ");
		int order_No = sc.nextInt();
		sc.nextLine();
		
		int result = oc.save(order_Id, user_Id, product_Id, order_No);
		
		if(result > 0) {
			System.out.println("주문이 완료되었습니다.");
		} else {
			System.out.println("주문에 실패했습니다.");
		}
	}

}
