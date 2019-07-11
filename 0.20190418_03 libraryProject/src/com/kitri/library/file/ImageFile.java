package com.kitri.library.file;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.kitri.library.db.*;

public class ImageFile {

	public static final int MODE_BOOK = 0;
	public static final int MODE_MEMBER = 1;

	public FileDialog fileDialog;
	public BufferedImage bi;
	public final String FILE_DILI = File.separator;
	private final String SAVE_BOOK_IMAGE_PATH = "./src/bookImage/";
	private final String SAVE_MEMBER_IMAGE_PATH = "./src/memberImage/";
	public File fileOut;

	// 책 이미지 경로
	private String readImageName = "";
	private String readImagePath = "";
	public String readImagePathName = "";
	public String saveImagePathName = "";

	// 이미지 경로
	// private String readMemImageFileName = "";
	// private String readMemImageFilePath = "";
	// public String readMemImageFilePathName = "";
	// private String saveMemImageFilePath = "";
	// public final String SAVE_MEMBER_IMAGE_PATH = "./src/memberImage/";

	public ImageFile() {
		fileDialog = new FileDialog(new frameTest());
	}

	public void close() {
		readImageName = "";
		saveImagePathName = "";
		bi= null;
	}

	public void setBufferedImage(String path) {
		File file = new File(path);
		try {
			bi = ImageIO.read(file);
			System.out.println("ImageFile.setBufferImage 이미지 로드 성공");
		} catch (IOException e) {
			System.out.println("ImageFile.setBufferedImage 이미지 로드 실패");
			bi = null;
			// e.printStackTrace();
		}
	}

	public void setImageToLabel(JLabel lbImg, String filePath) {
		BufferedImage bufferedImage = null;
		if (filePath != null) {
			try {
				File file = new File(filePath);
				bufferedImage = ImageIO.read(file);
			} catch (IOException e) {
				// e.printStackTrace();
				lbImg.setIcon(null);
				System.out.println("ImageFile.setImageToLabel 데이터베이스 경로에 이미지가 없습니다. ");
				return;
			}
			Image resizeImage = bufferedImage.getScaledInstance(lbImg.getWidth(), lbImg.getHeight(),
					BufferedImage.SCALE_FAST);
			ImageIcon icon = new ImageIcon(resizeImage);
			lbImg.setIcon(icon);
		}
	}

	public void saveImage(int mode) {
		// 파일 존재하지 않으면 생성
		File file = null;
		if (mode == MODE_BOOK) {
			file = new File(SAVE_BOOK_IMAGE_PATH);
		} else if (mode == MODE_MEMBER) {
			file = new File(SAVE_MEMBER_IMAGE_PATH);
		}
		if (!file.exists()) {
			file.mkdir();
		}
		try {
			readImageName = System.currentTimeMillis() + readImageName;
			fileOut = new File(file.getAbsoluteFile() + FILE_DILI + readImageName);
			ImageIO.write(bi, "png", fileOut);

			if (mode == MODE_BOOK) {
				saveImagePathName = SAVE_BOOK_IMAGE_PATH + readImageName;
			} else if (mode == MODE_MEMBER) {
				saveImagePathName = SAVE_MEMBER_IMAGE_PATH + readImageName;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// end readImage

	public void setLabelImg_OfLoadImg(JLabel lbImg) {
		setBufferedImage(readImagePath + File.separator + readImageName);
		setImageToLabel(lbImg, readImagePath + File.separator + readImageName);
	}

	public void viewLoadFile() {
		fileDialog.setMode(FileDialog.LOAD);
		fileDialog.setDirectory("/.");
		fileDialog.setVisible(true);
		readImagePath = fileDialog.getDirectory();
		readImageName = fileDialog.getFile();
		readImagePathName = readImagePath + File.separator + readImageName;
	}



	private class frameTest extends JFrame {
		private JPanel contentPane;

		private frameTest() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
		}
	}// InerClass

}
