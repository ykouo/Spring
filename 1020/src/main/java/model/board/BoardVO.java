package model.board;

import java.sql.Date;

// VO가 커맨드객체로 사용되기 때문에 이 기능을 사용하기 위해서 검색용변수 추가 
public class BoardVO {
	//멤버변수 
	private int bid; //BID INT PRIMARY KEY,
	private String mid; //MID VARCHAR(50) NOT NULL,
	private String title; //TITLE VARCHAR(50) NOT NULL,
	private String content; //CONTENT VARCHAR(100) NOT NULL,
	private Date wdate; //WDATE DATE DEFAULT SYSDATE
	
	// 검색용 변수 
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
