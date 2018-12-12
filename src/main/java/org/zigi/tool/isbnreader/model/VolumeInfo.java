package org.zigi.tool.isbnreader.model;

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

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Identifier> getIndustryIdentifiers() {
		return industryIdentifiers;
	}

	public void setIndustryIdentifiers(List<Identifier> industryIdentifiers) {
		this.industryIdentifiers = industryIdentifiers;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public ImageLink getImageLinks() {
		return imageLinks;
	}

	public void setImageLinks(ImageLink imageLinks) {
		this.imageLinks = imageLinks;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"title\":" + (title == null ? "null" : ("\"" + title + "\"")));
		sb.append("}");
		return sb.toString();
	}

}
