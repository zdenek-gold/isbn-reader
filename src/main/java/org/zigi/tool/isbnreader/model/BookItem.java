package org.zigi.tool.isbnreader.model;

public class BookItem {
	private String kind;
	private String id;
	private String etag;
	private String selfLink;
	private VolumeInfo volumeInfo;

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEtag() {
		return etag;
	}

	public void setEtag(String etag) {
		this.etag = etag;
	}

	public String getSelfLink() {
		return selfLink;
	}

	public void setSelfLink(String selfLink) {
		this.selfLink = selfLink;
	}

	public VolumeInfo getVolumeInfo() {
		return volumeInfo;
	}

	public void setVolumeInfo(VolumeInfo volumeInfo) {
		this.volumeInfo = volumeInfo;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"kind\":" + (kind == null ? "null" : ("\"" + kind + "\"")));
		sb.append(",\"id\":" + (id == null ? "null" : ("\"" + id + "\"")));
		sb.append(",\"etag\":" + (etag == null ? "null" : ("\"" + etag + "\"")));
		sb.append(",\"selfLink\":" + (selfLink == null ? "null" : ("\"" + selfLink + "\"")));
		sb.append(",\"volumeInfo\":" + (volumeInfo == null ? "{}" : volumeInfo.toString()));
		sb.append("}");
		return sb.toString();
	}
}
