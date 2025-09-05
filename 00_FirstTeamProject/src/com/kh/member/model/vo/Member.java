package com.kh.member.model.vo;

import java.util.Objects;

public class Member {
	private String userId;
	private String userPwd;
	private String userName;
	private String phone;
	private String address;
	
	public Member() {
		super();
	}

	public Member(String userName) {
		super();
		this.userName = userName;
	}
	
	public Member(String userId, String userPwd) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
	}
	
	public Member(String userId, String userPwd, String userName, String phone, String address) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phone = phone;
		this.address = address;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", phone=" + phone
				+ ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, phone, userId, userName, userPwd);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(address, other.address) && Objects.equals(phone, other.phone)
				&& Objects.equals(userId, other.userId) && Objects.equals(userName, other.userName)
				&& Objects.equals(userPwd, other.userPwd);
	}
	
	
}
