package cms.bbs.v1.service;

import cms.bbs.v1.dto.BoardDTO;
import cms.bbs.v1.entity.Board;
import cms.bbs.v1.entity.Member;

public interface BoardService {

    Long register(BoardDTO dto);

    default Board dtoToEntity(BoardDTO dto){

        Member member = Member.builder().email(dto.getWriterEmail()).build();

        Board board = Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();

        return board;

    }
}
