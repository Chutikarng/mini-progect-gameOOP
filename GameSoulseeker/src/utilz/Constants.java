package utilz;

import main.Game;

public class Constants {
	
	public static final float GRAVITY = 0.04f * Game.SCALE;
	public static final int ANI_SPEED = 25;
	
	public static class ObjectConstants {

		public static final int RED_POTION = 0;
		public static final int BLUE_POTION = 1;
		public static final int BARREL = 2;
		public static final int BOX = 3;
		public static final int SPIKE = 4;

		public static final int RED_POTION_VALUE = 15;
		public static final int BLUE_POTION_VALUE = 10;

		public static final int CONTAINER_WIDTH_DEFAULT = 40;
		public static final int CONTAINER_HEIGHT_DEFAULT = 30;
		public static final int CONTAINER_WIDTH = (int) (Game.SCALE * CONTAINER_WIDTH_DEFAULT);
		public static final int CONTAINER_HEIGHT = (int) (Game.SCALE * CONTAINER_HEIGHT_DEFAULT);

		public static final int POTION_WIDTH_DEFAULT = 12;
		public static final int POTION_HEIGHT_DEFAULT = 16;
		public static final int POTION_WIDTH = (int) (Game.SCALE * POTION_WIDTH_DEFAULT);
		public static final int POTION_HEIGHT = (int) (Game.SCALE * POTION_HEIGHT_DEFAULT);
		
		public static final int SPIKE_WIDTH_DEFAULT = 32;
		public static final int SPIKE_HEIGHT_DEFAULT = 32;
		public static final int SPIKE_WIDTH = (int) (Game.SCALE * SPIKE_WIDTH_DEFAULT);
		public static final int SPIKE_HEIGHT = (int) (Game.SCALE * SPIKE_HEIGHT_DEFAULT);


		public static int GetSpriteAmount(int object_type) {
			switch (object_type) {
			case RED_POTION, BLUE_POTION:
				return 7;
			case BARREL, BOX:
				return 8;
			}
			return 1;
		}
	}
	public static class EnemyConstants {
		public static final int DEVIL = 0;

		public static final int IDLE = 0;
		public static final int RUNNING = 1;
		public static final int ATTACK = 2;
		public static final int HIT = 3;
		public static final int DEAD = 4;

		public static final int DEVIL_WIDTH_DEFAULT = 90;
		public static final int DEVIL_HEIGHT_DEFAULT = 63;

		public static final int DEVIL_WIDTH = (int) (DEVIL_WIDTH_DEFAULT * Game.SCALE);
		public static final int DEVIL_HEIGHT = (int) (DEVIL_HEIGHT_DEFAULT * Game.SCALE);
		
		public static final int DEVIL_DRAWOFFSET_X = (int) (1 * Game.SCALE);
		public static final int DEVIL_DRAWOFFSET_Y = (int) (4 * Game.SCALE);

		public static int GetSpriteAmount(int enemy_type, int enemy_state) {

			switch (enemy_type) {
			case DEVIL:
				switch (enemy_state) {
				case IDLE:
				case RUNNING:
				case ATTACK:
				case HIT:
				case DEAD:
					return 3;
				}
			}
			return 0;
		}
		
		public static int GetMaxHealth(int enemy_type) {
			switch (enemy_type) {
			case DEVIL:
				return 10;
			default:
				return 1;
			}
		}

		public static int GetEnemyDmg(int enemy_type) {
			switch (enemy_type) {
			case DEVIL:
				return 15;
			default:
				return 0;
			}

		}

	}

	
	public static class UI {
		public static class Buttons{
			public static final int B_WIDTH_DEFAULT = 140;
			public static final int B_HEIGHT_DEFAULT = 56;
			public static final int B_WIDTH = (int)(B_WIDTH_DEFAULT * Game.SCALE);
			public static final int B_HEIGHT = (int)(B_HEIGHT_DEFAULT * Game.SCALE);
		}
		
		public static class PauseButtons {
			
		}

		public static class URMButtons {
			public static final int URM_DEFAULT_SIZE = 56;
			public static final int URM_SIZE = (int) (URM_DEFAULT_SIZE * Game.SCALE);

		}
	}
	
	public static class Directions {
		public static final int LEFT = 0;
		public static final int UP = 1;
		public static final int RIGHT = 2;
		public static final int DOWN = 3;
	}
	
	public static class PlayerConstants {
		public static final int IDLE = 0;
		public static final int RUNNING = 1;
		public static final int JUMP = 2;
		public static final int FALLING = 3;
		public static final int ATTACK = 4;
		public static final int HIT = 5;
		public static final int DEAD = 6;
		
		public static int GetSpriteAmount(int player_action) {
			
			switch(player_action) {
			case RUNNING:
				return 4;
			case ATTACK:
			case DEAD:
				return 3;
			case HIT:
				return 2;
			case IDLE:
			case JUMP:
			case FALLING:
			default:
				return 1;
			
			}
			
		}
	}

}

