package MvcPackage;

import java.util.List;

public interface UserDao {

	void create(Bean ref);

	List<Bean> read();

	void update(Bean ref);

	void delete(Bean ref);
}
