package org.zigi.tool.isbnreader.api.openlibrary.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zigi.tool.isbnreader.model.IBook;

public class BookDetails implements IBook {
	private BookDate created;
	private List<String> isbn_10;
	private List<BookAuthor> authors;
	private String title;

	public BookDate getCreated() {
		return created;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String getId() {
		return null;
	}

	@Override
	public String getLink() {
		return null;
	}

	@Override
	public String getPublishedDate() {
		BookDate date = getCreated();
		if (date == null)
			return null;
		return date.getValue();
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public Map<String, String> getIdentifiers() {
		if (isbn_10 == null || isbn_10.isEmpty())
			return null;

		Map<String, String> isbns = new HashMap<String, String>();
		isbns.put("isbn10", isbn_10.get(0));
		return isbns;
	}

	@Override
	public Integer getPageCount() {
		return null;
	}

	@Override
	public List<String> getCategories() {
		return null;
	}

	@Override
	public String getSmallThumbnail() {
		return null;
	}

	@Override
	public String getThumbnail() {
		return null;
	}

	@Override
	public List<String> getAuthors() {
		if (authors == null)
			return null;

		List<String> names = new ArrayList<>();
		for (BookAuthor author : authors)
			names.add(author.getName());
		return names;
	}

}
