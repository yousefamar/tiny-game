package entities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import core.GameCanvas;

public abstract class Entity {
	
	protected int spawnX, spawnY;
	protected int posX, posY;
	protected int prevPosX, prevPosY;
	protected int motionX, motionY;
	protected int spriteIndex;
	protected boolean isRightKeyPressed = false;
	protected boolean isLeftKeyPressed = false;
	protected boolean isJumpKeyPressed = false;
	
	public abstract void draw(GameCanvas gameCanvas, Graphics2D g2D);
	
}
