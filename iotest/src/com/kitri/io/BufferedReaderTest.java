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
			System.out.print("���� ������ �̸�: ");
			String infile = br.readLine(); // ����ó�� �������� �д´�.
			
			
			System.out.println("������ ������ �̸�: ");
			String outfile = br.readLine(); // ����ó�� �������� �д´�.
			fw= new FileWriter(new File(outfile));
//			System.out.println("������ �̸� == " + infile);
//			src\\com\\kitri\\io\\FileTest.java
//			bin�� src�� ���� ��ġ�� �ֱ� ������ src���� �����ؾ��Ѵ�.
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
