package com.kh.member.model.dto;

import com.kh.member.model.service.MemberService;

public class MemberDto {
	private String userId;
	private String userPwd;
	private String userNewPwd;
	
	public MemberDto() {

	}
	
	public MemberDto(String userId, String userPwd, String userNewPwd) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userNewPwd = userNewPwd;
		
	}
	
	public int updatePwd(String userId, String userPwd, String userNewPwd) {
		MemberDto memberDto = new MemberDto(userId, userPwd, userNewPwd);
		
		int result = new MemberService().updatePwd(memberDto);
		
		return result;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserNewPwd() {
		return userNewPwd;
	}

	public void setUserNewPwd(String userNewPwd) {
		this.userNewPwd = userNewPwd;
	}
	
	
	
			
}
