package kr.or.bit.dto;

/*
CREATE TABLE testboard(
  idx NUMBER PRIMARY KEY , -- 글번호 (DB : 오라클(sequence 객체) , Ms-sql, Mysql(테이블 종속 자동증가)
  writer NVARCHAR2(30) NOT NULL , --글쓴이 (회원전용: 로그인한 ID , 별칭     비회원용: 입력값 )
  subject NVARCHAR2(50) NOT NULL, --글제목
  content NVARCHAR2(100) NOT NULL, --글내용
  writedate DATE DEFAULT SYSDATE -- 작성일
);
*/

public class Board {
	private int idx;
	private String writer;
	private String subject;
	private String content;
	private String writedate;
	
	public Board() {
		super();
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWritedate() {
		return writedate;
	}

	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}

	@Override
	public String toString() {
		return "Board [idx=" + idx + ", writer=" + writer + ", subject=" + subject + ", content=" + content
				+ ", writedate=" + writedate + "]";
	}
}
