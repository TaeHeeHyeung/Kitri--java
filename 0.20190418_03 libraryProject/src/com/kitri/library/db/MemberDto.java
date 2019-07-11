package com.kitri.library.db;

import java.sql.Date;

public class MemberDto {
	String member_id = "";
	String gender = "";
	String member_name = "";
	String phone_number = "";
	String address = "";
	String image_path = "";
	Date birthday = null;
//	memberAdd.tfMemberId.getText(),
//	memberAdd.group.getSelection().getActionCommand(), memberAdd.tfName.getText(),
//	memberAdd.tfPhone.getText(), "주소입력없다.", memberImagePath, sqlDate
	public MemberDto(String member_id, String gender, String member_name, String phone_number, String address,
			String image_path, Date birthday) {
		super();
		this.member_id = member_id;
		this.gender = gender;
		this.member_name = member_name;
		this.phone_number = phone_number;
		this.address = address;
		this.image_path = image_path;
		this.birthday = birthday;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public String getBirthdayStr() {
		return (birthday != null) ? birthday.toString() : "생일입력안했습니다.";
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
