package org.zigi.tool.isbnreader.api.google.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.zigi.tool.isbnreader.model.IBook;

public class BookItem implements IBook {
	private String id;
	private String selfLink;
	private VolumeInfo volumeInfo;

	public String getId() {
		return id;
	}

	public String getSelfLink() {
		return selfLink;
	}

	public VolumeInfo getVolumeInfo() {
		return volumeInfo;
	}

	@Override
	public String getLink() {
		return selfLink;
	}

	@Override
	public String getTitle() {
		if (volumeInfo == null)
			return null;
		return volumeInfo.getTitle();
	}

	@Override
	public List<String> getAuthors() {
		if (volumeInfo == null)
			return null;
		return volumeInfo.getAuthors();
	}

	@Override
	public String getPublishedDate() {
		if (volumeInfo == null)
			return null;
		return volumeInfo.getPublishedDate();
	}

	@Override
	public String getDescription() {
		if (volumeInfo == null)
			return null;
		return volumeInfo.getDescription();
	}

	@Override
	public Map<String, String> getIdentifiers() {
		if (volumeInfo == null || volumeInfo.getIndustryIdentifiers() == null)
			return null;

		Map<String, String> result = new HashMap<String, String>();
		for (Identifier i : volumeInfo.getIndustryIdentifiers()) {
			String type = i.getType();
			String value = i.getIdentifier();

			if (type == null || value == null || type.isEmpty() || value.isEmpty())
				continue;

			result.put(type, value);
		}

		if (result.isEmpty())
			return null;

		return result;
	}

	@Override
	public Integer getPageCount() {
		if (volumeInfo == null)
			return null;
		return volumeInfo.getPageCount();
	}

	@Override
	public List<String> getCategories() {
		if (volumeInfo == null)
			return null;
		return volumeInfo.getCategories();
	}

	@Override
	public String getSmallThumbnail() {
		if (volumeInfo == null)
			return null;

		ImageLink images = volumeInfo.getImageLinks();
		if (images == null)
			return null;

		return images.getSmallThumbnail();
	}

	@Override
	public String getThumbnail() {
		if (volumeInfo == null)
			return null;

		ImageLink images = volumeInfo.getImageLinks();
		if (images == null)
			return null;

		return images.getThumbnail();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");

		String id = getId();
		sb.append("\"id\":" + (id == null ? "null" : ("\"" + id + "\"")));

		String link = getLink();
		sb.append(",\"link\":" + (link == null ? "null" : ("\"" + link + "\"")));

		String title = getTitle();
		sb.append(",\"title\":" + (title == null ? "null" : ("\"" + title + "\"")));

		List<String> authors = getAuthors();
		sb.append(",\"authors\":");
		if (authors == null)
			sb.append("null");
		else if (authors.isEmpty())
			sb.append("[]");
		else {
			sb.append("[");
			Iterator<String> iter = authors.iterator();
			String author = iter.next();
			sb.append("\"" + author + "\"");
			while (iter.hasNext()) {
				sb.append(",\"" + iter.next() + "\"");
			}
			sb.append("]");
		}

		String publishedDate = getPublishedDate();
		sb.append(",\"publishedDate\":" + (publishedDate == null ? "null" : ("\"" + publishedDate + "\"")));

		String description = getDescription();
		sb.append(",\"description\":" + (description == null ? "null" : ("\"" + description + "\"")));

		Map<String, String> identifier = getIdentifiers();
		sb.append(",\"identifiers\":");
		if (identifier == null)
			sb.append("null");
		else if (identifier.isEmpty())
			sb.append("[]");
		else {
			sb.append("[");
			Iterator<String> iter = identifier.keySet().iterator();
			String ident = iter.next();
			sb.append("{\"" + ident + "\":\"" + identifier.get(ident) + "\"}");
			while (iter.hasNext()) {
				ident = iter.next();
				sb.append(",{\"" + ident + "\":\"" + identifier.get(ident) + "\"}");
			}
			sb.append("]");
		}

		Integer pages = getPageCount();
		sb.append(",\"pageCount\":" + (pages == null ? "null" : pages));

		List<String> categories = getCategories();
		sb.append(",\"categories\":");
		if (categories == null)
			sb.append("null");
		else if (categories.isEmpty())
			sb.append("[]");
		else {
			sb.append("[");
			Iterator<String> iter = categories.iterator();
			String category = iter.next();
			sb.append("\"" + category + "\"");
			while (iter.hasNext()) {
				sb.append(",\"" + iter.next() + "\"");
			}
			sb.append("]");
		}

		String smallImage = getSmallThumbnail();
		sb.append(",\"smallThumbnail\":" + (smallImage == null ? "null" : ("\"" + smallImage + "\"")));

		String image = getThumbnail();
		sb.append(",\"thumbnail\":" + (image == null ? "null" : ("\"" + image + "\"")));

		sb.append("}");
		return sb.toString();
	}
}
