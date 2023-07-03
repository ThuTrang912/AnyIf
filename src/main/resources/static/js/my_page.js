const stars = document.querySelectorAll(".star");
const products = document.querySelectorAll(".product-list img");
const preButton = document.querySelector(".preButton");
const nextButton = document.querySelector(".nextButton");
const productListWidth = document.querySelector(".product-list").clientWidth;

preButton.addEventListener("click", () => {
  console.log("clickOK");
  products.forEach((item) => {
    const currentLeft = parseFloat(getComputedStyle(item).left);
    const newLeft = currentLeft - 120;
    item.style.left = `${newLeft}px`;
    if (newLeft > productListWidth || newLeft + item.offsetWidth < 0) {
      item.style.visibility = "hidden";
    } else {
      item.style.visibility = "visible";
    }
  });
});

nextButton.addEventListener("click", () => {
  console.log(productListWidth);
  products.forEach((item) => {
    const currentLeft = parseFloat(getComputedStyle(item).left);
    const newLeft = currentLeft + 120;
    item.style.left = `${newLeft}px`;
    if (newLeft > productListWidth || newLeft + item.offsetWidth < 0) {
      item.style.visibility = "hidden";
    } else {
      item.style.visibility = "visible";
    }
  });
});
