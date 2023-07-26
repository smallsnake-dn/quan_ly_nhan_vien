const selectCNElement = document.querySelector('#cn_selected');
var allRow = document.querySelectorAll(".table_body tbody tr")
const selectTTElement = document.querySelector('#tt_selected');
var modal = document.querySelector("#modal_nv")
let btn_huy = document.querySelector("#btn_huy")


//Chi nhánh select
selectCNElement.addEventListener('change', (event) => {
    // const result = document.querySelector('.result');
    let value = selectCNElement.options[selectCNElement.selectedIndex].value;
    allRow.forEach((row) => {
        row.classList.remove("hideCN", "hide")
    })
    if (selectCNElement.selectedIndex != 0) {
        allRow.forEach((row) => {
            if (!row.className.includes(value)) {
                row.classList.add("hideCN");
            }
        })
    }
    // result.textContent = `You like ${event.target.value}`;
});

//Trạng thái select
selectTTElement.addEventListener('change', (event) => {
    // const result = document.querySelector('.result');
    let value = selectTTElement.options[selectTTElement.selectedIndex].value;
    allRow.forEach((row) => {
        row.classList.remove("hideTT", "hide")
    })
    console.log(value)
    if (selectTTElement.selectedIndex != 0) {
        allRow.forEach((row) => {
            if (!row.className.includes(value)) {
                console.log(value)
                row.classList.add("hideTT");
            }
        })
    }
    // result.textContent = `You like ${event.target.value}`;
});


function btnModal() {
    let closeBtn = document.querySelector(".modal_nv_header_close")
    let btn_them = document.querySelector("#btn_them")
    let btn_huy = document.querySelector("#btn_huy")
    closeBtn.addEventListener("click", function () {
        modal.classList.add("hide_modal")
    })
    // btn_them.nodeName = "Add";
    btn_them.textContent = "Thêm";
    btn_huy.textContent = "Huỷ";
}

function themEventNV_Btn() {
    let btn_them = document.querySelector("#btn_them")
    let btn_huy = document.querySelector("#btn_huy")

    initForm()
    modal.classList.remove("hide_modal")
    btn_huy.addEventListener("click", (event) => {
        if (!btn_huy.classList.contains("allow_delete")) {
            event.preventDefault();
            modal.classList.add("hide_modal")
        }
        btn_huy.name = "";

    })
    btn_them.name = "Add";
    btn_them.textContent = "Thêm";
    btn_huy.textContent = "Huỷ";
}

function themBtn() {

    let btn = document.querySelector("#themNV_Btn");
    btn.addEventListener("click", () => {
        modal.classList.remove("hide_modal")
        btn_huy.classList.remove("allow_delete")
        themEventNV_Btn()
    })
}

function searchBtn() {
    let search_nv = document.querySelector("#search_nv")
    let search_text = document.querySelector("#search_text")
    search_nv.addEventListener("click", (event) => {
        event.preventDefault();
        let text = search_text.value.trim()
        allRow.forEach((row) => {
            row.classList.remove("hideCN", "hide", "hideTT")
        })
        allRow.forEach((row) => {
            if (row.id != text) {
                row.classList.add("hide")
            }
        })
    })
}

function initForm(manv = "", ho = "", ten = "",
                  diachi = "", chucvu = 0, chinhanh = 0,
                  sdt = "", trangthai = 0, hinhanh = "", gioitinh = "", ngaysinh = "", hinhthuc = "") {
    document.querySelector("#modal_nv input[name='manv']").value = manv;
    document.querySelector("#modal_nv input[name='hoten']").value = ho;
    document.querySelector("#modal_nv input[name='ten']").value = ten;
    document.querySelector("#modal_nv input[name='diachi']").value = diachi;
    document.querySelector("#modal_nv input[name='date']").value = ngaysinh;
    document.querySelector("#modal_nv select[name='chucvu']").selectedIndex = chucvu - 1;
    document.querySelector("#modal_nv select[name='chinhanh']").selectedIndex = chinhanh - 1;
    document.querySelector("#modal_nv input[name='sdt']").value = sdt;
    document.querySelector("#modal_nv select[name='trangthai']").selectedIndex = trangthai - 1;
    document.querySelector("#anh_form_nv").setAttribute("src", hinhanh);
    document.querySelector("#modal_nv select[name='gioitinh']").selectedIndex = gioitinh?(gioitinh == 'Nam' ? 0 : 1) : 0;
    document.querySelector("#modal_nv select[name='hinhthuc']").selectedIndex = hinhthuc?(hinhthuc == 'FT' ? 0 : 1) : 0;

}

function findNV(listNV, manv) {
    let nvf = {}
    listNV.forEach((nv) => {
        if (nv.manv.trim() == manv.trim()) {
            console.log(nv)
            console.log("return")
            nvf = nv
            return nvf
        }
    })
    return null;
}

function time() {
    var today = new Date();
    var weekday = new Array(7);
    weekday[0] = "Chủ Nhật";
    weekday[1] = "Thứ Hai";
    weekday[2] = "Thứ Ba";
    weekday[3] = "Thứ Tư";
    weekday[4] = "Thứ Năm";
    weekday[5] = "Thứ Sáu";
    weekday[6] = "Thứ Bảy";
    var day = weekday[today.getDay()];
    var dd = today.getDate();
    var mm = today.getMonth() + 1;
    var yyyy = today.getFullYear();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    nowTime = h + ":" + m + ":" + s;
    if (dd < 10) {
        dd = '0' + dd
    }
    if (mm < 10) {
        mm = '0' + mm
    }
    today = day + ', ' + dd + '/' + mm + '/' + yyyy;
    tmp = '<i class="fa fa-clock-o" aria-hidden="true"></i> <span class="date">' + today + ' | ' + nowTime +
        '</span>';
    document.getElementById("clock").innerHTML = tmp;
    clocktime = setTimeout("time()", "1000", "Javascript");

    function checkTime(i) {
        if (i < 10) {
            i = "0" + i;
        }
        return i;
    }
}


btnModal()
themBtn()
searchBtn()
time()