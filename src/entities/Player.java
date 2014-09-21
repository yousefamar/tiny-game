package entities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImageOp;

import core.*;

public class Player extends Entity {
	
	private int spriteFrame = 0;

	public Player(World world) {
		spriteIndex=0;
		spawnX=400;
		spawnY=300;
		posX=spawnX;
		posY=spawnY;
		motionX=0;
		motionY=0;
	}
	
	private void onUpdate() {
		updatePlayerMotion();
		updatePlayerSprite();
	}

	private void updatePlayerMotion() {
		prevPosX=posX;
		prevPosY=posY;

		if(isJumpKeyPressed)
			jump();
		if(isRightKeyPressed && motionX<10)
			motionX+=2;
		if(isLeftKeyPressed && motionX>-10)
			motionX-=2;
		
		posX+=motionX;
		posY+=motionY;
		
		if(motionX>0)
			motionX--;
		if(motionX<0)
			motionX++;
		if(posY<500)
			motionY++;
		if(posY>=500)
			motionY=0;
		if(posX>800)
			posX=-32;
		if(posX<-32)
			posX=800;
	}
	
	private void updatePlayerSprite() {
		if(prevPosX==posX&&(spriteFrame==0||spriteFrame==1))
			spriteFrame=0;
		else if(prevPosX==posX&&(spriteFrame==3||spriteFrame==2))
			spriteFrame=4;
		else if(prevPosX>posX&&motionX>0)
			spriteFrame=7;
		else if(prevPosX<posX&&motionX<0)
			spriteFrame=3;
		else if(prevPosX>posX&&spriteFrame==5)
			spriteFrame=6;
		else if(prevPosX>posX)
			spriteFrame=5;
		else if(prevPosX<posX&&spriteFrame==2)
			spriteFrame=1;
		else if(prevPosX<posX)
			spriteFrame=2;
	}
	
	private void jump() {
		if(posY>=500)
			motionY=-10;
	}

	@Override
	public void draw(GameCanvas gameCanvas, Graphics2D g2D) {
		updateKeys(gameCanvas);
		onUpdate();
		g2D.drawImage(gameCanvas.spriteMap.getSprite(spriteIndex, spriteFrame), null, posX, posY);
		g2D.drawString ("I AM A PLAYER!", posX+32, posY);
//		spriteFrame++;
//		if(spriteFrame>=gameCanvas.spriteMap.spriteFrames) {
//			spriteFrame=0;
//		}
	}

	private void updateKeys(GameCanvas gc) {
		isJumpKeyPressed = gc.isJumpKeyPressed;
		isRightKeyPressed = gc.isRightKeyPressed;
		isLeftKeyPressed = gc.isLeftKeyPressed;
	}

}
