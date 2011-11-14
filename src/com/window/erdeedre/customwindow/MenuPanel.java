package com.window.erdeedre.customwindow;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.TextArea;

public class MenuPanel extends JPanel {
	

	
	/**
	 * Create the panel.
	 */

	private TextArea textArea;
	public MenuPanel(int mode) {
		
		setBackground(Color.WHITE);
		setLayout(null);
		
		
		switch (mode) {
		case 0:
			final String vlc_path="C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe";
					
			JButton btnhallo = new JButton("Hallo");
			btnhallo.setBounds(10, 11, 107, 23);
			btnhallo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						Process proc = Runtime
								.getRuntime()
								.exec(vlc_path+" src\\resources\\lifecam\\hallotschau.wmv --play-and-exit");
					} catch (Exception bla) {
						System.out.println("fehler: " + bla);
					}
				}
			});
			add(btnhallo);
	
			JButton btntschau = new JButton("Tsch\u00FCss");
			btntschau.setBounds(122, 11, 108, 23);
			btntschau.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						Process proc = Runtime
								.getRuntime()
								.exec(vlc_path+" src\\resources\\lifecam\\hallotschau.wmv --play-and-exit");
					} catch (Exception bla) {
						System.out.println("fehler: " + bla);
					}
				}
			});
			add(btntschau);
	
			JButton btnNein = new JButton("Ablehnung");
			btnNein.setBounds(10, 39, 107, 23);
			btnNein.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						Process proc = Runtime
								.getRuntime()
								.exec(vlc_path+" src\\resources\\lifecam\\ablehnung.wmv --play-and-exit");
					} catch (Exception bla) {
						System.out.println("fehler: " + bla);
					}
				}
			});
			add(btnNein);
	
			JButton btnBitte = new JButton("Zustimmung");
			btnBitte.setBounds(122, 39, 108, 23);
			btnBitte.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						Process proc = Runtime
								.getRuntime()
								.exec(vlc_path+" src\\resources\\lifecam\\zustimmung.wmv --play-and-exit");
					} catch (Exception bla) {
						System.out.println("fehler: " + bla);
					}
				}
			});
			add(btnBitte);
	
			JButton btnfreude = new JButton("Freuen");
			btnfreude.setBounds(10, 67, 107, 23);
			btnfreude.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						Process proc = Runtime
								.getRuntime()
								.exec(vlc_path+" src\\resources\\lifecam\\jubel.wmv --play-and-exit");
					} catch (Exception bla) {
						System.out.println("fehler: " + bla);
					}
				}
			});
			add(btnfreude);
	
			JButton btnaerger = new JButton("\u00C4rgern");
			btnaerger.setBounds(122, 67, 108, 23);
			btnaerger.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						Process proc = Runtime
								.getRuntime()
								.exec(vlc_path+" src\\resources\\lifecam\\fu.wmv --play-and-exit");
					} catch (Exception bla) {
						System.out.println("fehler: " + bla);
					}
				}
			});
			add(btnaerger);
			
			JButton btnbetteln = new JButton("Betteln");
			btnbetteln.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						Process proc = Runtime
								.getRuntime()
								.exec(vlc_path+" src\\resources\\lifecam\\betteln.wmv --play-and-exit");
					} catch (Exception bla) {
						System.out.println("fehler: " + bla);
					}
				}
			});
			btnbetteln.setBounds(10, 113, 107, 23);
			add(btnbetteln);
			
			JButton btnhfive = new JButton("High Five");
			btnhfive.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						Process proc = Runtime
								.getRuntime()
								.exec(vlc_path+" src\\resources\\lifecam\\high_five.wmv --play-and-exit");
					} catch (Exception bla) {
						System.out.println("fehler: " + bla);
					}
				}
			});
			btnhfive.setBounds(122, 113, 108, 23);
			add(btnhfive);
			break;
		case 1:
			textArea = new TextArea();
			textArea.setBounds(10, 0, 220, 105);
			add(textArea);
			
			JButton btnToText = new JButton("to Text");
			btnToText.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					textArea.setText(invert(textArea.getText()));
				}
			});
			btnToText.setBounds(20, 106, 89, 23);
			add(btnToText);
			
			JButton btnToSpeech = new JButton("to Speech");
			btnToSpeech.setBounds(129, 106, 89, 23);
			add(btnToSpeech);
			break;
		default:
			break;
		}
	}
	
	public static String invert(String a) {

		String reversedString = "";

		if (a.length() > 100000)
			return "Error: String too long!";
		else {

			while (a.length() > 0) {
				reversedString = reversedString + a.substring(a.length() - 1);
				a = a.substring(0, a.length() - 1);
			}
		}

		return reversedString;
	}
}
