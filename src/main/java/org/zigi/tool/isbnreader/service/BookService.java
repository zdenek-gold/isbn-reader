package org.zigi.tool.isbnreader.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.zigi.tool.isbnreader.exception.MissingApiKeyException;
import org.zigi.tool.isbnreader.model.Book;
import org.zigi.tool.isbnreader.util.Util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BookService {

	private static final String FIND_BY_ISBN_PATTERN = "https://www.googleapis.com/books/v1/volumes?q=isbn:%s&key=%s";
	private static final Logger LOG = Logger.getLogger(BookService.class);

	// TODO smazat
	// api_key=AIzaSyBm1Qo7XWmY9w2wNuk8DttsPIIjFhWqqjk

	public static Book find(String isbn) throws MissingApiKeyException {

		String apiKey = Util.property("api_key");
		if (apiKey == null || apiKey.isEmpty())
			throw new MissingApiKeyException();

		HttpClient client = HttpClientBuilder.create().build();

		HttpGet request = new HttpGet(String.format(FIND_BY_ISBN_PATTERN, isbn, apiKey));

		try {
			HttpResponse response = client.execute(request);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

			Gson gson = new GsonBuilder().create();
			return gson.fromJson(result.toString(), Book.class);
		} catch (Exception e) {
			LOG.error("Error while response of server", e);
		}

		return null;
	}
}
