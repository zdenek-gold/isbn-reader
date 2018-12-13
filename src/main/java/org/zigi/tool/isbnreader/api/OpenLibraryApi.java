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
import org.zigi.tool.isbnreader.api.openlibrary.model.Book;
import org.zigi.tool.isbnreader.model.IBook;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class OpenLibraryApi implements IBookApi {

	private static final String FIND_BY_ISBN_PATTERN = "https://openlibrary.org/api/books?bibkeys=ISBN:%s&format=json&jscmd=details";
	private static final Logger LOG = Logger.getLogger(OpenLibraryApi.class);

	@Override
	public List<IBook> find(String isbn) {
		HttpClient client = HttpClientBuilder.create().build();

		HttpGet request = new HttpGet(String.format(FIND_BY_ISBN_PATTERN, isbn));

		try {
			HttpResponse response = client.execute(request);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

			String res = result.toString();
			String firstReplacement = "{\"ISBN:\"" + isbn + "\": ";
			res = res.substring(firstReplacement.length() - 1);
			res = res.substring(0, res.length() - 1);
			LOG.info(res);
			Gson gson = new GsonBuilder().create();
			Book instance = gson.fromJson(res, Book.class);

			if (instance == null || instance.getDetails() == null)
				return null;

			List<IBook> data = new ArrayList<IBook>();
			data.add(instance.getDetails());
			return data;
		} catch (Exception e) {
			LOG.error("Error while response of server", e);
		}

		return null;
	}

}
