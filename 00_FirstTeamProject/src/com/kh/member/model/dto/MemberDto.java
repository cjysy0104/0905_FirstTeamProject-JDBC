package com.kh.member.model.dto;

import com.kh.common.JDBCTemplate;

public class MemberDto {
	private String userId;
	private String userPwd;
	private String userNewPwd;
	
	public MemberDto() {
		JDBCTemplate.getConnection();
	}
	
	public MemberDto(String userId, String userPwd, String userNewPwd) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userNewPwd = userNewPwd;
		
	}
	
	public int updatePwd(String userId, String userPwd, String userNewPwd) {
		
		
	}
	
			
}
