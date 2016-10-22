package fr.tse.info.projet.stackoverflow.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.net.HttpURLConnection;

/**
 * Class which contains all methods to import data from the Stack Exchanges API
 *
 */
public class RequeteGet {

	/*
	 * Main function of data recovery from StackExchange API by a GET Method
	 * 
	 * @exception IOException
	 * 
	 * @param url url to join to have data
	 * 
	 * @return the string in JSON return by the API
	 */
	private static String recupData(String url) throws IOException {

		String resultat = "";
		URL ourUrl = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) ourUrl.openConnection();
		connection.setRequestMethod("GET");
		BufferedReader in = new BufferedReader(new InputStreamReader(new GZIPInputStream(connection.getInputStream())));


		/*while ((inputLine = in.readLine()) != null)
			resultat += inputLine;
		in.close();*/
		return in.readLine();
		
	}

	public static String findContributor(String subject) throws IOException {
		String contributor = "";
		Map<Integer, Integer> contributorsMap = new HashMap<Integer, Integer>();
		contributor = recupData(
				"https://api.stackexchange.com/2.2/questions/40190834/answers?order=desc&sort=activity&site=stackoverflow");
		return contributor;
	}

	public static void main(String[] args) {
		try {
			System.out.println(findContributor("coucou"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
