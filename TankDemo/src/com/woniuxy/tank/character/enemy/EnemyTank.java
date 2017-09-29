package com.woniuxy.tank.character.enemy;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import com.woniuxy.tank.bullet.EnemyBullet;
import com.woniuxy.tank.character.Character;
import com.woniuxy.tank.ui.GamePanel;

public class EnemyTank extends Character implements Runnable{

	public final int TURN_SIGN = 3;//如果
	
	public boolean isDrawTank = true;
	public boolean isDrawStart = true;
	
	public int starId=0;
	
	protected int tankSpeed = 8;
	private int firingRate = 5;
	
	private int[][] currentMap;
	
	
	public EnemyTank(int x, int y, int dir, int step, int tankId) {
		super(x, y, dir, step, tankId);
		new Thread(this).start();
	}
	
	public void drawTank(Graphics g,JPanel p,Image tree,Image character,Image star){
		currentMap=GamePanel.currentMap;
		if(isDrawStart){
			this.drawStar(g,p,star);
		}else{
			super.draw(g, p, tree, character);
		}
	}
	
	private void drawStar(Graphics g, JPanel p, Image star) {
		g.drawImage(star,  x<<5, y<<5, (x<<5)+(1<<5), (y<<5)+(1<<5), starId<<5, 0, (starId+1)<<5, 1<<5, p);
		starId++;
		if(starId>3)
			starId = 0;
	}

	@Override
	public void run() {
		int tankMoveSign = 0;
		int starSign = 0;
		int turn_sign = 0;
		int shot_sign = 0;
		while(isDrawTank){
			if(tankHP == 0)
				break;
			if(isDrawStart){
				starSign++;
				if(starSign>20){
					isDrawStart = false;
				}
			}else{
				tankMoveSign++;
				shot_sign++;
				if(tankMoveSign>tankSpeed){
					move();
					tankMoveSign = 0;
					turn_sign++;
					if(turn_sign>TURN_SIGN){
						turn();
						turn_sign = 0;
					}
					if(shot_sign>firingRate){
						shot();
						shot_sign = 0;
					}
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		GamePanel.tanks.remove(this);
	}
	private void shot() {
		GamePanel.bullets.add(new EnemyBullet(x, y, dir));
	}

	private void turn() {
		if((int)(Math.random()*10)>TURN_SIGN)
			dir = (int)(Math.random()*4);
	}

	private void move() {
		switch (dir) {
		case 0:
			if(currentMap[y-1][x]==0||currentMap[y-1][x]==2){
				y--;
			}
			break;
		case 1:
			if(currentMap[y][x+1]==0||currentMap[y][x+1]==2){
				x++;
			}
			break;
		case 2:
			if(currentMap[y+1][x]==0||currentMap[y+1][x]==2){
				y++;
			}
			break;
		case 3:
			if(currentMap[y][x-1]==0||currentMap[y][x-1]==2){
				x--;
			}
			break;
		default:
			dir = (int)(Math.random()*4);
			break;
		}
	}
	
	
	
}
