package com.kitri.chat.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.stream.Stream;

import com.kitri.chat.util.ChatConstance;

//추 후 프레임을 상속받을테니 implements를 하여 쓰레드를 사용하자
public class ChatServer implements Runnable {
	String myName;

	Vector<ChatClient> list = new Vector<ChatClient>();
	ServerSocket ss;

	public ChatServer() {
		try {
			ss = new ServerSocket(ChatConstance.PORT);
			System.out.println("클라이언트접속 대기중");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}// end ChatServer

	@Override // 접속처리
	public void run() {
		while (true) {
			try {
				Socket socket = ss.accept();
				System.out.println("클라이언트접속 성공::" + socket);
				new ChatClient(socket).start();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}// end run

	class ChatClient extends Thread {
		String name;
		BufferedReader in;
		OutputStream out;
		Socket socket;

		public ChatClient(Socket socket) {
			this.socket = socket;
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = socket.getOutputStream();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override // 메시지처리
		public void run() {
			boolean flag = true;
			while (flag) {
				try {
					String msg = in.readLine();
					System.out.println("클라이언트가 보낸 메시지:" + msg); // protocol | 메시지형식...
					StringTokenizer st = new StringTokenizer(msg, "|");
					int protocol = Integer.parseInt(st.nextToken());
					switch (protocol) {
					case ChatConstance.CS_CONNECT:
//						100|대화명
						name = st.nextToken();
						multicast(ChatConstance.SC_CONNECT + "|" + name);
						list.add(this);
						for (ChatClient cc : list) { // 향상된 포문 for each
							this.unicast(ChatConstance.SC_CONNECT + "|" + cc.name);
						}
						break;
					case ChatConstance.CS_ALL: {
						// 200|안녕하세요.
						String tmp = st.nextToken();
						multicast(ChatConstance.SC_MESSAGE + "|[" + name + "]" + tmp);
						break;
					}
					case ChatConstance.CS_TO: {
						String to = st.nextToken();// 홍길동
						String tmp = st.nextToken();// 안녕?
						for (ChatClient cc : list) {
							if (cc.name.equals(to)) {
								cc.unicast(ChatConstance.SC_MESSAGE + "|☆" + name + "☆" + tmp);
								break;
							}
						}
						break;
					}
					case ChatConstance.CS_PAPER: {
//						쪽지보내기			300|귓속말 대상자| 메시지
						String to = st.nextToken();
						System.out.println("to:" + to);
						String content = st.nextToken();
						System.out.println("content : " + content);
						for (ChatClient cc : list) {
							if (cc.name.equals(to)) {
//								System.out.println("보내는 메시지: "+ChatConstance.SC_PAPER + "|" + to + "|" + content);
								cc.unicast(ChatConstance.SC_PAPER + "|" + name + "|" + content);
								break;
							}
						}
						break;
					}
					case ChatConstance.CS_RENAME: {
						String oldName = name;
						name = st.nextToken();						
//						대화명변경			400|변경전 대화명 | 변경할 대화명
						multicast(ChatConstance.SC_RENAME + "|" + oldName + "|" + name);
						break;
					}
					case ChatConstance.CS_DISCONNECT: {
						multicast(ChatConstance.SC_DISCONNECT + "|" + name);
						list.remove(this);
						flag = false;// switch case이기 때문에 break로 나갈수없다 그래서 flag 사용
//						in out socket 중 하나라도 null이면 case문을 들어올 수 없다.
//						if (in != null) { 
						in.close();
//						}
//						if (out != null) {
						out.close();
//						}
//						if (socket != null) {
						socket.close();
//						}
						break;
					}
					default:
						break;
					}
				} catch (IOException e) {
					System.out.println("에러가 있나?");
					e.printStackTrace();
				}
			}

		}// run

		private void multicast(String msg) {
//			int len = list.size();
//			for (int i = 0; i < len; i++) {
//				ChatClient cc= list.get(i);
//			}
			for (ChatClient cc : list) { // 향상된 포문 for each
				cc.unicast(msg);
			}
		}// end multicast

		private void unicast(String msg) {
			try {
				out.write((msg + "\n").getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}// end unicast

		private void unicastAllData(String msg) {
			try {
				out.write(msg.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}// end ChatClient

	public static void main(String[] args) {
		// 익명객체생성
		new Thread(new ChatServer()).start();

	}
}// end chatServer
