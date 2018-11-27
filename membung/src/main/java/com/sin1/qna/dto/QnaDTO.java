package com.sin1.qna.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class QnaDTO {
	private int no, hit;
	private String title, content, writer;
	private int refNo, ordNo, levNo, pareantNo;
	// no : 게시판번호, rno : 댓글번호, refNo : 그룹번호, ordNo : 대댓글, levNo : 댓글의 깊이, parentNo 부모글(댓글)
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
	public int getRefNo() {
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
	
	public int getPareantNo() {
		return pareantNo;
	}
	
	public void setPareantNo(int pareantNo) {
		this.pareantNo = pareantNo;
	}
	
	public Date getWriteDate() {
		return writeDate;
	}
	
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
	@Override
	public String toString() {
		return "QnaDTO [no=" + no + ", hit=" + hit + ", title=" + title + ", refNo=" + refNo
				+ ", ordNo=" + ordNo + ", levNo=" + levNo + ", pareantNo=" + pareantNo + ", writeDate=" + writeDate
				+ "]";
	}
}
