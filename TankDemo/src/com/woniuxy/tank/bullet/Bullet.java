package com.woniuxy.tank.bullet;


import java.awt.Graphics;
import java.awt.Image;

import com.woniuxy.tank.character.Character;
import com.woniuxy.tank.ui.GamePanel;

public class Bullet extends Character implements Runnable{
	public boolean drawBullet = true;
	private int bulletSpeed = 3;
	
	private boolean bulletType;//true for player,false for enemy
	
	public Bullet(int x, int y, int dir,boolean bulletType) {
		super(x, y, dir, 0, 0);
		drawBullet = true;
		new Thread(this).start();
	}
	@Override
	public void run() {
		int moveSign = 0;
		while(drawBullet){
			moveSign++;
			if(moveSign>bulletSpeed){
				this.move();
				moveSign = 0;
			}
			this.collision();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		GamePanel.bullets.remove(this);
	}
	private void move() {
		switch (dir) {
		case 0:
			y--;
			break;
		case 1:
			x++;	
			break;
		case 2:
			y++;
			break;
		case 3:
			x--;
			break;
		default:
			break;
		}
	}
	protected void collision() {
		switch (GamePanel.currentMap[y][x]) {
		case 1:
		case 5:
		case 6:
			drawBullet = false;
			break;
		case 2:
		case 3:
			drawBullet = false;
			GamePanel.currentMap[y][x] = 0;
			break;
		default:
			break;
		}
	}
	
	public void draw(Graphics g, GamePanel gamePanel, Image bullet_img, int[][] currentMap) {
		g.drawImage(bullet_img, (x<<5)+12, (y<<5)+12, ((x+1)<<5)-12, ((y+1)<<5)-12, dir<<3, 0, (dir+1)<<3, 1<<3, gamePanel);
	}
}
