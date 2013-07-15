package issue;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

@Stateless
public class IssuePersistence {

	private Map<Integer, IssueModel> issues;

	
	public IssuePersistence() {
		issues = new HashMap<Integer, IssueModel>();
	}

	
	public IssueModel getById(Integer id) {
		return issues.get(id);
	}
	
	public Collection<IssueModel> getAll() {
		return issues.values();
	}
	
	public void insert(IssueModel issue) {
		int id = issues.size();
		issue.setId(id);
		issues.put(id, issue);
	}
	
	public void update(Integer id, IssueModel issue) {
		issues.put(id, issue);
	}
	
	public void remove(Integer id) {
		issues.remove(id);
	}
	
}
