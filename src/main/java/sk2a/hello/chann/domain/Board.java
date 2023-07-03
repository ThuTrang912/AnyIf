package sk2a.hello.chann.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    private Integer boardId;
    private String title;
    private String userName;
    private Date regDate;
}
