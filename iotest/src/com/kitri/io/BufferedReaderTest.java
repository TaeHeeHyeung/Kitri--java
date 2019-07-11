package com.kitri.io;

import java.io.*;

public class BufferedReaderTest {
	public static void main(String[] args) {
		BufferedReader br;
		BufferedReader fin = null;
		

		FileWriter fw =null;
		
		
		try {
//			InputStream is = System.in;
//			Reader r = new InputStreamReader(is);
//			BufferedReader in = new BufferedReader(r);
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("읽을 파일의 이름: ");
			String infile = br.readLine(); // 개행처리 이전까지 읽는다.
			
			
			System.out.println("복사할 파일의 이름: ");
			String outfile = br.readLine(); // 개행처리 이전까지 읽는다.
			fw= new FileWriter(new File(outfile));
//			System.out.println("파일의 이름 == " + infile);
//			src\\com\\kitri\\io\\FileTest.java
//			bin은 src와 같은 위치에 있기 때문에 src에서 시작해야한다.
			fin = new BufferedReader(new InputStreamReader(new FileInputStream(new File(infile))));
			String str = "";
			while ((str = fin.readLine()) != null) {
				System.out.println(str+"\r\n");
				fw.write(str);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fw != null) {
					fw.close();
				}if(fin != null) {
					fin.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}//end main
}
