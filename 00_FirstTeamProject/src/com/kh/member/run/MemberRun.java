package com.kh.member.run;

import com.kh.common.JDBCTemplate;
import com.kh.member.view.MemberView;

public class MemberRun {

	public static void main(String[] args) {
		JDBCTemplate.registDriver();
		MemberView mv = new MemberView();
		mv.mainMenu();
	}

}
