package com.sin1.board.dto;

import java.util.Date;



import org.springframework.format.annotation.DateTimeFormat;

public class ReplyBoardDTO {
	private int no, rno;//, refNo, ordNo, levNo, parentNo, rno;
// no : 게시판번호, rno : 댓글번호, refNo : 그룹번호, ordNo : 대댓글, levNo : 댓글의 깊이, parentNo 부모글(댓글)
	private String content, writer;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date writeDate;
	public int getNo() {
		return no;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public void setNo(int no) {
		this.no = no;
	}
/*	public int getRefNo() {
		return refNo;
	}
	public void setRefNo(int refNo) {
		this.refNo = refNo;
	}
	public int getOrdNo() {
		return ordNo;
	}
	public void setOrdNo(int ordNo) {
		this.ordNo = ordNo;
	}
	public int getLevNo() {
		return levNo;
	}
	public void setLevNo(int levNo) {
		this.levNo = levNo;
	}
	public int getParentNo() {
		return parentNo;
	}
	public void setParentNo(int parentNo) {
		this.parentNo = parentNo;
	}
*/	
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
		return "ReplyBoardDTO [no=" + no + ", rno" + rno + ", content=" + content +
				", writer=" + writer + ", writeDate=" + writeDate
				+ "]";
	}
}
