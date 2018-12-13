package org.zigi.tool.isbnreader.model;

import java.util.List;
import java.util.Map;

public interface IBook {
	public String getId();

	public String getLink();

	public String getTitle();

	public List<String> getAuthors();

	public String getPublishedDate();

	public String getDescription();

	public Map<String, String> getIdentifiers();

	public Integer getPageCount();

	public List<String> getCategories();

	public String getSmallThumbnail();

	public String getThumbnail();
}
