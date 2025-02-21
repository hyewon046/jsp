package blog;

import java.io.Serializable;

public class Tag implements Serializable {
	
	private static final long serialVersionUID = 8641516541L;
	
	private int tagId;
	private String tagName;
	private int tagPostId;
	
	public Tag() {
	}

	public Tag(int tagId, String tagName, int tagPostId) {
		this.tagId = tagId;
		this.tagName = tagName;
		this.tagPostId = tagPostId;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public int getTagPostId() {
		return tagPostId;
	}

	public void setTagPostId(int tagPostId) {
		this.tagPostId = tagPostId;
	}

	@Override
	public String toString() {
		return "Tag [tagId=" + tagId + ", tagName=" + tagName + ", tagPostId=" + tagPostId + "]";
	}
	
	

	
	
	
	
	
	

}
