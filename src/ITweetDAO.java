
import java.sql.SQLException;
import java.util.List;

public interface ITweetDAO {
	
	public void create(Tweet tweet) throws SQLException;
	public void remove(Tweet tweet) throws SQLException;
	public void update(Tweet tweet) throws SQLException;
	public List<Tweet> show(int id) throws SQLException;
}
