package spring.mvc.kyj.common;

/*
페이지 결과 ]
1 2 3 4 5 6 7 8 9 10 [다음]
[이전] 11 12 13 14 15 16 17 18 19 20 [다음]
[이전] 21 22 23 24 25 26 27 28 29 30 [다음]
[이전] 31 32 33 34 35 36 37 38 39 40 [다음]
      
      
[url ==> /boardList.ad]
int start = paging.getStartRow();
int end = paging.getEndRow();

List<BoardDTO> list = dao.boardList(start, end);
      
1페이지 (startRow 1 ~ endRow 10) ============================

pageNum : 1
currentPage : 1
total ==> 994
startRow : 1
endRow : 10
pageCount : 100
startPage : 1
endPage : 10
prev : 0
next : 11

2페이지 (startRow 11 ~ endRow 20) ============================
*/


public class Pagination {
	private int pageSize=10;	//화면에 보여질 게시글의 갯수를 지정
	private int count=0;		//전체글의 갯수를 저장하는 변수
	private int number=0;		//페이지 번호
	private String pageNum;
	
	private int startRow;		//페이자당 시작번호
	private int endRow;			//페이지당 끝번호
	
	private int currentPage;
	private int pageCount;
	private int startPage;
	private int pageBlock;
	private int endPage;
	
	private int prev;		
	private int next;		
	
	public Pagination() {}
	
	public Pagination(String pageNum) {
		//맨처음 boardList.jsp를 클릭하거나, 수정 삭제등 다른 게시글에서 페이지로 넘어 올때 pageNum이 없는 경우 null 처리
		if(pageNum==null) {
			pageNum="1";
		}
		
		this.pageNum=pageNum;
		
		currentPage=Integer.parseInt(pageNum);
		
	}

	public void setTotalCount(int count) {
		this.count=count;
		
		startRow = (currentPage - 1) * pageSize + 1;
		endRow = currentPage * pageSize;
		
		this.number = count - (currentPage - 1) * pageSize;
		
		//페이지 계산
		pageCalculator();
	}
	
	public void pageCalculator() {
		if(count>0) {
			pageCount =count / pageSize + (count % pageSize == 0 ? 0 : 1);
			
			startPage = 1;
			
			if(currentPage % 10 != 0) {
				startPage = (int)(currentPage/10) * 10 + 1;			
			} else {
				startPage = ((int) (currentPage/10)-1) * 10 + 1;
			}
			
			pageBlock=10;
			endPage = startPage + pageBlock - 1;
			if(endPage>pageCount) endPage=pageCount;
			
			//이전
			if(startPage>pageSize) prev=startPage - 10;
			//다음
			if(endPage<pageCount) next=startPage + 10;
			
		}
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getPageBlock() {
		return pageBlock;
	}

	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPrev() {
		return prev;
	}

	public void setPrev(int prev) {
		this.prev = prev;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "Pagination [pageSize=" + pageSize + ", count=" + count + ", number=" + number + ", pageNum=" + pageNum
				+ ", startRow=" + startRow + ", endRow=" + endRow + ", currentPage=" + currentPage + ", pageCount="
				+ pageCount + ", startPage=" + startPage + ", pageBlock=" + pageBlock + ", endPage=" + endPage
				+ ", prev=" + prev + ", next=" + next + "]";
	}
	
}
