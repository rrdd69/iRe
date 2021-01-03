package cms.bbs.v1.dto;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class PageResultDTO<DTO, EN> {

    private List<DTO> doList;

    public PageResultDTO(Page<EN> result, Function<EN, DTO> fn){
        doList = result.stream().map(fn).collect(Collectors.toList());
    }

}
