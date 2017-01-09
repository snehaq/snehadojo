package Utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GenericUtility {
	public static void hitAnyUrlUsingGetMethod(String url) throws Exception {
		final String USER_AGENT = "Mozilla/5.0";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

	}

	public static void callGetOfMail() throws Exception {

		String url = "http://localhost:8080/MailSender/controller?mode=sendMail";
		hitAnyUrlUsingGetMethod(url);
	}

	public static void callGetOfCronJobHitter() throws Exception {
		System.out.println("In callget cjh");
		String url = "http://localhost:8081/Cronjob/CronJobHitter";
		hitAnyUrlUsingGetMethod(url);
	}
}
