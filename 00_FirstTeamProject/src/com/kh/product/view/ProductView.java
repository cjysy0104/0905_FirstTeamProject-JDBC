package com.kh.product.view;

import java.util.List;
import java.util.Scanner;

import com.kh.product.controller.ProductController;
import com.kh.product.model.vo.Product;

public class ProductView {

	Scanner sc = new Scanner(System.in);
	ProductController pc = new ProductController();

	public void prdMenu() {

		while (true) {

			System.out.println("상품 목록 메뉴입니다.");
			System.out.println("1. 전체 상품 목록 조회");
			System.out.println("2. 특정 상품 목록 조회");
			System.out.println("3. 신규 상품 목록 기입");
			System.out.println("4. 특정 상품 삭제");
			System.out.println("9. 프로그램 종료");
			
			int menuNo = 0;
			
			
			try {
				menuNo = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				e.printStackTrace();
				sc.nextLine();
			}
			switch(menuNo) {
			case 1: findAll(); break;
			case 2: break;
			case 3: save(); break;
			case 4: break;
			case 9: break;
			default : System.out.println("잘못된 숫자 입력"); break;
			}

		}

	}

	/**
	 * View클래스: 현재 DB에 존재하는 데이터(상품)를 조회하는 메서드를 호출하여 결과값을 출력하는 메서드입니다.
	 * 값이 담긴 데이터를 List형태로 반환받아 데이터를 반복적으로 출력합니다.
	 * 
	 */
	private void findAll() {
		System.out.println("전체 상품 목록 조회 시스템입니다.");
		System.out.println("================================");

		List<Product> products = pc.findAll();
		if (products.isEmpty()) {
			System.out.println("현재 존재하는 상품이 없습니다.");
			return;
		} else {
			System.out.println("현재 존재하는 상품 리스트입니다.");
			for (Product product : products) {
				System.out.println(product.toString());
			}
		}
	}

	/**
	 * View클래스: 사용자에게 입력받아서 상품정보기입 메서드를 호출하고 결과를 출력하는 메서드입니다. 
	 * 입력받는것: 상품번호(String), 상품명(String), 카테고리(String), 가격(int), 재고수량(int)
	 * 메서드 호출을 통해 반환받은 result 값이 1 이상이면 성공, 0이 반환되면 실패입니다.
	 */
	private void save() {
		System.out.println("신규 상품 목록 기입 시스템입니다.");
		System.out.println("================================");

		String prdId, prdName, category;
		int price, stock;

		try {
			System.out.println("상품 ID?");
			prdId = sc.nextLine();
			System.out.println("상품명?");
			prdName = sc.nextLine();
			System.out.println("카테고리?");
			category = sc.nextLine();
			System.out.println("가격?");
			price = sc.nextInt();
			sc.nextLine();
			System.out.println("재고?");
			stock = sc.nextInt();
			sc.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("잘못된 입력: 메뉴로 돌아갑니다.");
			System.out.println("다시 시도해주세요.");
			return;
		}

		int result = pc.save(prdId, prdName, category, price, stock);

		if (result > 0) {
			System.out.println("입력하신 정보가 성공적으로 저장되었습니다.");
		} else {
			System.out.println("저장 실패, 다시 시도해주세요.");
		}
		System.out.println("메뉴로 돌아갑니다..");
	}
}
