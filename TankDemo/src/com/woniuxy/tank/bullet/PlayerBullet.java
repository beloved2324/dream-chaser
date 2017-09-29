package com.woniuxy.tank.bullet;

import com.woniuxy.tank.character.enemy.EnemyTank;
import com.woniuxy.tank.ui.GamePanel;

public class PlayerBullet extends Bullet{

	public PlayerBullet(int x, int y, int dir) {
		super(x, y, dir, true);
	}

	@Override
	protected void collision() {
		super.collision();
		
		for(int i = 0 ;i < GamePanel.tanks.size();i++){
			EnemyTank et = GamePanel.tanks.get(i);
			if(this.x == et.getX()&& this.y == et.getY()){
				et.damage();
				this.drawBullet = false;
			}
		}
	}
	
}
