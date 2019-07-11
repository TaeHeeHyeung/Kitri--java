package com.kitri.library.db;

import java.sql.Date;

public class RentDto {
	int rent_id;
	String isbn;
	String member_id;
	int extension_count;
	Date rent_date;
	Date extension_date;
	String renting;

	public String getRenting() {
		return renting;
	}

	public void setRenting(String renting) {
		this.renting = renting;
	}

	public RentDto(int rent_id, String isbn, String member_id, int extension_count, Date rent_date, Date extension_date,
			String renting) {
		super();
		this.rent_id = rent_id;
		this.isbn = isbn;
		this.member_id = member_id;
		this.extension_count = extension_count;
		this.rent_date = rent_date;
		this.extension_date = extension_date;
		this.renting = renting;
	}

	public int getRent_id() {
		return rent_id;
	}

	public void setRent_id(int rent_id) {
		this.rent_id = rent_id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getExtension_count() {
		return extension_count;
	}

	public void setExtension_count(int extension_count) {
		this.extension_count = extension_count;
	}

	public Date getRent_date() {
		return rent_date;
	}

	public void setRent_date(Date rent_date) {
		this.rent_date = rent_date;
	}

	public Date getExtension_date() {
		return extension_date;
	}

	public void setExtension_date(Date extension_date) {
		this.extension_date = extension_date;
	}

}
