package core;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entities.*;

public class GameCanvas extends Canvas implements KeyListener{

	private World world = new World();
	public SpriteMap spriteMap = new SpriteMap();
	public boolean isRightKeyPressed = false;
	public boolean isLeftKeyPressed = false;
	public boolean isJumpKeyPressed = false;
	
	public GameCanvas() {
		setBackground(Color.BLACK);
		this.addKeyListener(this);
	}
	
	private void onRenderFrame() {
	}
	
	@Override
	public void paint (Graphics g) {
		onRenderFrame();
		Graphics2D g2D = (Graphics2D) g;
		for (Entity entity:world.entityList.getEntityList())
			entity.draw(this, g2D);
	 }

	@Override
	public void keyTyped(KeyEvent key) {}

	@Override
	public void keyPressed(KeyEvent key) {
		if(key.getKeyCode()==KeyEvent.VK_W)
			isJumpKeyPressed = true;
		if(key.getKeyCode()==KeyEvent.VK_D)
			isRightKeyPressed = true;
		if(key.getKeyCode()==KeyEvent.VK_A)
			isLeftKeyPressed = true;
	}

	@Override
	public void keyReleased(KeyEvent key) {
		if(key.getKeyCode()==KeyEvent.VK_W)
			isJumpKeyPressed = false;
		if(key.getKeyCode()==KeyEvent.VK_D)
			isRightKeyPressed = false;
		if(key.getKeyCode()==KeyEvent.VK_A)
			isLeftKeyPressed = false;
	}
	
}