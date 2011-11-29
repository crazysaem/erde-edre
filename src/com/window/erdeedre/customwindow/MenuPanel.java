package com.window.erdeedre.customwindow;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.TextArea;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel {
	

	
	/**
	 * Create the panel.
	 */
	private JLabel lblNewLabel;
	private JButton btnhallo,btntschau,btnNein,btnBitte,btnfreude,btnaerger,btnbetteln,btnhfive;
	private TextArea textArea;
	private boolean mode=true;
	
	public MenuPanel(int mode) {
		
		setBackground(Color.WHITE);
		setLayout(null);
		
		
		switch (mode) {
		case 0:
			final String vlc_path="C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe";
			final String vid_commands="--play-and-exit --fullscreen";
			
			btnhallo = new JButton("Tsch\u00FCss");
			btnhallo.setBounds(10, 11, 107, 23);
			btnhallo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						@SuppressWarnings("unused")
						Process proc = Runtime
								.getRuntime()
								.exec(vlc_path+" src\\resources\\lifecam\\hallotschau.wmv "+vid_commands);
					} catch (Exception bla) {
						System.out.println("fehler: " + bla);
					}
				}
			});
			add(btnhallo);
	
			btntschau = new JButton("Hallo");
			btntschau.setBounds(122, 11, 108, 23);
			btntschau.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						@SuppressWarnings("unused")
						Process proc = Runtime
								.getRuntime()
								.exec(vlc_path+" src\\resources\\lifecam\\hallotschau.wmv "+vid_commands);
					} catch (Exception bla) {
						System.out.println("fehler: " + bla);
					}
				}
			});
			add(btntschau);
	
			btnNein = new JButton("Zustimmung");
			btnNein.setBounds(10, 39, 107, 23);
			btnNein.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						@SuppressWarnings("unused")
						Process proc = Runtime
								.getRuntime()
								.exec(vlc_path+" src\\resources\\lifecam\\ablehnung.wmv "+vid_commands);
					} catch (Exception bla) {
						System.out.println("fehler: " + bla);
					}
				}
			});
			add(btnNein);
	
			btnBitte = new JButton("Ablehnung");
			btnBitte.setBounds(122, 39, 108, 23);
			btnBitte.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						@SuppressWarnings("unused")
						Process proc = Runtime
								.getRuntime()
								.exec(vlc_path+" src\\resources\\lifecam\\zustimmung.wmv "+vid_commands);
					} catch (Exception bla) {
						System.out.println("fehler: " + bla);
					}
				}
			});
			add(btnBitte);
	
			btnfreude = new JButton("\u00C4rgern");
			btnfreude.setBounds(10, 67, 107, 23);
			btnfreude.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						@SuppressWarnings("unused")
						Process proc = Runtime
								.getRuntime()
								.exec(vlc_path+" src\\resources\\lifecam\\jubel.wmv "+vid_commands);
					} catch (Exception bla) {
						System.out.println("fehler: " + bla);
					}
				}
			});
			add(btnfreude);
	
			btnaerger = new JButton("Freuen");
			btnaerger.setBounds(122, 67, 108, 23);
			btnaerger.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						@SuppressWarnings("unused")
						Process proc = Runtime
								.getRuntime()
								.exec(vlc_path+" src\\resources\\lifecam\\fu.wmv "+vid_commands);
					} catch (Exception bla) {
						System.out.println("fehler: " + bla);
					}
				}
			});
			add(btnaerger);
			
			btnbetteln = new JButton("Betteln");
			btnbetteln.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						@SuppressWarnings("unused")
						Process proc = Runtime
								.getRuntime()
								.exec(vlc_path+" src\\resources\\lifecam\\betteln.wmv "+vid_commands);
					} catch (Exception bla) {
						System.out.println("fehler: " + bla);
					}
				}
			});
			btnbetteln.setBounds(10, 113, 107, 23);
			add(btnbetteln);
			
			btnhfive = new JButton("High Five");
			btnhfive.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						@SuppressWarnings("unused")
						Process proc = Runtime
								.getRuntime()
								.exec(vlc_path+" src\\resources\\lifecam\\high_five.wmv "+vid_commands);
					} catch (Exception bla) {
						System.out.println("fehler: " + bla);
					}
				}
			});
			btnhfive.setBounds(122, 113, 108, 23);
			add(btnhfive);
			
			lblNewLabel = new JLabel("Gnildre Mode");
			lblNewLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					changeLabel();
				}
			});
			lblNewLabel.setBounds(86, 94, 75, 14);
			add(lblNewLabel);
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
	
	private String invert(String a) {

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
	private void changeLabel(){
		if(!this.mode){
			btnhallo.setText("Tschüss");
			btntschau.setText("Hallo");
			btnaerger.setText("Freuen");
			btnfreude.setText("Ärgern");
			btnNein.setText("Zustimmung");
			btnBitte.setText("Ablehnung");
			lblNewLabel.setText("Gnildre Mode");
			mode=true;
		}
		else{
			btnhallo.setText("Hallo");
			btntschau.setText("Tschüss");
			btnaerger.setText("Ärgern");
			btnfreude.setText("Freuen");
			btnNein.setText("Ablehnung");
			btnBitte.setText("Zustimmung");
			lblNewLabel.setText("Erdling Mode");
			mode=false;
		}
	}
}
