package core;

import java.util.LinkedList;

import entities.Entity;

public class EntityList {

	private LinkedList<Entity> entityList = new LinkedList<Entity>();

	public LinkedList<Entity> getEntityList() {
		return entityList;
	}

	public void add(Entity entity) {
		entityList.add(entity);
	}

	public boolean isEmpty() {
		if(entityList.isEmpty())
			return true;
		return false;
	}

	public int size() {
		return entityList.size();
	}

	public Entity get(int i) {
		return entityList.get(i);
	}

	public Entity[] getAll() {
		return entityList.toArray(new Entity[0]);
	}

	public void clear() {
		entityList.clear();
	}

}
