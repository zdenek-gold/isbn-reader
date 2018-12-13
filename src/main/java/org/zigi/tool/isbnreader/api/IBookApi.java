package org.zigi.tool.isbnreader.api;

import java.util.List;

import org.zigi.tool.isbnreader.exception.MissingApiKeyException;
import org.zigi.tool.isbnreader.model.IBook;

public interface IBookApi {
	public List<IBook> find(String isbn) throws MissingApiKeyException;
}
