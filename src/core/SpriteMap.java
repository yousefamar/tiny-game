package core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class SpriteMap {

	public final int spriteNumber = 3;
	public final int spriteFrames = 8;
	public final int sizeX = 32;
	public final int sizeY = 32;
	private BufferedImage spriteSheet;
	private BufferedImage sprites[][];
	
	public SpriteMap() {
		try{spriteSheet = ImageIO.read(this.getClass().getClassLoader().getResource("images/spritemap.png"));}
		catch(IOException e){e.printStackTrace();}
		sprites = new BufferedImage[spriteNumber][spriteFrames];

		for (int i = 0; i < spriteNumber; i++)
			for (int j = 0; j < spriteFrames; j++)
				sprites[i][j] = spriteSheet.getSubimage(j*sizeX, i*sizeY, sizeX, sizeY);
	}
	
	
	public BufferedImage getSprite(int index, int frame) {
		return sprites[index][frame];
	}
	
}
