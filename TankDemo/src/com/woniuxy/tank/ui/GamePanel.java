package com.woniuxy.tank.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.woniuxy.tank.bullet.Bullet;
import com.woniuxy.tank.character.Player;
import com.woniuxy.tank.character.enemy.EnemyTank;
import com.woniuxy.tank.map.GameMap;

public class GamePanel extends JPanel implements Runnable{
	GameFrame frame;
	
	private Image map_src;
	private Image player_img;
	private Image enemy_img;
	private Image start_img;
	private Image bullet_img;
	private Image gameOver_img;
	
	public static int[][] currentMap = new GameMap().map_01;
	
	public static Player player = new Player(10, 19);
	
	public static Vector<EnemyTank> tanks = new Vector<EnemyTank>();
	public static Vector<Bullet> bullets = new Vector<Bullet>();
	
	private int tankCount;
	private boolean isOver = false;//true for Game Over
	private boolean isRun = true;//true for still repainting gamePanel
	
	public GamePanel(GameFrame frame){
		this.frame = frame;
		this.init();
	}
	private void init() {
		this.add(new JLabel());
		this.setLayout(null);
		this.setBackground(Color.black);
		
		try {
			map_src = ImageIO.read(new File("images/tile.bmp"));
			player_img = ImageIO.read(new File("images/player1.bmp"));
			enemy_img = ImageIO.read(new File("images/enemy.bmp"));
			start_img = ImageIO.read(new File("images/bore.bmp"));
			bullet_img = ImageIO.read(new File("images/bullet.bmp"));
			gameOver_img = ImageIO.read(new File("images/gameover.bmp"));
			
			MediaTracker mt = new MediaTracker(this);
			mt.addImage(map_src, 1);
			mt.addImage(player_img, 2);
			mt.addImage(enemy_img, 3);
			mt.addImage(bullet_img, 4);
			
			mt.waitForAll();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		this.setFocusable(true);
//        this.requestFocus();
//        this.requestFocusInWindow(true);
        this.setFocusable(true);
        this.requestFocus();
        
//		this.setFocusable(true);
//		this.requestFocusInWindow();
		this.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				player.action(e,currentMap);
			}
		});
		new Thread(this).start();
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.drawMap(g);
		this.drawPlayer(g);
		this.drawTanks(g);
		this.drawPlayerBullets(g);
		this.checkGameStatus(g);
		
	}
	private void drawPlayerBullets(Graphics g) {
		for(int i = 0;i<bullets.size();i++){
			bullets.get(i).draw(g, this, bullet_img, currentMap);
		}
	}
	private void drawTanks(Graphics g) {
		for(int i = 0;i<tanks.size();i++){
			tanks.get(i).drawTank(g, this, map_src, enemy_img, start_img);
		}
	}
	private void drawPlayer(Graphics g) {
		player.draw(g, this, map_src, player_img);
	}
	private void clearMap(){
		for(int i = 0;i<bullets.size();i++){
			bullets.get(i).drawBullet = false;
		}
		for(int i = 0;i<tanks.size();i++){
			tanks.get(i).isDrawTank = false;
		}
	}
	private void gameOver(){
		player = new Player(10, 19);
		clearMap();
		frame.remove(this);
		GameOverPanel gameOverPanel = new GameOverPanel(frame);
		frame.add(gameOverPanel);
		frame.validate();
	}
	private void drawMap(Graphics g) {
		for(int i = 0;i < currentMap.length;i++){
			for(int j = 0; j < currentMap[0].length;j++){
				switch (currentMap[i][j]) {
				case 0:
					break;
				case 1:
				case 5:
				case 6:
					//绘制钢板
					g.drawImage(map_src, j<<5, i<<5, (j+1)<<5, (i+1)<<5, 32, 0, 64, 32, this);
					break;
				case 3:
					//绘制砖墙
					g.drawImage(map_src, j<<5, i<<5, (j+1)<<5, (i+1)<<5, 0, 0, 32, 32, this);
					break;
				case 2:
					//绘制树
					g.drawImage(map_src, j<<5, i<<5, (j+1)<<5, (i+1)<<5, 64, 0, 96, 32, this);
					break;
				case 4:
					//水
					g.drawImage(map_src, j<<5, i<<5, (j+1)<<5, (i+1)<<5, 96, 0, 128, 32, this);
					break;
				case 8:
					//boss
					g.drawImage(map_src, j<<5, i<<5, (j+1)<<5, (i+1)<<5, 160, 0, 192, 32, this);
					break;
				default:
					break;
				}
			}
		}
	}
	private void checkGameStatus(Graphics g){
//		System.out.println(player.getTankHP());
		if(player.getTankHP() <= 0){
			this.isOver = true;
			this.isRun = false;
		}
	}
	@Override
	public void run() {
		while(isRun){
			this.repaint();
			this.creatEnemy();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("PANEL DIE");
//		this.setVisible(false);
		gameOver();
	}
	private int position;
	private void creatEnemy() {
		if(tanks.size()<3&&tankCount<20){
			tanks.add(new EnemyTank(position*11+1, 1, 2, 0, 0));
			position++;
			if(position>2)
				position = 0;
		}
	}
	
}
