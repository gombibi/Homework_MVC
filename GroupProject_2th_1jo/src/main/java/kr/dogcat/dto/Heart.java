package kr.dogcat.dto;

public class Heart {
	/*create table heartrec(
	  board_num number REFERENCES Pboard(pbnum),
	  rec_email nvarchar2(50) REFERENCES Member(email)
	);*/
	
	int hnum; //좋아요 식별자
	int board_num; //좋아요 대상 게시물 식별자 Pboard(pbnum)
	String rec_email; //좋아요 한 유저의 식별자 Member(email)
	
	
	public Heart() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Heart(int hnum, int board_num, String rec_email) {
		super();
		this.hnum = hnum;
		this.board_num = board_num;
		this.rec_email = rec_email;
	}


	public int getHnum() {
		return hnum;
	}


	public void setHnum(int hnum) {
		this.hnum = hnum;
	}


	public int getBoard_num() {
		return board_num;
	}


	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}


	public String getRec_email() {
		return rec_email;
	}


	public void setRec_email(String rec_email) {
		this.rec_email = rec_email;
	}
	
	
	
	
}
