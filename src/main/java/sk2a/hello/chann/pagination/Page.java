package sk2a.hello.chann.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {
        private List<T> data;       //list chứa các page
        private int currentPage;    //số chỉ page hiện tại
        private int totalPages;     //tổng số page
        private int pageSize;       //trong 1 page chứa bao nhiên trang (12)
        private long totalItems;    //tổng số phần tử
        private Integer navSize;

        private Integer totalCnt;

        public Page(Integer totalCnt) {
                this.totalCnt = totalCnt;
        }



}
