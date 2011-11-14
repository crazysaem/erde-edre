package com.window.erdeedre.customwindow;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {

	
	/**
	 * Create the panel.
	 */
	public MenuPanel() {
		final String vlc_path="C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe";
		
		setBackground(Color.WHITE);

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
		btnhallo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		setLayout(null);
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
		btnNein.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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

	}
}
