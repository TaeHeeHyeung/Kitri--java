package com.kitri.multichat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer implements Runnable {
//서버 열기
// -필요한 클래스  
//	ServerSocket, Socket,
//	User(thread)  -> InputStream(BufferReader(Byte[])), OutputStream(Byte[])
// -클래스 설명
// 	ServerSocket과 Socket은 Thread를 통해 접속을 대기한다.
//  내부클래스를 구현하여 유저 한명 당 하나의 I/O Thread를 할당한다.

//	시나리오
//	ServerSocket을 통해 Socket을 받을 때 내부클래스를 통해 유저I/O객체를 생성한다.
	ServerSocket ss;
	Socket s;
	//연결된 사람들
	ArrayList<User> userlist;
	
	public ChatServer() {
		try {
			ss = new ServerSocket(ChatConstant.PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				s = ss.accept();
				new User().start();
//				userlist=new ArrayList<User>();
//				userlist.add(user);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // end while
	}
	class User extends Thread{
		BufferedReader in;
		OutputStream out;
		public User() {
			super();
			try {
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			while(true) {
				//연결됐을 때 자신을 리스트에 추가해야한다.
			}
		}
		
		
	}
	public static void main(String[] args) {
		new Thread(new ChatServer()).start();
	}

}// ChatServer
