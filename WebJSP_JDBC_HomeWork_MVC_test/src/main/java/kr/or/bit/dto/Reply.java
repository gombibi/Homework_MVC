

package kr.or.bit.dto;
import java.util.Date;


public class Reply {
	private int no;
	private String writer;
	private String content;
	private Date writedate;
	private int idx_fk;
	
	public Reply() {
	}

	public Reply(int no, String writer, String content, Date writedate, int idx_fk) {
		super();
		this.no = no;
		this.writer = writer;
		this.content = content;
		this.writedate = writedate;
		this.idx_fk = idx_fk;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}

	public int getIdx_fk() {
		return idx_fk;
	}

	public void setIdx_fk(int idx_fk) {
		this.idx_fk = idx_fk;
	}
	
}