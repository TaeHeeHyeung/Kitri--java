package com.kitri.chat.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.stream.Stream;

import com.kitri.chat.util.ChatConstance;

//�� �� �������� ��ӹ����״� implements�� �Ͽ� �����带 �������
public class ChatServer implements Runnable {
	String myName;

	Vector<ChatClient> list = new Vector<ChatClient>();
	ServerSocket ss;

	public ChatServer() {
		try {
			ss = new ServerSocket(ChatConstance.PORT);
			System.out.println("Ŭ���̾�Ʈ���� �����");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}// end ChatServer

	@Override // ����ó��
	public void run() {
		while (true) {
			try {
				Socket socket = ss.accept();
				System.out.println("Ŭ���̾�Ʈ���� ����::" + socket);
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

		@Override // �޽���ó��
		public void run() {
			boolean flag = true;
			while (flag) {
				try {
					String msg = in.readLine();
					System.out.println("Ŭ���̾�Ʈ�� ���� �޽���:" + msg); // protocol | �޽�������...
					StringTokenizer st = new StringTokenizer(msg, "|");
					int protocol = Integer.parseInt(st.nextToken());
					switch (protocol) {
					case ChatConstance.CS_CONNECT:
//						100|��ȭ��
						name = st.nextToken();
						multicast(ChatConstance.SC_CONNECT + "|" + name);
						list.add(this);
						for (ChatClient cc : list) { // ���� ���� for each
							this.unicast(ChatConstance.SC_CONNECT + "|" + cc.name);
						}
						break;
					case ChatConstance.CS_ALL: {
						// 200|�ȳ��ϼ���.
						String tmp = st.nextToken();
						multicast(ChatConstance.SC_MESSAGE + "|[" + name + "]" + tmp);
						break;
					}
					case ChatConstance.CS_TO: {
						String to = st.nextToken();// ȫ�浿
						String tmp = st.nextToken();// �ȳ�?
						for (ChatClient cc : list) {
							if (cc.name.equals(to)) {
								cc.unicast(ChatConstance.SC_MESSAGE + "|��" + name + "��" + tmp);
								break;
							}
						}
						break;
					}
					case ChatConstance.CS_PAPER: {
//						����������			300|�ӼӸ� �����| �޽���
						String to = st.nextToken();
						System.out.println("to:" + to);
						String content = st.nextToken();
						System.out.println("content : " + content);
						for (ChatClient cc : list) {
							if (cc.name.equals(to)) {
//								System.out.println("������ �޽���: "+ChatConstance.SC_PAPER + "|" + to + "|" + content);
								cc.unicast(ChatConstance.SC_PAPER + "|" + name + "|" + content);
								break;
							}
						}
						break;
					}
					case ChatConstance.CS_RENAME: {
						String oldName = name;
						name = st.nextToken();						
//						��ȭ����			400|������ ��ȭ�� | ������ ��ȭ��
						multicast(ChatConstance.SC_RENAME + "|" + oldName + "|" + name);
						break;
					}
					case ChatConstance.CS_DISCONNECT: {
						multicast(ChatConstance.SC_DISCONNECT + "|" + name);
						list.remove(this);
						flag = false;// switch case�̱� ������ break�� ���������� �׷��� flag ���
//						in out socket �� �ϳ��� null�̸� case���� ���� �� ����.
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
					System.out.println("������ �ֳ�?");
					e.printStackTrace();
				}
			}

		}// run

		private void multicast(String msg) {
//			int len = list.size();
//			for (int i = 0; i < len; i++) {
//				ChatClient cc= list.get(i);
//			}
			for (ChatClient cc : list) { // ���� ���� for each
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
		// �͸�ü����
		new Thread(new ChatServer()).start();

	}
}// end chatServer
