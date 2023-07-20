const listBox = document.querySelector(".list-box");
const itemsPerPage = 12;
let page = 1;
let totalPages = 0;

async function fetchData() {
  try {
    const search = $("#nameSearch").val();
    const category = $("#categorySelect").val();
    const price = $("#priceSelect").val();
    const time = $("#timeSelect").val();

    const url = `/api/board/${page}?search=${search}&category=${category}&price=${price}&time=${time}`;
    const response = await fetch(url);
    const data = await response.json();
    const currentPageData = data.data;
    listBox.innerHTML = ""; // Clear previous data

    if (currentPageData.length > 0) {
      currentPageData.forEach((item) => {
        listBox.innerHTML += `
          <div class="item">
            <img src="/images/${item.serverFileName}" alt="" />
            <p class="name">${item.productName}</p>
            <p class="location">${item.productDetail}</p>
            <p class="price">${item.productCost}</p>
          </div>
        `;
      });
    } else {
      listBox.innerHTML = '<p>No results found.</p>';
    }

    totalPages = data.totalPages; // Update the total number of pages
    updatePagination(page, totalPages); // Update pagination links
  } catch (error) {
    // Error handling
    console.error(error);
  }
}

const updatePagination = (page, totalPages) => {
  let paginationHTML = "";
  let pageGroup = Math.ceil(page / 5);
  let last = pageGroup * 5;

  if (last >= totalPages) {
    last = totalPages;
  }
  let first = last - 4 <= 0 ? 1 : last - 4;

  paginationHTML = `<li class="page-item">
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
    }"><a class="page-link" href="#" onclick="moveToPage(${i})">${i}</a></li>`;
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
}

// Attach event listeners to the search button and filter dropdowns
$(document).on("click", "#searchButton", function () {
  page = 1;
  fetchData();
});
$(document).on("change", "#categorySelect, #priceSelect, #timeSelect", function () {
  page = 1;
  fetchData();
});
$(document).on("click", "#clearFiltersButton", function () {
  $("#nameSearch").val("");
  $("#categorySelect").val("");
  $("#priceSelect").val("");
  $("#timeSelect").val("");
  fetchData();
});

fetchData();
