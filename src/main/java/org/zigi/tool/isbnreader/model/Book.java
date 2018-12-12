package org.zigi.tool.isbnreader.model;

import java.util.Iterator;
import java.util.List;

/**
 * Model class for book
 * 
 * @author zigi
 *
 */
public class Book {
	private String kind;
	private Integer totalItems;
	private List<BookItem> items;

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Integer getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}

	public List<BookItem> getItems() {
		return items;
	}

	public void setItems(List<BookItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"kind\":" + ((kind == null) ? "null" : ("\"" + kind + "\"")));
		sb.append(",\"totalItems\":" + ((totalItems == null) ? "null" : totalItems));
		sb.append(",\"items\":[");

		if (items != null) {
			Iterator<BookItem> iterator = items.iterator();
			boolean isNext = true;
			do {
				sb.append(iterator.next());
				isNext = iterator.hasNext();
				if (isNext)
					sb.append(",");
			} while (isNext);
		}
		sb.append("]}");
		return sb.toString();
	}
}
