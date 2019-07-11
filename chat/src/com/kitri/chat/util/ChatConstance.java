package com.kitri.chat.util;

public class ChatConstance {
	public static final int PORT = 9876;
	// Protocol ����
	// client >> server
//	 ����				100|��ȭ�� 
//	������޽���		200|�޼���
//	Ư������޽���		250|�����|�޼���
//	����������			300|�����|�޼���
//	��ȭ����			400|������ ��ȭ��
//	��������			900| //��ũ�������� �־�� 900�� �� �� �ִ�.
	public static final int CS_CONNECT = 100;
	public static final int CS_ALL = 200;
	public static final int CS_TO = 250;
	public static final int CS_PAPER = 300;
	public static final int CS_RENAME = 400;
	public static final int CS_DISCONNECT = 900;

	// server >> client
//	 ���� 			100|������ ��ȭ��
//	�޽��� 			200|[������� ��ȭ��] �޽���
//	�޽���			200|�ٺ������ ��ȭ��� �޽���
//	����������			300|������� ��ȭ��|line��| �޽��� 
//	��ȭ����			400|������ ��ȭ�� | ������ ��ȭ��
//	��������			900|���������� ��ȭ��
	public static final int SC_CONNECT = 100;
//	public static final int SC_ALL = 200;
//	public static final int SC_TO = 200;
	public static final int SC_MESSAGE = 200;
	public static final int SC_PAPER = 300;
	public static final int SC_RENAME = 400;
	public static final int SC_DISCONNECT = 900;
}
// server >> client
//������޽���		200|[������� ��ȭ��] �޽���
//Ư������޽���		250|�ٺ������ ��ȭ��� �޽���
