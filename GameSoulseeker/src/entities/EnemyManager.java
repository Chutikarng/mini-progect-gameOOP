package entities;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import gamestates.Playing;
import levels.Level;
import utilz.LoadSave;
import static utilz.Constants.EnemyConstants.*;

public class EnemyManager {

	private Playing playing;
	private BufferedImage[][] devilArr;
	private ArrayList<Devil> devils = new ArrayList<>();

	public EnemyManager(Playing playing) {
		this.playing = playing;
		loadEnemyImgs();
	}

	public void loadEnemies(Level level) {
		devils = level.getDevils();
	}

	public void update(int[][] lvlData, Player player) {
		boolean isAnyActive = false;
		for (Devil c : devils)
			if(c.isActive()) {
				c.update(lvlData, player);
				isAnyActive = true;
			}
		if(!isAnyActive)
			playing.setLevelCompleted(true);
	}

	public void draw(Graphics g, int xLvlOffset) {
		drawDevils(g, xLvlOffset);
	}

	private void drawDevils(Graphics g, int xLvlOffset) {
		for (Devil c : devils) 
			if(c.isActive()) {
				g.drawImage(devilArr[c.getEnemyState()][c.getAniIndex()], (int) c.getHitbox().x - xLvlOffset - DEVIL_DRAWOFFSET_X + c.flipX(), (int) c.getHitbox().y - DEVIL_DRAWOFFSET_Y, 
						DEVIL_WIDTH * c.flipW(), DEVIL_HEIGHT, null);
			c.drawHitbox(g, xLvlOffset);
				c.drawAttackBox(g, xLvlOffset);
			
			}
	}
	
	public void checkEnemyHit(Rectangle2D.Float attackBox) {
		for (Devil c : devils)
			if (c.isActive())
				if (attackBox.intersects(c.getHitbox())) {
					c.hurt(10);
					return;
				}
	}

	private void loadEnemyImgs() {
		devilArr = new BufferedImage[5][3];
		BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.DEVIL_SPRITE);
		for (int j = 0; j < devilArr.length; j++)
			for (int i = 0; i < devilArr[j].length; i++)
				devilArr[j][i] = temp.getSubimage(i * DEVIL_WIDTH_DEFAULT, j * DEVIL_HEIGHT_DEFAULT, DEVIL_WIDTH_DEFAULT, DEVIL_HEIGHT_DEFAULT);
	}

	public void resetAllEnemies() {
		for (Devil c : devils)
			c.resetEnemy();
	}
}
