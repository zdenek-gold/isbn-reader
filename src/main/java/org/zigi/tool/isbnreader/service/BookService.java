package org.zigi.tool.isbnreader.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zigi.tool.isbnreader.api.GoogleApi;
import org.zigi.tool.isbnreader.api.IBookApi;
import org.zigi.tool.isbnreader.api.OpenLibraryApi;
import org.zigi.tool.isbnreader.exception.MissingApiKeyException;
import org.zigi.tool.isbnreader.model.IBook;

public class BookService {
	public static final IBookApi GOOGLE_API = new GoogleApi();
	public static final IBookApi OPEN_LIBRARY_API = new OpenLibraryApi();

	public static Map<IBookApi, List<IBook>> find(String isbn, List<IBookApi> apis) throws MissingApiKeyException {
		Map<IBookApi, List<IBook>> result = new HashMap<IBookApi, List<IBook>>();
		for (IBookApi api : apis) {
			List<IBook> books = api.find(isbn);
			if (books != null)
				result.put(api, books);
		}
		return result;
	}
}
