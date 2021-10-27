package model.board;

import java.sql.Date;

// VO�� Ŀ�ǵ尴ü�� ���Ǳ� ������ �� ����� ����ϱ� ���ؼ� �˻��뺯�� �߰� 
public class BoardVO {
	//������� 
	private int bid; //BID INT PRIMARY KEY,
	private String mid; //MID VARCHAR(50) NOT NULL,
	private String title; //TITLE VARCHAR(50) NOT NULL,
	private String content; //CONTENT VARCHAR(100) NOT NULL,
	private Date wdate; //WDATE DATE DEFAULT SYSDATE
	
	// �˻��� ���� 
	private String condition;
	private String keyword;
	
	// Getter & Setter
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}	
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	// toString 
	@Override
	public String toString() {
		return "BoardVO [bid=" + bid + ", mid=" + mid + ", title=" + title + ", content=" + content + ", wdate=" + wdate
				+ "]";
	}
	
	

	
	
	
	
	
	
}
