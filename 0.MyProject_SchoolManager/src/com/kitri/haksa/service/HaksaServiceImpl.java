package com.kitri.haksa.service;

import java.io.*;
import java.util.ArrayList;

import com.kitri.haksa.data.HaksaDto;

public class HaksaServiceImpl implements HaksaService {
	private ArrayList<HaksaDto> list;
	private static final String[] job = { "학번", "과목", "부서" };
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

			System.out.println("========== 메뉴선택 ==========");
			System.out.println("1. 등록");
			System.out.println("2. 찾기");
			System.out.println("3. 삭제");
			System.out.println("4. 전체 출력");
			System.out.println("------------------");
			System.out.println("0. 종료");
			System.out.println("------------------");
			System.out.print("번호를 선택해 주세요..");

			int menu = getInputMenuNum();
			if (menu < 0 || menu > 4) {
				System.out.println("잘못입력하셨습니다 다시 입력해주세요.");
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
					System.out.print("계속 하시려면 1, 종료 하시려면 0을 입력해 주세요. ");
					num = getInputInt();
					if (num == 1) {
						break;
					} else if (num == 0) {
						processExit();
					} else {
						System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
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
			System.out.println("\n========== 메뉴선택 ==========");
			System.out.println("1. 학생");
			System.out.println("2. 교수");
			System.out.println("3. 관리자");
			System.out.println("4. 이전메뉴");
			System.out.print("번호를 선택해 주세요..");
			choiceJobMenu = getInputMenuNum();
			if (choiceJobMenu < 1 || choiceJobMenu > 4) {
				System.out.println("잘못입력하셨습니다 다시 입력해주세요.");
				continue;
			} else if (choiceJobMenu == 4) {
				return;
			} else {
				if (choiceJobMenu == BEFOREMENU) {
					System.out.println("이전 메뉴로 이동합니다.");
					return;
				}
				System.out.print("나 이 :");
				int age = getInputInt();

				if (age == -1) {
					System.out.println("잘못 입력하셨습니다. 이전 메뉴로 이동합니다.");
					return;
				}
				System.out.print("이 름 :");
				String name = getInputTrimString();
				if (choiceJobMenu == STUDENT) {
					System.out.print("학 번 :");
				} else if (choiceJobMenu == PROFESSOR) {
					System.out.print("과 목 :");
				} else if (choiceJobMenu == MANAGER) {
					System.out.print("부 서 :");
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
			System.out.println("등록하지 못하였습니다.");
		}
	}// end register

	@Override
	public void findNameMenu() {
		System.out.println("찾을 이름을 입력해 주세요.");
		System.out.print("이름 :");
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
		System.out.println("삭제할 사람의 이름을 입력해주세요.");
		System.out.print("이름: ");
		String name = getInputTrimString();
		delete(name);
	}// end deleteMenu

	@Override
	public int delete(String name) {
		HaksaDto haksaDto = findName(name);
		if (haksaDto != null) {
			list.remove(haksaDto);
			System.out.println(name + "님을 삭제 하였습니다.");
		} else {
			System.out.println("존재하지 않는 사람입니다.");
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

	// 객체의 정보를 출력
	private void printHaksaDto(HaksaDto haksaDto) {
		if (haksaDto != null) {
			System.out.println("이름 : " + haksaDto.getName() + "\t나이 : " + haksaDto.getAge() + "\t"
					+ job[haksaDto.getKey() - 1] + " : " + haksaDto.getValue());
		} else {
			System.out.println("찾지 못하였습니다.");
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

	// 한글자 이고 0~9
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

	// 양의 정수 true
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
