package com.thisisjava1.classtest;

import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner (System.in);
	private static int peopleNum=0;
	public static void main(String[] args) {
		boolean run = true;
		while(run) {
			System.out.println("------------------------------");
			System.out.println("1.계좌생성 |2. 계좌목록 |3.예금| 4.출금| 5.종료");
			System.out.println("------------------------------");
			System.out.print("선택 :");
			
			int selectNo= scanner.nextInt();
			scanner.nextLine();
			
			if(selectNo == 1) {
				createAccount();
			}if(selectNo == 2) {
				accountList();
			}if(selectNo == 3) {
				deposit();
			}if(selectNo == 4) {
				withdraw();
			}if(selectNo == 5) {
				System.exit(0);
			}
		}
	}//end main
	private static void createAccount() {
		System.out.print("계좌번호: ");
		String ano = scanner.nextLine();
		System.out.print("계좌주: ");
		String owner= scanner.nextLine();
		System.out.print("초기입금액: ");
		int balence= scanner.nextInt();
		scanner.nextLine();
		
		accountArray[peopleNum] = new Account(ano, owner, balence);
		System.out.println("계좌가 생성되었습니다.");
		peopleNum++;
		
	}
	private static void accountList() {
		System.out.println("계좌목록");
		for(int i=0; i<accountArray.length;i++) {
			if(accountArray[i] ==null) {
				return ;
			}else {
				System.out.println(accountArray[i].getAno()+"\t"+accountArray[i].getOwner()+"\t"+accountArray[i].getBalance());
			}
		}
	}
	private static void deposit() {
		String ano=scanner.nextLine();
		Account acc= findAccount(ano);
		int balance = scanner.nextInt();
		acc.inputBalance(balance);
	}
	private static void withdraw() {
		String ano=scanner.nextLine();
		Account acc= findAccount(ano);
		int balance = scanner.nextInt();
		acc.inputBalance(balance);
	}
	private static Account findAccount(String ano) {
		for(int i=0; i<accountArray.length; i++) {
			if(accountArray[i].getAno().contentEquals(ano)) {
				return accountArray[i];		
			}
		}
		return null;
	}
	
}

