package spring.mvc.kyj.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.kyj.dto.BoardCommentDTO;
import spring.mvc.kyj.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<BoardDTO> boardList(Map<String, Object> map) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);	
		return dao.boardList(map);
	}

	@Override
	public int boardCnt() {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		return dao.boardCnt();
	}

	@Override
	public int boardInsert(BoardDTO dto) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
	    return dao.boardInsert(dto);
	}

	@Override
	public void plusReadCnt(int num) {
		sqlSession.update("spring.mvc.kyj.dao.BoardDAO.plusReadCnt",num);
	}

	@Override
	public BoardDTO getBoardDetail(int num) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
	    return dao.getBoardDetail(num);	
	}
	
	@Override
	public int commentInsert(BoardCommentDTO dto) {
		return sqlSession.insert("spring.mvc.kyj.dao.BoardDAO.commentInsert",dto);
	}

	@Override
	public List<BoardCommentDTO> getCommentList(int board_num) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		return dao.getCommentList(board_num);
	}

}
