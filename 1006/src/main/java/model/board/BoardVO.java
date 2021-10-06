package model.board;

import java.sql.Date;

public class BoardVO {
	private int id; // ID INT PRIMARY KEY, 
	private String title; // TITLE VARCHAR(30),
	private String writer; // WRITER VARCHAR(15),
	private String content; //CONTENT VARCHAR(100),
	private Date wdate; // WDATE DATE DEFAULT SYSDATE
	
	// Getter & Setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	
	// toString 
	@Override
	public String toString() {
		return "BoardVO [id=" + id + ", title=" + title + ", writer=" + writer + ", content=" + content + ", wdate="
				+ wdate + "]";
	}
	
	

}
