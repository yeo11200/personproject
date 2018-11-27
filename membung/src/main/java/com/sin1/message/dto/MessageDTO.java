package com.sin1.message.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * 메시지의 데이터를 담아서 전달하는 객체
 * 메시지번호, 보내는 사람의 아이디, 보내는 사람의 이름
 * 받는 사람의 아이디, 받는 사람의 이름, 보낸 날짜, 받은 날짜, 메시지
 */

public class MessageDTO {

	private int no;
	// mapper에 sender name을 가지고 있기에 DTO에 없으면 에러가 발생을 한다.
	private String sender, senderName, accepter, accepterName;
	// 날짜형 데이터를 입력 받아서 넣은 때 필요한 패턴 지정 
	// - 문자열로 날짜가 입력되므로 자동으로 날짜형으로 변환해 주도록 지정한다.
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date sendDate, acceptDate;
	private String content;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}

	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getAccepter() {
		return accepter;
	}
	public void setAccepter(String accepter) {
		this.accepter = accepter;
	}
	public String getAccepterName() {
		return accepterName;
	}
	public void setAccepterName(String accepterName) {
		this.accepterName = accepterName;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public Date getAcceptDate() {
		return acceptDate;
	}
	public void setAcceptDate(Date acceptDate) {
		this.acceptDate = acceptDate;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "MessageDTO [no=" + no + ", sender=" + sender + ", senderName=" + senderName + ", accepter=" + accepter
				+ ", accepterName=" + accepterName + ", sendDate=" + sendDate + ", acceptDate=" + acceptDate
				+ ", content=" + content + "]";
	}
	
}
