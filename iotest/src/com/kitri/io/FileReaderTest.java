package com.kitri.io;

import java.io.*;

public class FileReaderTest {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		File fileIn;
		File fileOut;
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fileIn = new File("E:\\iotest\\hello.txt");
//			FileInputStream fi = new FileInputStream(file);
//			System.out.println(fi.read());
			fr = new FileReader(fileIn);

			long length = fileIn.length();
			char[] cbuf = new char[(int) length];
			int x = fr.read(cbuf);
			System.out.println(x + "characters read!!!");
			String str = new String(cbuf);
			System.out.println(str);

			fileOut = new File("E:\\iotest\\hello_copy2.txt");
			fw = new FileWriter(fileOut);
			fw.write(str);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
				if (fw != null) {
					fw.close();// close를 해줘야 파일에 정상 저장이 된다 이전까지는 메모리만 차지함
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}//end main

}
