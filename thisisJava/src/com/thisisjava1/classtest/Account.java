package com.thisisjava1.classtest;

public class Account{
	private String ano;
	private String owner;
	private int balance;
	public Account(String ano, String owner, int balance) {
		super();
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getBalance() {
		return balance;
	}
	public int inputBalance(int balance) {
		this.balance += balance;
		return balance;
	}
	public int outputBalance(int balance) {
		this.balance -= balance;
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
}//Account