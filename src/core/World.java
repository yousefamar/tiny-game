package core;

import entities.*;

public class World {
	
	public EntityList entityList = new EntityList();
	
	public World() {
		entityList.add(new Player(this));
	}

}
