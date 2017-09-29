package com.woniuxy.tank.character;

import java.awt.event.KeyEvent;

import com.woniuxy.tank.bullet.Bullet;
import com.woniuxy.tank.bullet.PlayerBullet;
import com.woniuxy.tank.ui.GamePanel;

public class Player extends Character{
	
	public Player(int x, int y) {
		super(x, y, 0, 0, 0);
	}

	public void action(KeyEvent e, int[][] currentMap) {
		synDirecter(e);
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			if(currentMap[y-1][x]==0||currentMap[y-1][x]==2){
				y--;
			}
			break;
		case KeyEvent.VK_A:
			if(currentMap[y][x-1]==0||currentMap[y][x-1]==2){
				x--;
			}
			break;
		case KeyEvent.VK_S:
			if(currentMap[y+1][x]==0||currentMap[y+1][x]==2){
				y++;
			}
			break;
		case KeyEvent.VK_D:
			if(currentMap[y][x+1]==0||currentMap[y][x+1]==2){
				x++;
			}
			break;
		case KeyEvent.VK_J:
			Bullet bullet = null;
			switch (dir) {
			case 0:
				bullet = new PlayerBullet(x,y-1,dir);
				break;
			case 1:
				bullet = new Bullet(x+1,y,dir,true);		
				break;
			case 2:
				bullet = new Bullet(x,y+1,dir,true);
				break;
			case 3:
				bullet = new Bullet(x-1,y,dir,true);
				break;
			default:
				break;
			}
			GamePanel.bullets.add(bullet);
			break;
		default:
			break;
		}
	}
}
