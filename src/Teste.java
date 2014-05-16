import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import twitter4j.IDs;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;


public class Teste {	
	public static void main(String args[]) throws TwitterException, Exception{

		/*
		String oAuthAccessToken = "12345678910";
		String oAuthAccessTokenSecret = "12345678910"; 
		String oAuthConsumerKey = "l6rSoEGT61qm57Px3jZL1cCa5";
		String oAuthConsumerSecret = "8gsvKkADlTUMm6fuuqkk1TlBwJG3qpUWjxSpV0v7kkHciIV4Ir";
		String USERID = null;

		ConfigurationBuilder cfg = new ConfigurationBuilder();
		cfg.setOAuthAccessToken(oAuthAccessToken);
		cfg.setOAuthAccessTokenSecret(oAuthAccessTokenSecret);
		cfg.setOAuthConsumerKey(oAuthConsumerKey);
		cfg.setOAuthConsumerSecret(oAuthConsumerSecret);
		Twitter twitter = new TwitterFactory(cfg.build()).getInstance();
		long [] ids = twitter.getFriendsIDs(USERID, -1).getIDs();
		
		System.out.println(ids[0]);
		*/


		
		// The factory instance is re-useable and thread safe.
		Twitter twitter = TwitterFactory.getSingleton();
		twitter.setOAuthConsumer("lm9RqUb6hYJRmQhzjMul5PeSy", "Fm7ChwRNwxTwg2hG6pDGdAyoJqtKaO1a114VUf5HwWUFqSt5yy");
		RequestToken requestToken = twitter.getOAuthRequestToken();
		AccessToken accessToken = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (null == accessToken) {
			System.out.println("Open the following URL and grant access to your account:");
			System.out.println(requestToken.getAuthorizationURL());
			System.out.print("Enter the PIN(if aviailable) or just hit enter.[PIN]:");
			String pin = br.readLine();
			try{
				if(pin.length() > 0){
					accessToken = twitter.getOAuthAccessToken(requestToken, pin);
				}else{
					accessToken = twitter.getOAuthAccessToken();
				}
			} catch (TwitterException te) {
				if(401 == te.getStatusCode()){
					System.out.println("Unable to get the access token.");
				}else{
					te.printStackTrace();
				}
			}
		}
		
		long cursor = -1;
		List<User> users=twitter.getFriendsList(twitter.getId(), cursor);
		for (int i=0 ; i<users.size() ; i++) {
			System.out.println(users.get(i));
		}
		
		

		
		
		
		Scanner entrada = new Scanner (System.in);
		System.out.print("Digite seu tt: ");
		String tt = entrada.nextLine();
		
		//persist to the accessToken for future reference.
		storeAccessToken(accessToken);
		Status status = twitter.updateStatus(tt);
		System.out.println("Successfully updated the status to [" + status.getText() + "].");
		
		System.exit(0);
		
		
	}
	private static void storeAccessToken(AccessToken accessToken){
		accessToken.getToken();
		accessToken.getTokenSecret();
	}

		 

}
