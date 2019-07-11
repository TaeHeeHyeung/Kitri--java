package com.kitri.chat.client;

import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.*;

import com.kitri.chat.util.ChatConstance;

public class Login extends JFrame implements ActionListener, Runnable, ListSelectionListener {
	String myid;
	BufferedReader in;
	OutputStream out;
	Socket socket;
	JLabel ip;
	JLabel name;
	JTextField ipTf;
	public JTextField nameTf;
	public JButton cancel;
	public JButton ok;

	Chat chat;
	Paper paper;
	Rename rename;

	public Login() {
		super("Login!!");
		initGUI();

		chat = new Chat();
		paper = new Paper();
		rename = new Rename();

//		Loginâ event ���
		nameTf.addActionListener(this);
		ok.addActionListener(this);
		cancel.addActionListener(this);

// 		Chatâ event ���
		chat.globalsend.addActionListener(this);
		chat.whomsend.addActionListener(this);
		chat.paper.addActionListener(this);
		chat.rename.addActionListener(this);
		chat.exit.addActionListener(this);
		chat.list.addListSelectionListener(this);
		chat.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				closeProcess();
			}
		});

//		Paperâ event ���
		paper.ok.addActionListener(this);
		paper.answer.addActionListener(this);
//		Renameâ event ���
		rename.cancel.addActionListener(this);
		rename.ok.addActionListener(this);
	}

	private void initGUI() {

		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			getContentPane().setBackground(new java.awt.Color(244, 243, 242));
			{
				ip = new JLabel();
				getContentPane().add(ip);
				ip.setText("\uc544\uc774\ud53c");
				ip.setBounds(12, 12, 60, 30);
				ip.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				ip.setFocusable(false);
				ip.setRequestFocusEnabled(false);
				ip.setHorizontalAlignment(SwingConstants.CENTER);

			}
			{
				name = new JLabel();
				getContentPane().add(name);
				name.setText("\ub300\ud654\uba85");
				name.setBounds(12, 47, 60, 30);
				name.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				name.setFocusable(false);
				name.setRequestFocusEnabled(false);
				name.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				ipTf = new JTextField();
				getContentPane().add(ipTf);
				ipTf.setBounds(78, 12, 209, 30);
				ipTf.setText("localhost");
			}
			{
				nameTf = new JTextField();
				getContentPane().add(nameTf);
				nameTf.setBounds(78, 47, 209, 30);
			}
			{
				ok = new JButton();
				getContentPane().add(ok);
				ok.setText("\ub85c\uadf8\uc778");
				ok.setBounds(83, 83, 61, 32);
				ok.setBackground(new java.awt.Color(237, 236, 233));
				ok.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1, false));
			}
			{
				cancel = new JButton();
				getContentPane().add(cancel);
				cancel.setText("\ucde8 \uc18c");
				cancel.setBounds(153, 83, 59, 32);
				cancel.setBackground(new java.awt.Color(237, 236, 233));
				cancel.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1, false));
			}
			pack();
			this.setSize(303, 150);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == nameTf || ob == ok) {
			connectProcess();
		} else if (ob == cancel) {
			System.exit(0);
		} else if (ob == chat.globalsend) {
			globalsendProcess();
		} else if (ob == chat.whomsend) {
			whomSendProcess();
		} else if (ob == chat.paper) {
			viewPapaer();
		} else if (ob == chat.rename) {
			viewRename();
		} else if (ob == chat.exit) {
			closeProcess();
		}
		// paper
		else if (ob == paper.ok) {
			paperProcess();
		} else if (ob == paper.answer) {
			answerProcess();
		} else if (ob == paper.cancel) {
			closePaper();
		}
		// rename
		else if (ob == rename.cancel) {
			closeRename();
		} else if (ob == rename.ok) {
			renameProcess();
		}

	}// end actionPerformed

	private void answerProcess() {
		paper.to.setText(paper.from.getText());
		paper.from.setText(myid);
		paper.letter.append("\n\n---------------[����]\n\n");
		paper.card.show(paper.cardp, "ok");
		paper.letter.setCaretPosition(chat.area.getDocument().getLength());
	}

	private void closeRename() {
		rename.newname.setText("");
		rename.setVisible(false);
	}

	private void viewRename() {
		rename.oldname.setText(myid);
		rename.setVisible(true);
	}

	private void renameProcess() {
		// ��ȭ���� 400|������ ��ȭ��
		// Get number of items in the list
		int size = chat.list.getModel().getSize(); // 4
		// Get all item objects
		for (int i = 0; i < size; i++) {
			String item = chat.list.getModel().getElementAt(i);
			if (item.equals(rename.newname.getText())) {
				JOptionPane.showMessageDialog(this, "�ٸ����̵�� �������ּ���", "���̵𺯰����", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		myid = rename.newname.getText();
		sendMessage(ChatConstance.CS_RENAME + "|" + rename.newname.getText());
	}// end sendRename

	// 1. ��ȿ���˻� ��ȭ��3���̻�.
	// 2. Socket ����.
	// 3. IO(BufferedReader, OutputSream)����
	// 4. loginâ �ݰ� chatâ ����.
	// 5. server�� �޽��� ����. () �������� ���� =>chatConstance
	// 6. Thread ����
	private void connectProcess() {
//		String name = nameTf.getText();
		String ip = ipTf.getText().trim();
		myid = nameTf.getText().trim();
		if (myid.length() < 3) {
			JOptionPane.showMessageDialog(this, "��ȭ���� 3���̻��Դϴ�.", "��ȭ�����", JOptionPane.WARNING_MESSAGE);
			return;
		}
		try {
			socket = new Socket(ip, ChatConstance.PORT);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = socket.getOutputStream();
			this.setVisible(false);
			chat.setVisible(true);
			sendMessage(ChatConstance.SC_CONNECT + "|" + myid); // ���͸� �ݵ�� �������Ѵ�.
			new Thread(this).start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}// connectProcess

	// paper page
	private void paperProcess() {
//		String to = paper.to.getText();
		sendPaper();
		closePaper();
//		paper.card.show(paper.cardp, "ok");
	}

	private void closePaper() {
		paper.to.setText("");
		paper.from.setText("");
		paper.letter.setText("");
		paper.setVisible(false);
	}

	private void sendPaper() {
		sendMessage(
				ChatConstance.CS_PAPER + "|" + paper.to.getText() + "|" + paper.letter.getText().replace("\n", "!@#$"));
		paper.setVisible(false);
	}

	// chat page
	private void viewPapaer() {
//		String to = chat.list.getSelectedValue();
		if (!chat.whom.getText().equals(myid) && !chat.whom.getText().equals("")) {
			paper.to.setText(chat.whom.getText());
			paper.from.setText(myid);
			paper.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(chat, " �ڽ� �� ����ڸ� �����ϼ���.", "����ڿ���", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}

	private void closeProcess() {
		sendMessage(ChatConstance.CS_DISCONNECT + "|");
	}

	// 1. �޼��� get (��ȿ���˻�)
	// 2. ������ �޼��� ����.
	private void globalsendProcess() {
		String msg = chat.globalsend.getText().trim();
		chat.globalsend.setText("");
		if (msg.isEmpty()) {
			return;
		}
		sendMessage(ChatConstance.SC_MESSAGE + "|" + msg);
	}

	private void sendMessage(String msg) {
		try {
			out.write((msg + "\n").getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 1. �����, �޽��� get( ��ȿ���˻� ����� �޽���
	// 2.server�� �޼��� ����
	private void whomSendProcess() {
		String msg = chat.whomsend.getText().trim();
		chat.whomsend.setText("");
		if (msg.isEmpty()) {
			return;
		}
		String to = chat.whom.getText();
		if (to.isEmpty()) {
			JOptionPane.showMessageDialog(chat, "����ڸ� �����ϼ���.", "����ڿ���", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (to.equals(myid)) {
			JOptionPane.showMessageDialog(chat, "�ڽſ��� �ӼӸ���???.", "����ڿ���", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		sendMessage(ChatConstance.CS_TO + "|" + to + "|" + msg);
		viewMessage("��" + to + "��" + msg);
	}// end whomsendProcess

	// utill
	private void viewMessage(String msg) {
		chat.area.append(msg + "\n");
		chat.area.setCaretPosition(chat.area.getDocument().getLength());
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		String selName = chat.list.getSelectedValue();
		chat.whom.setText(selName);
	}

	@Override // �����������޽���
	public void run() {
		boolean flag = true;
		while (flag) {
			try {
				String msg = in.readLine();
				System.out.println("������ ���� �޽���:" + msg); // protocol | �޽�������...
				StringTokenizer st = new StringTokenizer(msg, "|");
				int protocol = Integer.parseInt(st.nextToken());
				switch (protocol) {
				case ChatConstance.SC_CONNECT: {// �����ڵ�
//						100/������ ��ȭ��
					String tmp = st.nextToken();
					viewMessage("[�˸�] " + tmp + "���� �����Ͽ����ϴ�.");
					chat.listData.add(tmp);// jlist�� String���� �۵��ȵȴ�.

					chat.list.setListData(chat.listData);
					break;
				}
				case ChatConstance.SC_MESSAGE: {
//						200/[��ȿ��] �ȳ��ϼ���.
					String tmp = st.nextToken();
					viewMessage(tmp);
					break;
				}
				case ChatConstance.SC_PAPER: {
//					����������(�����ϱ�)			300|������� ��ȭ��| �޽���
					String from = st.nextToken();
					String content = st.nextToken().replace("!@#$", "\n");
					// TODO '\n' ������ �޾����� ����ó�� �ǹ�����.
					paper.to.setText(myid);
					paper.from.setText(from);
					paper.letter.setText(content);// 15
					paper.card.show(paper.cardp, "answer");
					paper.setVisible(true);
					break;
				}
				case ChatConstance.SC_RENAME:
//					��ȭ����			400|������ ��ȭ�� | ������ ��ȭ��
					String oldName = st.nextToken();
					String newName = st.nextToken();

					int len = chat.listData.size();
					chat.listData.set(chat.listData.indexOf(oldName), newName);
					chat.area.append(oldName + "���� " + newName + "���� �̸��� �����Ͽ����ϴ�.\n");
//					for (int i = 0; i < len; i++) {
//						String item = chat.listData.get(i);
//						if (item.equals(oldName)) {
//							item = newName;
//							chat.listData.remove(oldName);
//							chat.listData.add(i, newName);
//							chat.list.setListData(chat.listData);
//							chat.area.append(oldName + "���� " + newName + "���� �̸��� �����Ͽ����ϴ�.\n");
//							break;
//						}
//					} // end for
					
					break;
				case ChatConstance.SC_DISCONNECT: {
//					900|�����»��
					String tmp = st.nextToken();
					if (!tmp.equals(myid)) {
						viewMessage("[�˸�] " + tmp + " ���� ������ �����Ͽ����ϴ�.");
						chat.listData.remove(tmp);
						chat.list.setListData(chat.listData);
					} else {
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
//						chat.setVisible(false);
//						chat = null;
						System.exit(0);

					}
					break;
				}
				default:
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
		try {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Login inst = new Login();
				inst.setLocationRelativeTo(null);
				inst.setResizable(false);
				inst.setVisible(true);
			}
		});
	}
}
