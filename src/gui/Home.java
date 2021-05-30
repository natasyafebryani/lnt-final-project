package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends JFrame implements ActionListener {
	
	JLabel bobaCoolLabel = new JLabel("BobaCool"); 
	
	JButton insertBtn = new JButton("Insert");
	JButton viewBtn = new JButton("View");
	JButton updateBtn = new JButton("Update");
	JButton deleteBtn = new JButton("Delete");
	
	Font titleFont = new Font("Montserrat", Font.BOLD, 56);
	Font btnFont = new Font("Montserrat", Font.PLAIN, 24);

	public Home() {
		createHomeFrame();
	}
	
	private void createHomeFrame() {
		
		setTitle("BobaCool - Home");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setLayout(new BorderLayout());
		
		initLabel();
		
		initMenuButtons();
		
		setVisible(true);
	}
	
	private void initLabel() {
		bobaCoolLabel.setHorizontalAlignment(JLabel.CENTER);
		bobaCoolLabel.setVerticalAlignment(JLabel.TOP);
		bobaCoolLabel.setOpaque(true);
		
		bobaCoolLabel.setFont(titleFont);
		
		add(bobaCoolLabel, BorderLayout.NORTH);		
	}
	
	private void initMenuButtons() {
		JPanel menuBtnPanel = new JPanel();
		menuBtnPanel.setLayout(new GridLayout(2,1));

		insertBtn.setFont(btnFont);
		viewBtn.setFont(btnFont);
		updateBtn.setFont(btnFont);
		deleteBtn.setFont(btnFont);
		
		insertBtn.addActionListener(this);
		viewBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		
		menuBtnPanel.add(insertBtn);
		menuBtnPanel.add(viewBtn);
		menuBtnPanel.add(updateBtn);
		menuBtnPanel.add(deleteBtn);
		
		add(menuBtnPanel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(insertBtn)) {
			new Insert();
			setVisible(false);
		} else if(e.getSource().equals(viewBtn)) {
			new View();
			setVisible(false);
		} else if(e.getSource().equals(updateBtn)) {
			new Update();
			setVisible(false);
		} else if(e.getSource().equals(deleteBtn)) {
			new Delete();
			setVisible(false);
		}
		
	}
	

}
