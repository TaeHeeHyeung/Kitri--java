package com.kitri.test.file;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class ImageFileTest {
	final String FILE_DILI = File.separator;
	final String SAVE_FILE_PATH = "src/fileImage/";
	final String READ_FILE_NAME = "제목 없음.png";
	final String WRITE_FILE_NAME = "제목 없음.png";
//	JFileChooser fileChooser;
	private File fileIn;
	private File fileOut;
	String readFilePath;

	BufferedImage bi = null;

	Vector<String> filePathLists;

	public ImageFileTest() {
//		fileChooser = new JFileChooser();
//		fileChooser.setMultiSelectionEnabled(false);
		filePathLists = new Vector<String>();
	}

	public void saveImage() {
		// 파일 존재하지 않으면 생성
		File file = new File("./" + SAVE_FILE_PATH);
		if (!file.exists()) {
			System.out.println("파일생성: " + file.getAbsolutePath());
			file.mkdir();
		}
		try {
			fileIn = new File("/" + "Users" + FILE_DILI + "teahee" + FILE_DILI + "Desktop" + FILE_DILI + "readPath"
					+ FILE_DILI + READ_FILE_NAME);
			// System.out.println(fileIn.getAbsolutePath());
			bi = ImageIO.read(fileIn);
			fileOut = new File(file.getAbsoluteFile() + FILE_DILI + WRITE_FILE_NAME);
			// System.out.println("파일출력: " + fileOut.getAbsolutePath());
			ImageIO.write(bi, "png", fileOut);
			filePathLists.add(fileOut.getAbsolutePath());
		} catch (IOException e) {

			e.printStackTrace();
		}
	}// end readImage

	private void readImage() {
		File file = new File(filePathLists.get(0));
		try {
			bi = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ImageFileTest imageFileTest = new ImageFileTest();
		imageFileTest.saveImage();
		imageFileTest.readImage();
	}

}
// 현재 프로젝트 경로
// fileOut= new File("./");
// 프로젝트 경로 출력하기
// System.out.println(fileOut.getAbsolutePath());