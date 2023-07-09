package sk2a.hello.chann.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {
        private List<T> data;       // List containing the current page's data
        private int currentPage;    // Number indicating the current page
        private int totalPages;     // Total number of pages
        private int pageSize;       // Number of items per page (e.g., 12)
        private long totalItems;    // Total number of items

        public Page(int i) {
        }
}
