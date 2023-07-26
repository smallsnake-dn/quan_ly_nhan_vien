let bang_luong = document.querySelector(".bang_luong");
let table_luong = document.querySelector(".table_luong");
let table_cham_cong = document.querySelector(".table_cham_cong");
let btn_luong = document.querySelector(".option_button .button_box button");
let search_l_text = document.querySelector("#search_l_text");
let search_l_btn = document.querySelector("#search_l_btn");
// let btn_them_bl = document.querySelector(".btn_them_bl");
const selectCNElementL = document.querySelector('#cn_selected_l');
const selectCNElementT = document.querySelector('#th_selected_t');
let allRow_l = document.querySelectorAll("#row_l tr");
let them_l = document.querySelector("#them_l")
let them_tp = document.querySelector("#them_tp")
let btn_close_l = document.querySelector(".btn_close_l");
let btn_close_tp = document.querySelector(".btn_close_tp");
let modal_l = document.querySelector("#modal_l")
let modal_tp = document.querySelector("#modal_tp")


$(".table_cham_cong table").on("scroll", function() {
    $(".table_cham_cong table > *").width($(".table_cham_cong table").width() + $(".table_cham_cong table").scrollLeft());
});
$(".table_luong table").on("scroll", function() {
    $(".table_luong table > *").width($(".table_luong table").width() + $(".table_luong table").scrollLeft());
});
$(".bang_luong table").on("scroll", function() {
    $(".bang_luong table > *").width($(".bang_luong table").width() + $(".bang_luong table").scrollLeft());
});
$("tbody").hover(
    function() {
        $(this).css("overflow-y", "scroll");
    },
    function() {
        $(this).css("overflow-y", "scroll");
    }
);






$(".option_button .button_box #btn_c").click((btn) => {
    let chi_n = document.querySelector("#chi_nhanh");
    let trang_t = document.querySelector("#trang_thai");
    console.log("OKKKKKKKKKK")
    if (bang_luong.style.display != "none") {
        bang_luong.style.display = "none";
        search_l_text.style.display = "none";
        search_l_btn.style.display = "none";
        // btn_them_bl.style.display = "";
        table_luong.style.display = "";
        table_cham_cong.style.display = "";
        btn_luong.textContent = "Xem bảng lương";
        chi_n.classList.add("hide")
        trang_t.classList.add("hide")
        them_l.classList.remove("hide")
        them_tp.classList.remove("hide")
    } else {
        bang_luong.style.display = "";
        search_l_text.style.display = "";
        search_l_btn.style.display = "";
        // btn_them_bl.style.display = "none";
        table_luong.style.display = "none";
        table_cham_cong.style.display = "none";
        btn_luong.textContent = "Chi tiết lương";
        chi_n.classList.remove("hide")
        trang_t.classList.remove("hide")
        them_l.classList.add("hide")
        them_tp.classList.add("hide")
    }
})

//Chi nhánh select
 selectCNElementL.addEventListener('change', (event) => {
     // const result = document.querySelector('.result');
     let value = selectCNElementL.options[selectCNElementL.selectedIndex].value;
     allRow_l.forEach((row) => {
         row.classList.remove("hideCN", "hide")
     })
     if (selectCNElementL.selectedIndex != 0) {
        allRow_l.forEach((row) => {
             console.log(value)
            if (!(row.getAttribute("cn_s") == value)) {
                row.classList.add("hideCN");
             }
         })
     }
     // result.textContent = `You like ${event.target.value}`;
});


selectCNElementT.addEventListener('change', (event) => {
    // const result = document.querySelector('.result');
    let value = selectCNElementT.options[selectCNElementT.selectedIndex].value;
    allRow_l.forEach((row) => {
        row.classList.remove("hideCN", "hide")
    })
    if (selectCNElementT.selectedIndex != 0) {
        allRow_l.forEach((row) => {
            console.log(value)
            if (!(row.getAttribute("d_s") == value)) {
                row.classList.add("hide");
            }
        })
    }
    // result.textContent = `You like ${event.target.value}`;
});

them_l.addEventListener("click",()=>{
    modal_l.classList.remove("hide_modal")
})

them_tp.addEventListener("click",()=>{
    console.log("OKKKKKKK")
    modal_tp.classList.remove("hide_modal")
})

btn_close_l.addEventListener("click", ()=>{
    modal_l.classList.add("hide_modal")
})
btn_close_tp.addEventListener("click", ()=>{
    modal_tp.classList.add("hide_modal")
})


