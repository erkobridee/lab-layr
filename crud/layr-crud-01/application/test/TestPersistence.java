package test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

@Stateless
public class TestPersistence {

	private Map<Integer, TestModel> testValues;
	
	
	public TestPersistence() {
		testValues = new HashMap<Integer, TestModel>();
		this.init();
	}
	
	private void init() {
		TestModel value;
		for(int i = 0; i < 10; i++) {
			value = new TestModel();
			value.setValue("Issue " + (i+1));
			this.insert(value);
		}
		value = null;
	}
	
	public Collection<TestModel> getAll() {
		return testValues.values();
	}
	
	public TestModel getById(Integer id) {
		return testValues.get(id);
	}
	
	public void insert(TestModel value) {
		Integer key = testValues.size();
		value.setId(key);
		testValues.put(key, value);
	}
	
	public void update(Integer id, TestModel value) {
		testValues.put(id, value);
	}
	
	public void remove(Integer id) {
		testValues.remove(id);
	}
}
