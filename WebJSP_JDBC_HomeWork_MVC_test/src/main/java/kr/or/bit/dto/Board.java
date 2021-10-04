package kr.or.bit.dto;
import java.util.Date;

/*
--TABLE 설계 (비인증형 답변(계층형)  게시판)
CREATE TABLE testboard(
  idx NUMBER PRIMARY KEY , -- 글번호 (DB : 오라클(sequence 객체) , Ms-sql, Mysql(테이블 종속 자동증가)
  writer VARCHAR2(30) NOT NULL , --글쓴이 (회원전용: 로그인한 ID , 별칭     비회원용: 입력값 )
  --pwd VARCHAR2(20) NOT NULL , --회원전용(x)  , 비회원전용(0 : 수정 ,삭제 )
  subject VARCHAR2(50) NOT NULL, --글제목
  content VARCHAR2(100) NOT NULL, --글내용
  writedate DATE DEFAULT SYSDATE, -- 작성일
  readnum NUMBER DEFAULT 0 , --글조회 (insert default 0)
  filename VARCHAR2(200),  --파일명 (test.txt)
  filesize NUMBER ,              --파일크기(byte)
  homepage VARCHAR2(50) ,
  email VARCHAR2(100), --필수 입력 사항 (not null) null값을 허용
  --답변형 게시판 구축
  refer   NUMBER DEFAULT 0 , -- 답변형 게시판 (참조글 or 글의 그룹번호)
  depth   NUMBER DEFAULT 0,  -- 답변형 게시판(depth(글의 깊이 , 들여쓰기)
  step    NUMBER DEFAULT 0   -- 답변형 게시판 (글의 정렬 순서 : 답글정렬순서)
);
*/

public class Board {
	//not null (필수 입력)
	private int idx;
	private String writer;
	private String subject;
	private String content;

	private Date writedate; //default SYSDATE
	private int readnum;    //default 0
	
	//부가 입력 사항	
	private String filename;
	private int filesize;
	private String homepage;
	private String email;

	//계층형 (답글)
	private int refer;//글의 묶음
	private int depth;//글의 들여쓰기
	private int step;//글의 순서
	
	public Board(int idx, String writer, String subject, String content, Date writedate, int readnum, String filename,
			int filesize, String homepage, String email, int refer, int depth, int step) {
		super();
		this.idx = idx;
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.writedate = writedate;
		this.readnum = readnum;
		this.filename = filename;
		this.filesize = filesize;
		this.homepage = homepage;
		this.email = email;
		this.refer = refer;
		this.depth = depth;
		this.step = step;
	}

	public Board() {
		// TODO Auto-generated constructor stub
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

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}

	public int getReadnum() {
		return readnum;
	}

	public void setReadnum(int readnum) {
		this.readnum = readnum;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getFilesize() {
		return filesize;
	}

	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRefer() {
		return refer;
	}

	public void setRefer(int refer) {
		this.refer = refer;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	@Override
	public String toString() {
		return "Board [idx=" + idx + ", writer=" + writer + ", subject=" + subject + ", content=" + content
				+ ", writedate=" + writedate + ", readnum=" + readnum + ", filename=" + filename + ", filesize="
				+ filesize + ", homepage=" + homepage + ", email=" + email + ", refer=" + refer + ", depth=" + depth
				+ ", step=" + step + "]";
	}
	
}
