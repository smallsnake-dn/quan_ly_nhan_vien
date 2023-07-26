let themTK_Btn = document.querySelector("#themTK_Btn");
let modal_tk = document.querySelector("#modal_tk")
let btn_close_modal = document.querySelector(".btn_close")
let row_tk = document.querySelectorAll("#row_tk tr")
let nv_sl = document.querySelectorAll("#nv_sl option")
let u_manv = document.querySelector("#u_manv")
let quyenU = document.querySelectorAll("#quyenU option")
let enable = document.querySelector("#enable")
let pass = document.querySelector("#pass")
let modal_u_tk = document.querySelector("#modal_u_tk")
let btn_close_u = document.querySelector(".btn_close_u")
const role_selected = document.querySelector("#role_selected")
const enable_selected = document.querySelector("#enable_selected")
let search_nv = document.querySelector("#search_nv")



themTK_Btn.addEventListener("click", ()=>{
    modal_tk.classList.remove("hide_modal")
})

btn_close_modal.addEventListener("click", ()=>{
    modal_tk.classList.add("hide_modal")
})

btn_close_u.addEventListener("click", ()=>{
    modal_u_tk.classList.add("hide_modal")
})

row_tk.forEach((r)=>{
    let manv = r.getAttribute("manv")
    nv_sl.forEach((op)=>{
        // console.log(op.getAttribute("value"))
        // console.log(manv)
        if(op.getAttribute("value") == manv) {
            op.style.display = 'none';
        }
    })
    r.addEventListener('click',()=>{
        console.log("rowwwwwwwwwwwww")
        modal_u_tk.classList.remove("hide_modal")
        u_manv.setAttribute("text", r.getAttribute("username"));
        u_manv.setAttribute("value", r.getAttribute("username"));
        quyenU.forEach((q)=>{
            q.style.display = '';
            if(r.getAttribute("roles").includes(q.getAttribute("value"))) {
                q.style.display = 'none';
            }
        })
    })
})

role_selected.addEventListener("change", ()=>{
    let slr = role_selected.options[role_selected.selectedIndex].value
    row_tk.forEach((r)=>{
        r.classList.remove("hide_row_r");
        let rol = r.getAttribute("roles")
        console.log("day la role" + rol)
        console.log("day la role select" + slr)
        if((rol?!rol.includes(slr):true) && (slr != 'all')){
            r.classList.add("hide_row_r")
        }
    })
})

enable_selected.addEventListener("change", ()=>{
    let sle = enable_selected.options[enable_selected.selectedIndex].value
    row_tk.forEach((r)=>{

        r.classList.remove("hide_row_e");
        if((r.getAttribute('enable') != sle)  && (sle != 'all')){
            r.classList.add("hide_row_e")
        }

    })
})

search_nv.addEventListener("click", ()=>{
    let search_text = document.querySelector("#search_text").value.trim()
    row_tk.forEach((r)=>{
        r.classList.remove("hide_row_e", "hide_row_r");
        let manv = r.getAttribute("manv")
        console.log(manv)
        console.log(search_text)
        if((search_text != '') && ((manv?manv:true) != search_text)){
            r.classList.add("hide_row_e")
        }
    })
})

