package com.kh.member.controller;

import java.util.ArrayList;
import java.util.List;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

public class MemberController {

	public int signUp(String userId, String userPwd, String userName, String phone, String address) {
		Member member = new Member(userId, userPwd, userName, phone, address);
		int result = new MemberService().signUp(member);
		
		return result;
	}
}
