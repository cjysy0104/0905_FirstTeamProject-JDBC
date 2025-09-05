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

}
