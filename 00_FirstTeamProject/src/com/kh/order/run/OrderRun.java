package com.kh.order.run;

import com.kh.common.JDBCTemplate;
import com.kh.order.view.OrderView;

public class OrderRun {

	public static void main(String[] args) {
		
		JDBCTemplate.registDriver();
		OrderView ov = new OrderView();
		ov.mainMenu();


	}

}
