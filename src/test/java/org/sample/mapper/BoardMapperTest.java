package org.sample.mapper;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.sample.config.RootConfig.class})
@Log4j
public class BoardMapperTest {

    @Autowired
    private BoardMapper mapper;

    @Test
    public void testGetList(){
        mapper.getList().forEach(b -> log.info(b));
    }

    @Test
    public void testInsert(){
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("asdads");
        boardVO.setContent("새글");
        boardVO.setWriter("gogo");
        mapper.insert(boardVO);
        log.info(boardVO);
    }

    @Test
    public void read(){
        BoardVO read = mapper.read(5L);
        log.info(read);
    }

    @Test
    public void del(){
        log.info("del cnt: "+ mapper.delete(8L));
    }
    @Test
    public void update(){
        BoardVO board = new BoardVO();
        board.setBno(5L);
        board.setTitle("updated");
        board.setWriter("writer");
        board.setContent("qwerwgasd");

        int cnt = mapper.update(board);
        log.info(cnt);
    }
}
