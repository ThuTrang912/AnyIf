const listBox = document.querySelector(".list-box");
let page = getPageFromURL(); // Lấy số trang từ URL
let totalPages = 0;
const itemsPerPage = 12;
let currentSearch = "";
let currentCategory = "";
let currentPrice = "";
let currentTime = "";

function fetchData() {
  const search = document.getElementById("nameSearch").value;
  const category = document.getElementById("categorySelect").value;
  const price = document.getElementById("priceSelect").value;
  const time = document.getElementById("timeSelect").value;

  if (
      search === currentSearch &&
      category === currentCategory &&
      price === currentPrice &&
      time === currentTime
  ) {
    return; // Do not fetch data if the filters have not changed
  }

  currentSearch = search;
  currentCategory = category;
  currentPrice = price;
  currentTime = time;

  const url = `/api/board/${page}?search=${search}&category=${category}&price=${price}&time=${time}`;

  fetch(url)
      .then((response) => response.json())
      .then((data) => {
        const currentPage = data.currentPage;
        const totalPageCount = data.totalPages;
        const currentPageData = data.data;
        listBox.innerHTML = ""; // Clear the previous data

        currentPageData.forEach((item) => {
          listBox.innerHTML += `
          <div class="item">
            <img th:src="@{/images/${item.serverFileName}}" alt="" />
            <p class="name">${item.productName}</p>
            <p class="location">${item.productDetail}</p>
            <p class="price">${item.productCost}</p>
          </div>
        `;
        });

        totalPages = totalPageCount; // Update the total pages
        updatePagination(currentPage, totalPageCount); // Update the pagination links
      })
      .catch((error) => {
        console.error(error);
      });
}

const updatePagination = (page, totalPages) => {
  let paginationHTML = "";
  let pageGroup = Math.ceil(page / 5);
  let last = pageGroup * 5;

  if (last >= totalPages) {
    last = totalPages;
  }
  let first = last - 4 <= 0 ? 1 : last - 4;

  paginationHTML += `<li class="page-item">
      <a class="page-link" href="#" aria-label="Previous" onclick="moveToPage(${
      first > 1 ? 1 : 1
  })">
        <span aria-hidden="true">&lt;&lt;</span>
      </a>
    </li>`;

  paginationHTML += `<li class="page-item">
      <a class="page-link" href="#" aria-label="Previous" onclick="moveToPage(${
      page - 1 == 0 ? 1 : page - 1
  })">
        <span aria-hidden="true">&lt;</span>
      </a>
    </li>`;

  for (let i = first; i <= last; i++) {
    paginationHTML += `<li class="page-item ${
        page == i ? "active current" : ""
    }">
        <a class="page-link" href="#" onclick="moveToPage(${i})">${i}</a>
      </li>`;
  }

  paginationHTML += `<li class="page-item">
      <a class="page-link" href="#" aria-label="Next" onclick="moveToPage(${
      page + 1 >= totalPages ? totalPages : page + 1
  })">
        <span aria-hidden="true">&gt;</span>
      </a>
    </li>`;

  paginationHTML += `<li class="page-item">
      <a class="page-link" href="#" aria-label="Next" onclick="moveToPage(${totalPages})">
        <span aria-hidden="true">&gt;&gt;</span>
      </a>
    </li>`;

  document.querySelector(".pagination").innerHTML = paginationHTML;
};

function moveToPage(pageNum) {
  page = pageNum;
  window.scrollTo({ top: 0, behavior: "smooth" });
  fetchData();

  const newUrl = `${window.location.origin}/product/${pageNum}`;
  history.pushState({ page: pageNum }, "", newUrl);
}

function getPageFromURL() {
  const urlParts = window.location.pathname.split("/");
  const pageString = urlParts[urlParts.length - 1];
  const page = parseInt(pageString);
  return isNaN(page) ? 1 : page;
}

window.addEventListener("popstate", (event) => {
  if (event.state && event.state.page) {
    page = event.state.page;
    fetchData();
    updatePagination(page, totalPages);
  }
});

function searchProducts() {
  page = 1;
  fetchData();
}

function clearFilters() {
  document.getElementById("searchInput").value = "";
  document.getElementById("categorySelect").value = "";
  document.getElementById("priceSelect").value = "";
  document.getElementById("timeSelect").value = "";
  currentSearch = ""; // Reset the current filters
  currentCategory = "";
  currentPrice = "";
  currentTime = "";
  searchProducts();
}

document.addEventListener("DOMContentLoaded", () => {
  fetchData();

  document.getElementById("searchInput").addEventListener("input", searchProducts);
  document.getElementById("categorySelect").addEventListener("change", fetchData);
  document.getElementById("priceSelect").addEventListener("change", fetchData);
  document.getElementById("timeSelect").addEventListener("change", fetchData);
});
