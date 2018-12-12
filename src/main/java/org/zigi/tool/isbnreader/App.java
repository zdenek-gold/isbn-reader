package org.zigi.tool.isbnreader;

import org.zigi.tool.isbnreader.exception.MissingApiKeyException;
import org.zigi.tool.isbnreader.model.Book;
import org.zigi.tool.isbnreader.service.BookService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws MissingApiKeyException {
		Book book = BookService.find("9788024726533");
		System.out.println(book);
	}
}
