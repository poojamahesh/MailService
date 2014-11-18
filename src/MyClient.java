import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class MyClient {

	public static  void mailSender() {

		@SuppressWarnings("deprecation")
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost("https://a8956362d198192ca9d352a694dfd11d:d7e86fb37bd15ca2303adff47dd894a1@api.mailjet.com/v3/send/message");

		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

		 nameValuePairs.add(new BasicNameValuePair("from",
		 "pooja11mahesh@gmail.com"));
		// nameValuePairs.add(new BasicNameValuePair("mail.user", "a8956362d198192ca9d352a694dfd11d"));
		// nameValuePairs.add(new BasicNameValuePair("mail.password", "d7e86fb37bd15ca2303adff47dd894a1"));
		 nameValuePairs.add(new BasicNameValuePair("to",
		 "dandadashaguna@gmail.com"));
		 nameValuePairs.add(new BasicNameValuePair("subject", "Stuff"));
		 nameValuePairs.add(new BasicNameValuePair("text", "We meet again!"));
		 nameValuePairs.add(new
		 BasicNameValuePair("html","<b><font color=\"blue\">Good job! Recycling a single aluminium can saves enough energy to power your television for three hours or to run a 100-watt light bulb for almost four hours.</font></b>"));
		 //you can as many name value pair as you want in the list.
		 try {
			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 HttpResponse response;
		try {
			response = client.execute(post);
			 int statusCode = response.getStatusLine().getStatusCode();
			 System.out.println("Email sent succesfully...!");
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	public static void main(String[] args)
	{
		mailSender();
		
	}
	
	
}
