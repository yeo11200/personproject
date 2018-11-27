package com.sin1.util;

public class ReplyPageObject {
	
	// 현재 페이지를 DB에서 가져올 떄 필요한 정보를 가지고 온다.
	private int page;
	// 현재 페이지
	private int perPageNum;
	// 페이지당 보여지는 글의 갯수 ex) 5 -> 5개의 글만 보여줌 
	private int startRow, endRow;
	// 현재 페이지의 시작번호, 끝번호
	
	private int no;
	
	// JSP 화면에 하단부분 페이지 표시를 할 때 필요한 정보
	private int perGroupPageNum;
	// 기본값을 10으로 생성자에 셋팅한다.
	private int startPage;
	private int endPage;
	private int totalPage;
	private int totalRow;
	// DB에서 구해준다.
	
	// 검색에 필요한 변수를 선언하는 부분
	private String key;
	private String word;
	
	// 공지사항에서 현재를 적용시키는 변수 -> period
	// per : 현재공지, old : 지난공지, res : 예약공지, all : 전체공지
	private String period;
	
	// 메시지를 처리하기 위한 변수
	// 받는 사람의 id를 적어주는 곳
	private String accepter;
	
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	// 초기화 시켜주기위해서 생성자를 만든다.
	// Spring에서는 파라메터값을 전달 받을 때 기본생성자와 setter()를 이용해서 데이터를 전달 받는다.
	public ReplyPageObject() {
		// 처음 리스트로 들어올 때는 데이터가 안 넘어오니까 초기값을 1로 해서 첫 페이지를 1페이지로 세팅을 한다.
		this.page = 1;
		// 한 페이지당 10개의 글이 보이도록 세팅을 한다.
		this.perPageNum = 5;
		// jsp하단부분에 몇개의 페이지를 표시할 지 정한다.
		perGroupPageNum = 5;
		
		// 기본적으로 차즌 공지분류 -> 현재공지(pre)로 세팅을 해준다.
		this.period = "per";
	}
	
	// 오버로딩한 생성자
	public ReplyPageObject(int page, int perPageNum) {
		this.page = page;
		this.perPageNum = perPageNum;
		// 시작 번호와 끝 번호를 계산한다.
		// 현재페이지의 이전 페이지 까지 데이터를 skip시키고 그 다음 번호시작 번호로 한다.
		startRow = (page-1)*perPageNum + 1;
		endRow = startRow + perPageNum - 1;
		
		// jsp 하단 부분에 몇개의 페이지를 표시할 지 정하게 된다.
		perGroupPageNum = 10;
		System.out.println("pageObject(페이지, 페이지당 글수");
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	// setStartRow()와 setEndRow()를 계산에 의해서 결정 되어서 받지 않아서 만들지 않는다.
	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public int getPerGroupPageNum() {
		return perGroupPageNum;
	}

	public void setPerGroupPageNum(int perGroupPageNum) {
		this.perGroupPageNum = perGroupPageNum;
	}

	public int getStartPage() {
		return startPage;
	}
	
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalRow() {
		return totalRow;
	}

	// 페이지에 따른 데이터의 startRow와 endRow, totalPage, startPage, endPage
	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
		
		// 시작번호와 끝 번호를 계산
		// 현재 페이지의 이전 페이지까지 데이터를 skip시키고 그 다음 번호 시작 번호로 시작한다.
		startRow = (page-1)*perPageNum + 1;
		endRow = startRow + perPageNum - 1;
		
		// 리스트 화면하단부분에 나타내는 페이지를 처리하기 위한 데이터들을 계산 
		// 전체 페이지를 계산 할 수 있다.
		totalPage = (totalRow-1)/perPageNum + 1;
		
		// startPage, endPage
		startPage = (page-1)/perGroupPageNum * perGroupPageNum + 1;
		endPage = startPage + perGroupPageNum - 1;
		
		// endPage가 totalPage를 넘지 않도록 한다.
		if(endPage > totalPage) {
			// endPage가 더 클 경우 그게 totalPage로 지정
			endPage = totalPage;
		}
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getAccepter() {
		return accepter;
	}

	public void setAccepter(String accepter) {
		this.accepter = accepter;
	}

	@Override
	public String toString() {
		return "PageObject [page=" + page + ", perPageNum=" + perPageNum + ", startRow=" + startRow + ", endRow="
				+ endRow + ", perGroupPageNum=" + perGroupPageNum + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", totalPage=" + totalPage + ", totalRow=" + totalRow + ", key=" + key + ", word=" + word
				+ ", period=" + period + ", accepter=" + accepter + "]";
	}
}
