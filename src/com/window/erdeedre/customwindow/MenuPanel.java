package com.window.erdeedre.customwindow;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MenuPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JButton btnNewButton = new JButton("=(");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 11, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("=)");
		btnNewButton_1.setBounds(109, 11, 89, 23);
		add(btnNewButton_1);
		
		JButton button = new JButton("-.-");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		button.setBounds(10, 45, 89, 23);
		add(button);
		
		JButton button_1 = new JButton("^.^");
		button_1.setBounds(109, 45, 89, 23);
		add(button_1);
	
	}
}
