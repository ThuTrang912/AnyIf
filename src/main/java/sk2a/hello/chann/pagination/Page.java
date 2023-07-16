package sk2a.hello.chann.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {
        private List<T> data;
        private int currentPage;
        private int totalPages;
        private int pageSize;
        private long totalItems;
}
