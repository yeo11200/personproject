package com.sin1.find.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ReplyFindDTO {
	private int no, rno;
	// no : 게시판번호, rno : 댓글번호, refNo : 그룹번호, ordNo : 대댓글, levNo : 댓글의 깊이, parentNo 부모글(댓글)
	private String content, writer;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date writeDate;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
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
		return "ReplySellDTO [no=" + no + ", rno=" + rno + ", content=" + content + ", writer=" + writer
				+ ", writeDate=" + writeDate + "]";
	}
}
