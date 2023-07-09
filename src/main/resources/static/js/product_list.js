const listBox = document.querySelector(".list-box");
let page = 1;
let totalPages = 0;
const itemsPerPage = 12;

async function fetchData() {
  try {
    const response = await fetch(`/board/${page}`);
    const data = await response.json();

    totalPages = data.totalPages;
    const currentPageData = data.data;
    listBox.innerHTML = ""; // Clear the previous data

    currentPageData.forEach((item) => {
      listBox.innerHTML += `
                <div class="item">
                    <img src="/img/notebook.png" alt="" />
                    <p class="name">${item.title}</p>
                    <p class="location">${item.content}</p>
                    <p class="price">Price</p>
                </div>
            `;
    });

    updatePagination(); // Update the pagination links
  } catch (error) {
    console.error(error);
  }
}

const updatePagination = () => {
  let paginationHTML = "";
  let pageGroup = Math.ceil(page / 5);
  let last = pageGroup * 5;

  if (last >= totalPages) {
    last = totalPages;
  }
  let first = last - 4 <= 0 ? 1 : last - 4;

  paginationHTML += `<li class="page-item">
        <a class="page-link" href="#" aria-label="Previous" onclick="moveToPage(${first > 1 ? 1 : 1})">
            <span aria-hidden="true">&lt;&lt;</span>
        </a>
    </li>`;

  paginationHTML += `<li class="page-item">
        <a class="page-link" href="#" aria-label="Previous" onclick="moveToPage(${page - 1 == 0 ? 1 : page - 1})">
            <span aria-hidden="true">&lt;</span>
        </a>
    </li>`;

  for (let i = first; i <= last; i++) {
    paginationHTML += `<li class="page-item ${page == i ? "active current" : ""}">
            <a class="page-link" href="#" onclick="moveToPage(${i})">${i}</a>
        </li>`;
  }

  paginationHTML += `<li class="page-item">
        <a class="page-link" href="#" aria-label="Next" onclick="moveToPage(${page + 1 >= totalPages ? totalPages : page + 1})">
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

updatePagination(); // Initial pagination setup
fetchData(); // Fetch and display initial data
