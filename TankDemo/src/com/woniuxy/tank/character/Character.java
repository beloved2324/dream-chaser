package com.woniuxy.tank.character;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import com.woniuxy.tank.ui.GamePanel;

public class Character {
	protected int x;
	protected int y;
	protected int dir;
	protected int step;
	protected int tankId;
	
	protected int tankHP;
	
	public int getTankHP() {
		return tankHP;
	}
	public void setTankHP(int tankHP) {
		this.tankHP = tankHP;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Character(int x, int y, int dir, int step, int tankId) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.step = step;
		this.tankId = tankId;
		this.tankHP = tankId/2+1;
	}
	public void damage(){
		tankHP--;
	}
	public void synDirecter(KeyEvent e){
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			dir = 0;
			break;
		case KeyEvent.VK_A:
			dir = 3;
			break;
		case KeyEvent.VK_S:
			dir = 2;
			break;
		case KeyEvent.VK_D:
			dir = 1;
			break;
		default:
			break;
		}
	}
	public void draw(Graphics g,JPanel p,Image tree,Image character){
		g.drawImage(character, x<<5, y<<5, (x<<5)+(1<<5), (y<<5)+(1<<5), (step+tankId)*28, (dir+tankId)*28, (step+tankId+1)*28, (dir+tankId+1)*28, p);
		this.inTheWoods(g,p,tree);
		this.step();
	}

	private void step() {
		step++;
		if(step>1)
			step=0;
	}

	private void inTheWoods(Graphics g, JPanel p, Image tree) {
		if(GamePanel.currentMap[y][x] == 2){
			g.drawImage(tree, (x<<5)-3, (y<<5)-3, (x<<5)+(1<<5)+3, (y<<5)+(1<<5)+3, 2<<5, 0<<5, 3<<5, 1<<5, p);
		}
	}
}
