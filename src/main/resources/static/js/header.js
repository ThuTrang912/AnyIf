const modalBox = document.querySelector(".modal-box");
const modalBack = document.querySelector(".modal-back");
const logIn = document.querySelector(".login");

console.log(logIn);
logIn.addEventListener("click", () => {
  modalBack.style.display = "block";
  modalBox.style.display = "block";
});
