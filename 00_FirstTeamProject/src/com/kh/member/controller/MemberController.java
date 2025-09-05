package com.kh.member.controller;

import java.util.List;

import com.kh.member.model.dto.MemberDto;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

public class MemberController {
	MemberDto md = new MemberDto();
	
	public int signUp(String userId, String userPwd, String userName, String phone, String address) {
		Member member = new Member(userId, userPwd, userName, phone, address);
		int result = new MemberService().signUp(member);
		
		return result;
	}
	
	public Member login(String userId, String userPwd) {
		
		Member member = new MemberService().login(userId, userPwd);
		
		return member;
	}
	
	public Member findId(String userName, String phone) {
		
		Member member = new MemberService().findId(userName, phone);
		
		return member;
	}
	
	public int updatePwd(String userId, String userPwd, String userNewPwd) {
		
		int result = new MemberDto().updatePwd(userId, userPwd, userNewPwd);
		
		return result;
		
	}
	
	public List<Member> findAll(String adminId, String adminPwd) {
		
		List<Member> members = new MemberService().findAll(adminId, adminPwd);
		
		return members;
	}
}
