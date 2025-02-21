package blog;

import java.io.Serializable;

public class Cmt implements Serializable {
	
	private static final long serialVersionUID = 849646315416L;
	
	private int cmtId;
	private String cmtName;
	private String cmtCmt;
	private int cmtPostId;
	
	public Cmt() {
	}

	public Cmt(int cmtId, String cmtName, String cmtCmt, int cmtPostId) {
		this.cmtId = cmtId;
		this.cmtName = cmtName;
		this.cmtCmt = cmtCmt;
		this.cmtPostId = cmtPostId;
	}

	public int getCmtId() {
		return cmtId;
	}

	public void setCmtId(int cmtId) {
		this.cmtId = cmtId;
	}

	public String getCmtName() {
		return cmtName;
	}

	public void setCmtName(String cmtName) {
		this.cmtName = cmtName;
	}

	public String getCmtCmt() {
		return cmtCmt;
	}

	public void setCmtCmt(String cmtCmt) {
		this.cmtCmt = cmtCmt;
	}

	public int getCmtPostId() {
		return cmtPostId;
	}

	public void setCmtPostId(int cmtPostId) {
		this.cmtPostId = cmtPostId;
	}

	@Override
	public String toString() {
		return "Cmt [cmtId=" + cmtId + ", cmtName=" + cmtName + ", cmtCmt=" + cmtCmt + ", cmtPostId=" + cmtPostId + "]";
	}
	

	
	

}
