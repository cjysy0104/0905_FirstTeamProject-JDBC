package com.kh.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.kh.common.JDBCTemplate;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {
	Connection conn = JDBCTemplate.getConnection();
	
	public int signUp(Member member) {
	
		int result = new MemberDao().signUp(conn, member);
		
		if(result > 0) {
		JDBCTemplate.commit(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public Member login(String userId, String userPwd) {

		Member member = new MemberDao().login(conn, userId, userPwd);
		
		
		return member;
	}
	
	public Member findId(String userName, String phone) {
		
		Member member = new MemberDao().findId(conn, userName, phone);
		
		
		return member;
		
	} 
}
