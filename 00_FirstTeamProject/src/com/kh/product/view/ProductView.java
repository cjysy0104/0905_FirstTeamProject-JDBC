package com.kh.product.view;

import java.util.Scanner;

import com.kh.product.controller.ProductController;

public class ProductView {

	Scanner sc = new Scanner(System.in);
	ProductController pc = new ProductController();
	
	public void prdMenu() {
		
		while(true) {
			
			System.out.println("상품 목록 메뉴입니다.");
			System.out.println("1. 전체 상품 목록 조회");
			System.out.println("2. 특정 상품 목록 조회");
			System.out.println("3. 신규 상품 목록 기입");
			System.out.println("4. 특정 상품 삭제");
			System.out.println("9. 프로그램 종료");
			try {
				int menuNo = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		
		
	}
}
