package com.sin1.sellOut.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class SellOutDTO {
	private int no, hit;
	private String title, content, writer, fileName, patid, patage, patgender, patcolor;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date writeDate;
	
	// mutifile 객체를 세팅 할 때 파일명을 가지고와서 저장을 해야한다(fileName)
	private MultipartFile multiFile;
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
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public MultipartFile getMultiFile() {
		return multiFile;
	}
	public void setMultiFile(MultipartFile multiFile) {
		// 작은 이미지는 메모리를 사용해서 저장해서 가져온다
		// 큰 이미지인 경우 임시파일을 이용해서 저장해서 가져온다.
		// 원하는 위치에 원하는 파일을 저장하는 처리가 필요하다.
		this.multiFile = multiFile;
		// 파일명이 중복이 되지않도록 설정을 해줘야한다.
		this.fileName = multiFile.getOriginalFilename();
	}
	
	public String getPatid() {
		return patid;
	}
	public void setPatid(String patid) {
		this.patid = patid;
	}
	public String getPatage() {
		return patage;
	}
	public void setPatage(String patage) {
		this.patage = patage;
	}
	public String getPatgender() {
		return patgender;
	}
	public void setPatgender(String patgender) {
		this.patgender = patgender;
	}
	public String getPatcolor() {
		return patcolor;
	}
	public void setPatcolor(String patcolor) {
		this.patcolor = patcolor;
	}
	@Override
	public String toString() {
		return "SellOutDTO [no=" + no + ", hit=" + hit + ", title=" + title + ", content=" + content + ", writer="
				+ writer + ", fileName=" + fileName + ", patid=" + patid + ", patage=" + patage + ", patgender="
				+ patgender + ", patcolor=" + patcolor + ", writeDate=" + writeDate + ", multiFile=" + multiFile + "]";
	}

}
