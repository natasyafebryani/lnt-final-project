package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.MenuDAO;

public class View extends JFrame implements ActionListener {
	
	JLabel viewTitleLabel = new JLabel("View");
	JTable menuTable;
	DefaultTableModel model;
	JScrollPane tableScrollPane;
	JButton backBtn = new JButton("Back");
	
	Font titleFont = new Font("Montserrat", Font.BOLD, 36);
	Font bodyFont = new Font("Montserrat", Font.BOLD, 18);
	
	private MenuDAO dao;
	
	Vector<String> tableTitle = new Vector<>();
	
	public View() {
		dao = new MenuDAO();
		createViewFrame();
	}
	
	private void createViewFrame() {

		setTitle("BobaCool - View");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setLayout(new BorderLayout());
		
		initTitleLabel();
		initTable();
		initButton();

		setVisible(true);
	}
	
	private void initTitleLabel() {
		viewTitleLabel.setHorizontalAlignment(JLabel.CENTER);
		viewTitleLabel.setVerticalAlignment(JLabel.TOP);
		viewTitleLabel.setOpaque(true);
		
		viewTitleLabel.setFont(titleFont);
		
		add(viewTitleLabel, BorderLayout.NORTH);		
	}
	
	private void initTable() {
		
		tableTitle = new Vector<String>();
		tableTitle.add("Kode Menu");
		tableTitle.add("Nama Menu");
		tableTitle.add("Harga Menu");
		tableTitle.add("Stok Menu");
		
		DefaultTableModel model = new DefaultTableModel(dao.getMenu(), tableTitle) {

			   @Override
			   public boolean isCellEditable(int row, int column) {
			    return false;
			   }
			   
		};
		
		menuTable = new JTable(model);
			
		tableScrollPane = new JScrollPane(menuTable);
		add(tableScrollPane);
	}
	
	private void initButton() {
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(1,1));
		
		backBtn.addActionListener(this);
		
		backBtn.setFont(bodyFont);
		
		btnPanel.add(backBtn);
		
		add(btnPanel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(backBtn)) {
			new Home();
			setVisible(false);
		} 
		
	}


}
