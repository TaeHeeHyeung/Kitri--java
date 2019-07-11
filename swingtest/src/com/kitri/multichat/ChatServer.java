package com.kitri.multichat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer implements Runnable {
//���� ����
// -�ʿ��� Ŭ����  
//	ServerSocket, Socket,
//	User(thread)  -> InputStream(BufferReader(Byte[])), OutputStream(Byte[])
// -Ŭ���� ����
// 	ServerSocket�� Socket�� Thread�� ���� ������ ����Ѵ�.
//  ����Ŭ������ �����Ͽ� ���� �Ѹ� �� �ϳ��� I/O Thread�� �Ҵ��Ѵ�.

//	�ó�����
//	ServerSocket�� ���� Socket�� ���� �� ����Ŭ������ ���� ����I/O��ü�� �����Ѵ�.
	ServerSocket ss;
	Socket s;
	//����� �����
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
				//������� �� �ڽ��� ����Ʈ�� �߰��ؾ��Ѵ�.
			}
		}
		
		
	}
	public static void main(String[] args) {
		new Thread(new ChatServer()).start();
	}

}// ChatServer
