package com.woniuxy.tank.ui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
/**
 * 
 * @author PageJ
 * @version 1.0
 */
public class GameFrame extends JFrame{
	private final int WIDTH = 990;
	private final int HEIGHT = 712;
	public GameFrame(){
		this.init();
	}
	
	private void init(){

		this.setLayout(new CardLayout());
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		try {
			this.setIconImage(ImageIO.read(new File("images/flag.bmp")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setTitle("Tank");
		this.setBounds((int)(d.getWidth()-WIDTH)/2, (int)(d.getHeight()-HEIGHT)/2, WIDTH, HEIGHT);
		this.add(new GamePanel(this));
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
