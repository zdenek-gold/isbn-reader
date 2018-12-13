package org.zigi.tool.isbnreader.api.google.model;

import java.util.List;

public class VolumeInfo {
	private String title;
	private List<String> authors;
	private String publishedDate;
	private String description;
	private List<Identifier> industryIdentifiers;
	private Integer pageCount;
	private List<String> categories;
	private ImageLink imageLinks;

	public String getTitle() {
		return title;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public String getDescription() {
		return description;
	}

	public List<Identifier> getIndustryIdentifiers() {
		return industryIdentifiers;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public List<String> getCategories() {
		return categories;
	}

	public ImageLink getImageLinks() {
		return imageLinks;
	}
}