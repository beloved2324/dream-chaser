package com.woniuxy.tank.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameOverPanel extends JPanel{

	private GameFrame frame;

	public GameOverPanel(final GameFrame frame) {
		this.frame = frame;
		this.setLayout(null);
		this.setBackground(Color.RED);
		this.setFocusable(true);
		this.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("--------------");
				frame.remove(GameOverPanel.this);
				frame.add(new GamePanel(frame));
				frame.validate();
			}
		});
		
		this.init();
	}
	private void init() {
		
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
}
