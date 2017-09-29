package com.woniuxy.tank.bullet;

import com.woniuxy.tank.character.enemy.EnemyTank;
import com.woniuxy.tank.ui.GamePanel;

public class EnemyBullet extends Bullet{

	public EnemyBullet(int x, int y, int dir) {
		super(x, y, dir, false);
	}
	@Override
	protected void collision() {
		super.collision();
		if(this.x == GamePanel.player.getX()&& this.y == GamePanel.player.getY()){
			GamePanel.player.damage();
			this.drawBullet = false;
		}
	}
}
