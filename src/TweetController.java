import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TweetController implements ITweetController {
	
	private static ITweetDAO tweet;
	private static TweetController instance = null;
	
	public TweetController() {}
	
	public TweetController getInstance() throws SQLException, ClassNotFoundException {
		if (instance == null) {
			instance = new TweetController();
			tweet = new TweetDAO();
		}
		return instance;
	}

	public void inserirTweet(int id, String user, String text, String ss) {
		Tweet t_new = new Tweet(id, user, text, ss);
		try {
			tweet.create(t_new);
		} catch (SQLException e) {
			System.err.println("Erro ao criar tweet: " + e);
		}
	}
	
	public void deletarTweet(int id) {
		Tweet t_old = new Tweet();
		t_old.setId(id);
		try {
			tweet.remove(t_old);
		} catch (SQLException e) {
			System.err.println("Erro ao remover tweet: " + e);
		}
	}
	
	public void atualizarTweet(int id, String user, String text, String ss){
		Tweet t_updated = new Tweet(id, user, text, ss);
		try {
			tweet.update(t_updated);
		} catch (SQLException e) {
			System.err.println("Erro ao atualizar tweet: " + e);
		}
	}
	
	public List<Tweet> mostrarTweet(int id){
		List<Tweet> listaUsuario = new ArrayList<Tweet>();
		try {
			listaUsuario = tweet.show(id);
		} catch (SQLException e) {
			System.err.println("Erro ao consultar tweet: " + e);
		}
		return listaUsuario;
	}
}
