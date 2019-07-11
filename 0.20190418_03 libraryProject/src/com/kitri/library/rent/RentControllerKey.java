package com.kitri.library.rent;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.kitri.library.db.BookDto;
import com.kitri.library.db.MemberDto;

public class RentControllerKey implements KeyListener {

	private Rent rent;

	public RentControllerKey(Rent rent) {
		this.rent = rent;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			String memberId = rent.tf_memId.getText();
			MemberDto memDto = rent.memberDao.select(memberId);
			if(memDto ==null) {
				JOptionPane.showMessageDialog(rent,memberId+"번은 존재하지 않는 회원번호입니다" );
				return;
			}
			String imagePath = memDto.getImage_path();
			rent.lb_tfMemberName.setText(memDto.getMember_name());
			rent.imageFile.setImageToLabel(rent.lb_ImgMember, imagePath);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
