package spring.mvc.kyj.dto;

import java.sql.Date;

public class BoardDTO {

	private int num;	//글번호
	private String title;	//글제목
	private String content;	//글내용
	private String writer;	//작성자
	private String password;	//수정, 삭제용 비밀번호
	private int readCnt;	//조회수
	private Date regDate;	//작성일
	private int commentCount;	//댓글갯수
	private String pdImg;
	
	public BoardDTO() { }

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getReadCnt() {
		return readCnt;
	}

	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public String getPdImg() {
		return pdImg;
	}

	public void setPdImg(String pdImg) {
		this.pdImg = pdImg;
	}

	@Override
	public String toString() {
		return "BoardDTO [num=" + num + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", password=" + password + ", readCnt=" + readCnt + ", regDate=" + regDate + ", commentCount="
				+ commentCount + ", pdImg=" + pdImg + "]";
	}

}
