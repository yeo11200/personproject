package com.sin1.notice.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class NoticeDTO{
	private int no;
	private String title, content;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date writeDate, startDate, endDate;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "NoticeDTO [no=" + no + ", title=" + title + ", content=" + content + ", writeDate=" + writeDate
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
}
