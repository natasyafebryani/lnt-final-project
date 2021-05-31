package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import model.Menu;

public class Update extends JFrame implements ActionListener, MouseListener {
	
	JLabel updateTitleLabel = new JLabel("Update");
	DefaultTableModel model;
	JTable menuTable;
	JScrollPane tableScrollPane;
	
	JButton cancelBtn = new JButton("Cancel");
	JButton updateBtn = new JButton("Update");
	
	Font titleFont = new Font("Montserrat", Font.BOLD, 36);
	Font bodyFont = new Font("Montserrat", Font.BOLD, 18);
	
	MenuDAO dao;
	
	Menu menu;
	
	Vector<String> tableTitle;
	
	public Update() {
		createUpdateFrame();
	}
	
	private void createUpdateFrame() {

		setTitle("BobaCool - Update");
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
		updateTitleLabel.setHorizontalAlignment(JLabel.CENTER);
		updateTitleLabel.setVerticalAlignment(JLabel.TOP);
		updateTitleLabel.setOpaque(true);
		
		updateTitleLabel.setFont(titleFont);
		
		add(updateTitleLabel, BorderLayout.NORTH);		
	}
	
	private void initTable() {
		MenuDAO dao = new MenuDAO();
		tableTitle = new Vector<String>();
		
		tableTitle = new Vector<String>();
		tableTitle.add("Kode Menu");
		tableTitle.add("Nama Menu");
		tableTitle.add("Harga Menu");
		tableTitle.add("Stok Menu");
		

		DefaultTableModel model = new DefaultTableModel(dao.getMenu(), tableTitle) {

			   @Override
			   public boolean isCellEditable(int row, int column) {
			    return true;
			   }
			   
		};
			
		menuTable = new JTable(model);
		menuTable.addMouseListener(this);
			
		tableScrollPane = new JScrollPane(menuTable);
		add(tableScrollPane);
	}
	
	private void initButton() {
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(1,1));
		
		cancelBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		
		cancelBtn.setFont(bodyFont);
		updateBtn.setFont(bodyFont);
		
		btnPanel.add(cancelBtn);
		btnPanel.add(updateBtn);
		
		add(btnPanel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(cancelBtn)) {
			new Home();
			setVisible(false);
		} else if (e.getSource().equals(updateBtn)) {
			
			int row = menuTable.getSelectedRow();
			
			if(row >= 0) {
				String kode = menuTable.getValueAt(row, 0).toString();
				dao.update(menu);
				
				JOptionPane.showMessageDialog(null, "Success to update record!");
				
				model.setDataVector(dao.getMenu(), tableTitle);
			}
			
			
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		int row = menuTable.rowAtPoint(e.getPoint());
		
		if (row < 0 || row > menuTable.getRowCount()) {
			menuTable.clearSelection();
		} else {
			menuTable.setRowSelectionInterval(row, row);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
