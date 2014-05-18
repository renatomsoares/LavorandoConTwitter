import java.util.List;

public interface ITweetController {

	public void inserirTweet(int id, String user, String text);
	public void deletarTweet(int id);
	public void atualizarTweet(int id, String user, String text);
	public List<Tweet> mostrarTweet(int id);
}