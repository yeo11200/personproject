package com.sin1.board.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BoardDTO {
	private int no, hit;
	private String title, content, writer;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date writeDate;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	@Override
	public String toString() {
		return "BoardDTO [no=" + no + ", hit=" + hit + ", title=" + title + ", content=" + content + ", writer="
				+ writer + "]";
	}
}
