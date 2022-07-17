package org.sample.mapper;

import org.apache.ibatis.annotations.Select;
import org.sample.domain.BoardVO;

import java.util.List;

public interface BoardMapper {
   // @Select("select * from  bootex.tbl_board where bno > 0")
    public List<BoardVO> getList();

    public void insert(BoardVO board);

    public BoardVO read(Long bno);

    public int delete(Long bno);

    public int update(BoardVO board);
}
