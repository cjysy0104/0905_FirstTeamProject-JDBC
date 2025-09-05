package com.kh.common.view;

import java.util.Scanner;

import com.kh.member.view.MemberView;
import com.kh.order.view.OrderView;
import com.kh.product.view.ProductView;

public class MainView {

	public void mainMenu() {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("메인메뉴");
			System.out.println("================================");
			System.out.println("1.멤버메뉴");
			System.out.println("2.상품메뉴");
			System.out.println("3.주문메뉴");
			int menuNo = sc.nextInt();
			sc.nextLine();
			
			switch (menuNo) {
			
			case 1: new MemberView().mainMenu(); break;
			case 2: new ProductView().prdMenu();break;
			case 3: new OrderView().mainMenu();break;
			}
		}
		
	}
}
