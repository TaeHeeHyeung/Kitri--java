package com.kitri.haksa.service;

import java.io.*;
import java.util.ArrayList;

import com.kitri.haksa.data.HaksaDto;

public class HaksaServiceImpl implements HaksaService {
	private ArrayList<HaksaDto> list;
	private static final String[] job = { "�й�", "����", "�μ�" };
	private BufferedReader in;
	private static final int REGIST = 1;
	private static final int FIND = 2;
	private static final int DELETE = 3;
	private static final int PRINT = 4;
	private static final int EXIT = 0;

	private static final int STUDENT = 1;
	private static final int PROFESSOR = 2;
	private static final int MANAGER = 3;
	private static final int BEFOREMENU = 4;

	public HaksaServiceImpl() {
		super();
		list = new ArrayList<HaksaDto>();
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	@Override
	public void menu() {
		while (true) {

			System.out.println("========== �޴����� ==========");
			System.out.println("1. ���");
			System.out.println("2. ã��");
			System.out.println("3. ����");
			System.out.println("4. ��ü ���");
			System.out.println("------------------");
			System.out.println("0. ����");
			System.out.println("------------------");
			System.out.print("��ȣ�� ������ �ּ���..");

			int menu = getInputMenuNum();
			if (menu < 0 || menu > 4) {
				System.out.println("�߸��Է��ϼ̽��ϴ� �ٽ� �Է����ּ���.");
				continue;
			}
			if (menu == REGIST) {
				registerMenu();
			} // if register
			else {
				if (menu == FIND) {
					findNameMenu();
				} else if (menu == DELETE) {
					deleteMenu();
				} else if (menu == PRINT) {
					selectAll();
				} else if (menu == EXIT) {
					processExit();
				}
				int num = -1;
				do {
					System.out.print("��� �Ͻ÷��� 1, ���� �Ͻ÷��� 0�� �Է��� �ּ���. ");
					num = getInputInt();
					if (num == 1) {
						break;
					} else if (num == 0) {
						processExit();
					} else {
						System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
					}
				} while (num != 1 && num != 0);
				System.out.println();
			} // other else

		} // end while
	}// end menu

	@Override
	public void registerMenu() {
		int choiceJobMenu = -1;
		while (true) {
			System.out.println("\n========== �޴����� ==========");
			System.out.println("1. �л�");
			System.out.println("2. ����");
			System.out.println("3. ������");
			System.out.println("4. �����޴�");
			System.out.print("��ȣ�� ������ �ּ���..");
			choiceJobMenu = getInputMenuNum();
			if (choiceJobMenu < 1 || choiceJobMenu > 4) {
				System.out.println("�߸��Է��ϼ̽��ϴ� �ٽ� �Է����ּ���.");
				continue;
			} else if (choiceJobMenu == 4) {
				return;
			} else {
				if (choiceJobMenu == BEFOREMENU) {
					System.out.println("���� �޴��� �̵��մϴ�.");
					return;
				}
				System.out.print("�� �� :");
				int age = getInputInt();

				if (age == -1) {
					System.out.println("�߸� �Է��ϼ̽��ϴ�. ���� �޴��� �̵��մϴ�.");
					return;
				}
				System.out.print("�� �� :");
				String name = getInputTrimString();
				if (choiceJobMenu == STUDENT) {
					System.out.print("�� �� :");
				} else if (choiceJobMenu == PROFESSOR) {
					System.out.print("�� �� :");
				} else if (choiceJobMenu == MANAGER) {
					System.out.print("�� �� :");
				}

				String value = getInputTrimString();
				HaksaDto haksaDto = new HaksaDto(age, name, choiceJobMenu, value);
				register(haksaDto);
			} // end else
			break;
		} // end while
	}// end registerMenu

	@Override
	public void register(HaksaDto haksaDto) {
		if (haksaDto != null) {
			list.add(haksaDto);
		} else {
			System.out.println("������� ���Ͽ����ϴ�.");
		}
	}// end register

	@Override
	public void findNameMenu() {
		System.out.println("ã�� �̸��� �Է��� �ּ���.");
		System.out.print("�̸� :");
		HaksaDto haksaDto = findName(getInputTrimString());
		printHaksaDto(haksaDto);
	}// findNameMenu

	@Override
	public HaksaDto findName(String name) {
		int len = list.size();
		for (int i = 0; i < len; i++) {
			if (list.get(i).getName().equals(name)) {
				return list.get(i);
			}
		} // end for
		return null;
	}// end findName

	@Override
	public void deleteMenu() {
		System.out.println("������ ����� �̸��� �Է����ּ���.");
		System.out.print("�̸�: ");
		String name = getInputTrimString();
		delete(name);
	}// end deleteMenu

	@Override
	public int delete(String name) {
		HaksaDto haksaDto = findName(name);
		if (haksaDto != null) {
			list.remove(haksaDto);
			System.out.println(name + "���� ���� �Ͽ����ϴ�.");
		} else {
			System.out.println("�������� �ʴ� ����Դϴ�.");
		}
		return 0;
	}// end deleteMenu

	@Override
	public void selectAll() {
		int len = list.size();
		for (int i = 0; i < len; i++) {
			printHaksaDto(list.get(i));
		}
	}// end selectAll

	@Override
	public void processExit() {
		System.exit(0);
	}// end processExit

	// ��ü�� ������ ���
	private void printHaksaDto(HaksaDto haksaDto) {
		if (haksaDto != null) {
			System.out.println("�̸� : " + haksaDto.getName() + "\t���� : " + haksaDto.getAge() + "\t"
					+ job[haksaDto.getKey() - 1] + " : " + haksaDto.getValue());
		} else {
			System.out.println("ã�� ���Ͽ����ϴ�.");
		}
	}// end printHaksaDto

	// trimString
	private String getInputTrimString() {
		String str = null;
		try {
			str = in.readLine();
			return str.trim();
		} catch (IOException e) {
			e.printStackTrace();
			return str;
		}
	}// end getInputString

	// �ѱ��� �̰� 0~9
	private int getInputMenuNum() {
		String input = getInputTrimString();
		if (input != null) {
			if (input.length() == 1 && input.toCharArray()[0] - 48 >= 0 && input.toCharArray()[0] - 48 < 10) {
				return Integer.parseInt(input);
			} else {
				return -1;
			}
		}
		return -1;
	}// end getInputMenuNum

	private int getInputInt() {
		String input = getInputTrimString();
		if (input != null && isNumber(input)) {
			int num = Integer.parseInt(input);
			return num;
		} else {
			return -1;
		}

	}// end getInputInt

	// ���� ���� true
	private boolean isNumber(String str) {
		int len = str.length();
		for (int i = 0; i < len; i++) {
			int num = str.charAt(i) - 48;
			if (num < 0 || num > 9) {
				return false;
			}
		} // end for
		return true;
	}// end isNumber

}
