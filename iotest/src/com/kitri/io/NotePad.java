package com.kitri.io;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class NotePad extends JFrame implements ActionListener {

	private JPanel contentPane;
	public JMenuItem menuItem_open;
	public JMenuItem menuItem_save;
	public JMenuItem menuItem_exit;
	FileDialog fileDialog;
	File[] fileInArr;
	File[] fileOutArr;
	File fileOut;
	private JTextArea textArea_context;
	JMenu menu;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotePad frame = new NotePad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NotePad() {
		fileDialog = new FileDialog(new NotePad_FileDialog());
		// FileChoser -> setDialogType ->showopendialog showsaveDialog ->
		// showOpenDialog(this)
		// File.separater ±¸ºÐÀÚ / \ 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu_file = new JMenu("\uD30C\uC77C");
		menuBar.add(menu_file);

		menuItem_open = new JMenuItem("\uC5F4\uAE30");
		menu_file.add(menuItem_open);

		menuItem_save = new JMenuItem("\uC800\uC7A5");
		menu_file.add(menuItem_save);

		menuItem_exit = new JMenuItem("\uC885\uB8CC");
		menu_file.add(menuItem_exit);

		menu = new JMenu("\uB3C4\uC6C0\uB9D0");
		menuBar.add(menu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 410, 221);
		contentPane.add(scrollPane);

		textArea_context = new JTextArea();
		scrollPane.setViewportView(textArea_context);

		menuItem_open.addActionListener(this);
		menuItem_save.addActionListener(this);
		menuItem_exit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuItem_open) {
			fileDialog.setMode(FileDialog.LOAD);
			fileDialog.setVisible(true);
			fileDialog.setMultipleMode(true);
			fileDialog.setDirectory("\\.");
			fileInArr = fileDialog.getFiles();

//			System.out.println(file.length);
			int len = fileInArr.length;
			for (int i = 0; i < len; i++) {
//				System.out.println(file[i].getPath() + " " + file[i].getName());
				String fileStr = fileInArr[i].getPath();
				readFile(fileStr);
			}
		} else if (e.getSource() == menuItem_save) {
			fileDialog.setMode(FileDialog.SAVE);
			fileDialog.setVisible(true);
			fileDialog.setMultipleMode(false);
			
			String fileStr = fileDialog.getDirectory();
			fileStr += fileDialog.getFile();
			
			saveFile(fileStr, textArea_context.getText());
//			fileOutArr= fileDialog.getFiles();
//			int len = fileOutArr.length;
//			for (int i = 0; i < len; i++) {
//				String fileStr = fileOutArr[i].getPath();
//				System.out.println(fileStr);
//			}

		} else if (e.getSource() == menuItem_exit) {
			System.exit(0);
		}
	}

	public void readFile(String pathStr) {
		File fin = new File(pathStr);
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fin)));
			String line = null;
			StringBuffer sbuf = new StringBuffer();
			while ((line = br.readLine()) != null) {
				sbuf.append(line + "\n");
			}
			textArea_context.setText(sbuf.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// end readFile

	public void saveFile(String pathStr, String context) {
		File fout;
		FileWriter fw = null;
		try {
			fout = new File(pathStr);
			fw = new FileWriter(fout);
			context.replace("\n", "\r\n");
			fw.write(context);
//			String[] strArr = context.split("\n");
//			int len = strArr.length;
//			for (int i = 0; i < len; i++) {
//				fw.write(strArr[i] + "\r\n");
//			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} // end finally
	}// end saveFile
}
