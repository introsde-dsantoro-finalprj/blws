package introsde.dsantoro.dao;

import java.util.HashMap;
import java.util.Map;

public enum GoalStoreDao {
	INSTANCE;
	
	private Map<Long, GoalStore> contentProvider;
	
	GoalStoreDao() {
		contentProvider = new HashMap<Long, GoalStore>();
	}
	
	public Map<Long, GoalStore> getDataProvider() {
		return contentProvider;
	}
	
}
