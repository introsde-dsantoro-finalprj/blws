package introsde.dsantoro.dao;

import java.util.HashMap;
import java.util.Map;

public enum GoalStoreDao {
	INSTANCE;
	
	private HashMap<Long, GoalStore> contentProvider;
	
	private GoalStoreDao() {
		contentProvider = new HashMap<Long, GoalStore>();
	}
	
	public HashMap<Long, GoalStore> getDataProvider() {
		return contentProvider;
	}
	
}
