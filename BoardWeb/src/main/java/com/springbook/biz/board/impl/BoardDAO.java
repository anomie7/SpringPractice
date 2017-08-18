package com.springbook.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAO.class);

	private final String BOARD_INSERT = "insert into board(seq, title, writer, content)"
			+ " values((select nvl(max(seq), 0)+1 from board), ?, ?, ?)";
	private final String BOARD_UPDATE = "update board set title = ?, content = ? where seq = ?";
	private final String BOARD_DELETE = "delete board where seq = ?";
	private final String BOARD_GET = "select * from board where seq = ?";
	private final String BOARD_LIST = "select * from board order by seq desc";

	public void insertBoard(BoardVO vo) {
		logger.info("====> JDBC로 insertBoard() 기능 처리");
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}

	public void updateBoard(BoardVO vo) {
		logger.info("====> JDBC로 updateBoard() 기능 처리");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}

	public void deleteBoard(BoardVO vo) {
		logger.info("===> JDBC로 deleteBoard() 기능 처리");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}

	public BoardVO getBoard(BoardVO vo) {
		logger.info("===> JDBC로 getBoard() 기능 처리");
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}

	public List<BoardVO> getBoardList() {
		logger.info("===> JDBC로 getBoardList() 기능 처리");
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}
} 

class BoardRowMapper implements RowMapper<BoardVO>{
	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException{
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("SEQ"));
		board.setTitle(rs.getString("TITLE"));
		board.setWriter(rs.getString("WRITER"));
		board.setContent(rs.getString("CONTENT"));
		board.setRegDate(rs.getDate("REGDATE"));
		board.setCnt(rs.getInt("CNT"));
		return board;
	}

}