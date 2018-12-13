package org.zigi.tool.isbnreader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.zigi.tool.isbnreader.api.IBookApi;
import org.zigi.tool.isbnreader.exception.MissingApiKeyException;
import org.zigi.tool.isbnreader.model.IBook;
import org.zigi.tool.isbnreader.service.BookService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws MissingApiKeyException {
		List<IBookApi> APIS = new ArrayList<>();
		APIS.add(BookService.GOOGLE_API);

		Map<IBookApi, List<IBook>> result = BookService.find("9788024726533", APIS);
		System.out.println(result);
	}
}
