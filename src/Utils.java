import java.util.ArrayList;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class Utils {

	private static final String token = "81692789-sJyBL7OcATiufRK3xFZX9rQNY4vjZfkOy0h8pQg0z";
	private static final String tokenSecret = "3geB9URANyxSbuOkFQHlip5RpJcK3u8Rnh7I4ORmrfviK";
	private static final String consumerKey = "lm9RqUb6hYJRmQhzjMul5PeSy";
	private static final String consumerSecret = "Fm7ChwRNwxTwg2hG6pDGdAyoJqtKaO1a114VUf5HwWUFqSt5yy";
	private static final String tweetLink = "https://twitter.com/tweet/status/";
	public static Twitter twitter = null;


	public static Twitter createTwitter(){
		if (twitter == null) {
			twitter = TwitterFactory.getSingleton();
			AccessToken accessToken = new AccessToken(token, tokenSecret);
			twitter.setOAuthConsumer(consumerKey, consumerSecret);
			twitter.setOAuthAccessToken(accessToken);
		}
		return twitter;
	}

	public static ArrayList<Tweet> search(Twitter twitter, String queryString, int tweetCount){
		try{
			Query query = new Query(queryString);
			query.setCount(tweetCount);
			QueryResult result = twitter.search(query);
			ArrayList<Tweet> tweets = new ArrayList<Tweet>();
			for (Status status : result.getTweets()) {
				int id = (int) status.getId();
				String user = status.getUser().getName();
				String text = status.getText();
				String image = status.getUser().getProfileImageURL();
				String link = tweetLink + status.getId(); // Cria URL para o tweet na web.
				Tweet tweet = new Tweet(id, user, text, image, link);
				tweets.add(tweet);
			}
			return tweets;
		} catch(TwitterException e){
			System.out.println("Erro no twitter");
			e.printStackTrace();
			return new ArrayList<Tweet>();
		} catch(NullPointerException e){
			System.out.println("Provavelmente Twitter nulo sendo passado para o método search.");
			e.printStackTrace();
			return new ArrayList<Tweet>();
		} catch(IllegalArgumentException e){
			System.out.println("Erro de log.");
			e.printStackTrace();
			return new ArrayList<Tweet>();
		}
	}

	public static void main(String[] args) throws IllegalStateException, TwitterException {

		Twitter twitter = createTwitter();
		System.out.println(twitter.getScreenName());
		
		ArrayList<Tweet> t = search(twitter, "renatomsoares", 10);
		for (int i = 0 ; i < t.size() ; i++) {
			System.out.println(t.get(i).getUser() + ": " + t.get(i).getText());
		}


	}
}

