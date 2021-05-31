package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.MenuDAO;
import model.Menu;

public class Insert extends JFrame implements ActionListener {
	
	JLabel insertTitleLabel = new JLabel("Insert");
	
	JLabel kodeLabel = new JLabel("Kode Menu");
	JTextField kodeTextField = new JTextField(generateNewCode());
	
	JLabel namaLabel = new JLabel("Nama Menu");
	JTextField namaTextField = new JTextField();
	
	JLabel hargaLabel = new JLabel("Harga Menu");
	JTextField hargaTextField = new JTextField();
	
	JLabel stokLabel = new JLabel("Stok Menu");
	JTextField stokTextField  = new JTextField();
	
	
	JButton inserMenuBtn = new JButton("Insert");
	JButton cancelBtn = new JButton("Cancel");
	
	private MenuDAO dao;

	Font titleFont = new Font("Montserrat", Font.BOLD, 36);
	Font bodyFont = new Font("Montserrat", Font.BOLD, 18);
	
	public Insert() {
		createInsertFrame();
	}
	
	private void createInsertFrame() {

		setTitle("BobaCool - Insert");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setLayout(new BorderLayout());
		
		initTitleLabel();
		form();
		initButton();

		setVisible(true);
	}
	
	private void initTitleLabel() {
		insertTitleLabel.setHorizontalAlignment(JLabel.CENTER);
		insertTitleLabel.setVerticalAlignment(JLabel.TOP);
		insertTitleLabel.setOpaque(true);
		
		insertTitleLabel.setFont(titleFont);
		
		add(insertTitleLabel, BorderLayout.NORTH);		
	}
	
	private void form() {
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(4,1));
		
		JPanel insertKodePanel = new JPanel();
		insertKodePanel.setLayout(new GridLayout(1,2));
		insertKodePanel.add(kodeLabel);
		insertKodePanel.add(kodeTextField);
		
		JPanel insertNamaMenuPanel = new JPanel();
		insertNamaMenuPanel.setLayout(new GridLayout(1,2));
		insertNamaMenuPanel.add(namaLabel);
		insertNamaMenuPanel.add(namaTextField);
		
		JPanel insertHargaMenuPanel = new JPanel();
		insertHargaMenuPanel.setLayout(new GridLayout(1,2));
		insertHargaMenuPanel.add(hargaLabel);
		insertHargaMenuPanel.add(hargaTextField);
		
		JPanel insertStokMenuPanel = new JPanel();
		insertStokMenuPanel.setLayout(new GridLayout(1,2));
		insertStokMenuPanel.add(stokLabel);
		insertStokMenuPanel.add(stokTextField);
		
		kodeLabel.setFont(bodyFont);
		namaLabel.setFont(bodyFont);
		hargaLabel.setFont(bodyFont);
		stokLabel.setFont(bodyFont);
		
		formPanel.add(insertKodePanel);
		formPanel.add(insertNamaMenuPanel);
		formPanel.add(insertHargaMenuPanel);
		formPanel.add(insertStokMenuPanel);
		
		add(formPanel, BorderLayout.CENTER);
	}
	
	private void initButton() {
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(1,1));
		
		kodeTextField.setEditable(false);
		
		inserMenuBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		
		buttonsPanel.add(cancelBtn);
		buttonsPanel.add(inserMenuBtn);
		
		inserMenuBtn.setFont(bodyFont);
		cancelBtn.setFont(bodyFont);
		
		add(buttonsPanel, BorderLayout.SOUTH);
	}
	
	public String generateNewCode() {
		
		Random rand = new Random();
		
		String kode = "BC-";
		
		for (int i = 0; i < 3; i++) {
			kode += rand.nextInt(9);
		}
		
		return kode;
	}
	
	public Menu getNewMenu() {
		
		boolean valid = true;
		
		String kodeMenu = kodeTextField.getText();
		
		String namaMenu = namaTextField.getText();
		if(namaMenu.isEmpty()) {
			valid = false;
		}
		
		String strHargaMenu = hargaTextField.getText();
		int hargaMenu = 0;
		if(strHargaMenu.isEmpty()) {
			valid = false;
		} else {
			hargaMenu = Integer.parseInt(strHargaMenu);
		}
		
		String strStokMenu = stokTextField.getText();
		int stokMenu = 0;
		if(strStokMenu.isEmpty()) {
			valid = false;
		} else {
			stokMenu = Integer.parseInt(strStokMenu);
		}
		
		if(valid) {
			return new Menu(kodeMenu, namaMenu, hargaMenu, stokMenu);
		} else {
			return null;
		}
	
	}
	
	public void setDataForm(Menu menu) {
		
		clearForm();
		
		kodeTextField.setText(menu.getKode());
		
		namaTextField.setText(menu.getNama());
		
		String strHarga = String.valueOf(menu.getHarga());
		hargaTextField.setText(strHarga);
		
		String strStok = String.valueOf(menu.getStok());
		stokTextField.setText(strStok);
		
	}
	
	public void clearForm() {
		kodeTextField.setText("");
		namaTextField.setText("");
		hargaTextField.setText("");
		stokTextField.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(cancelBtn)) {
			new Home();
			setVisible(false);
		} else if(e.getSource().equals(inserMenuBtn)) {

			Menu menu = getNewMenu();
			
			if (menu == null) {
				JOptionPane.showMessageDialog(null, "Please fill all the field!");
			} else {
				dao.insert(menu);
				JOptionPane.showMessageDialog(null, "Insert success!");
				clearForm();	
			}
		}
	}

}
