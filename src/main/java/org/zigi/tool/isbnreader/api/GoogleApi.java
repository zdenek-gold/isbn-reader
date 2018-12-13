package org.zigi.tool.isbnreader.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.zigi.tool.isbnreader.api.google.model.Book;
import org.zigi.tool.isbnreader.api.google.model.BookItem;
import org.zigi.tool.isbnreader.exception.MissingApiKeyException;
import org.zigi.tool.isbnreader.model.IBook;
import org.zigi.tool.isbnreader.util.Util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GoogleApi implements IBookApi {

	private static final String FIND_BY_ISBN_PATTERN = "https://www.googleapis.com/books/v1/volumes?q=isbn:%s&key=%s";
	private static final Logger LOG = Logger.getLogger(GoogleApi.class);

	@Override
	public List<IBook> find(String isbn) throws MissingApiKeyException {

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
			Book instance = gson.fromJson(result.toString(), Book.class);

			if (instance == null || instance.getItems() == null)
				return null;

			List<IBook> books = new ArrayList<IBook>();
			for (BookItem item : instance.getItems())
				books.add(item);
			return books;
		} catch (Exception e) {
			LOG.error("Error while response of server", e);
		}

		return null;
	}

}
