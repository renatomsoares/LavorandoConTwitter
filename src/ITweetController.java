import java.util.List;

public interface ITweetController {

	public void inserirTweet(int id, String user, String text, String ss);
	public void deletarTweet(int id);
	public void atualizarTweet(int id, String user, String text, String ss);
	public List<Tweet> mostrarTweet(int id);
}