package com.kitri.io;

import java.io.*;

public class FileTest {

	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;
		try {
			File inFile = new File("e:\\iotest\\hello.txt");
			in = new FileInputStream(inFile);
			long length = inFile.length();
			byte b[] = new byte[(int) length];
			int x = in.read(b);//개행처리까지 byte로 읽어온다.
			System.out.println(x + "byte read!!!");
			String str = new String(b, 0, x);
			System.out.print(str);

			File outFile = new File("e:\\iotest\\hello_copy.txt");
			out = new FileOutputStream(outFile);
			out.write(b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();//연결을 하면 끊어라
				}
				if (out != null) {
					out.close();//연결을 하면 끊어라
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}// end main

}// end class FileTest
