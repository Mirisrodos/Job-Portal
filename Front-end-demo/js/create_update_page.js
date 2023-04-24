let createDetailAPI = "http://192.168.138.1:8080/api/client/work/createDetail"
let createWorkAPI = "http://192.168.138.1:8080/api/client/work/createWork"

function myFunction() {
    var x = document.getElementById("myTopnav");
    if (x.className === "topnav") {
        x.className += " responsive";
    } else {
        x.className = "topnav";
    }
}


let dataId = localStorage.getItem("editId") || null
if (dataId == null) {
    let edit_form = document.querySelector(".form_of_editing")
    edit_form.innerHTML = ""
    let edit_btn = document.querySelector("#edit_bar")
    edit_btn.innerHTML = `
     <div id="add_bar">ADD DATA TO WEBSITE </div>
   `
    let add_form = document.querySelector(".form_of_editing")
    add_form.innerHTML = `
   <form id="edit_form">
   <div id="inside_form">
       <div class="comp_data" id="comp_nme">
           <label for="compmyName">Job name : </label>
           <input type="text" id="name" placeholder="Enter Job name here..." required>
        </div>
        <div class="comp_data" id="comp_lgo">
           <label for="companylogo">Date : </label>
        <input type="date" id="date" placeholder="Enter URL of logo here..." required>
        </div>
        <div class="comp_data" id="comp_cntct">
        <label for="contact">Contact : </label>
        <input type="number" id="contact" placeholder="Enter Company contact here..." required >
        </div>
        <div class="comp_data" id="comp_exp">
        <label for="experience">Quantity : </label>
        <input type="text" id="quantity" placeholder="Enter experience here..." required>
        </div>
        <div class="comp_data" id="comp_slry">
        <label for="salary">Income : </label>
        <input type="text" id="income" placeholder="Enter salary details here..." required>
        </div>
        <div class="comp_data" id="comp_lct">
        <label for="location">Location : </label>
        <input type="text" id="location" placeholder="Enter Company location here..." required>
        </div>
        <div class="comp_data" id="comp_lct">
        <label for="location">Hours : </label>
        <input type="text" id="hours" placeholder="Enter Company location here..." required>
        </div>
        <div class="comp_data" id="job_rle">
           <label for="jobrole">Type Job : </label>
           <input type="int" id="type" placeholder="Enter Job Role here..." required>
        </div>
        <div class="comp_data" id="comp_desc">
           <p><label for="description">Description : </label></p>
           <textarea name="desc" id="desc" cols="30" rows="10" placeholder="Enter Company description here..." required></textarea>
        </div>
   </div>
   <div class="submit_btn">
       <div class="cancel_btn">
           <button id="cancel"><a href="./admin_page.html"> Cancel</a></button>
       </div>
       <div class="save_btn">
           <button id="save">Save</button>
       </div>
   </div>
   </form>
   `

   //Dùng để create
    let save_add_btn = document.querySelector("#save")
    save_add_btn.addEventListener("click", (event) => {
        event.preventDefault()
        let job_name = document.querySelector("#name")
        let date = document.querySelector("#date")
        let contact = document.querySelector("#contact")
        let quantity = document.querySelector("#quantity")
        let income = document.querySelector("#income")
        let location = document.querySelector("#location")
        let hours = document.querySelector("#hours")
        let type = document.querySelector("#type")
        let desc = document.querySelector("#desc")
        // let obj = {
        //     job_name: job_name.value,
        //     date: date.value,
        //     contact: contact.value,
        //     quantity: quantity.value,
        //     income: income.value,
        //     Salary: comp_salary.value,
        //     location: location.value,
        //     hours: hours.value,
        //     type: type.value,
        //     desc: desc.value
        // }
        
        let detailObj = {
            contact:contact.value,
            description: desc.value,
            hours: hours.value,
            income: income.value
        }

        let workObj = {
            date: date.value,
            location: location.value,
            quantity: quantity.value,
            workname: job_name.value,
            typework: type.value,
            involved: 0
        }

        addtoserver(detailObj, workObj)
    })
}

async function addtoserver(detailObj, workObj) {
    try {
        let add_detail = await fetch(createDetailAPI, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(detailObj)
        })
        
        // lấy ra id detail vừa tạo
        detailworkID = (await add_detail.json()).detailworkID
        workObj["detailworkID"] = detailworkID

        let add_work = await fetch(createWorkAPI, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(workObj)
        })
        
        if (add_detail.ok) {
            alert("Data Added Successfully")
        } else {
            alert("Data not added.\nPlease Try Again")
        }
    } catch (error) {
        alert(error)
    }
}

window.addEventListener("load", () => {
    if (dataId != null) {
        editData(dataId)
        let edit_strt_btn = document.querySelector("#edit_pge_btn")
        setTimeout(() => {
            edit_strt_btn.innerText = "Start Editing"
        }, 1000);
        edit_strt_btn.innerText = "Fetching Data..."
    }
})

// let edit_strt_btn=document.querySelector("#edit_pge_btn")
// edit_strt_btn.addEventListener("click",(event)=>{
//     setTimeout(() => {
//         edit_strt_btn.innerText="In Process..."
//         editData(dataId)
//     }, 1000);
//     edit_strt_btn.innerText="Fetching Data..."

// })

async function editData(id) {
    try {
        let edit_data = await fetch(`https://636d633891576e19e327545a.mockapi.io/companies/${id}`);
        if (edit_data.ok) {
            let temp = await edit_data.json()
            showdata(temp)
        } else {

        }
    } catch (error) {
        alert("Bad request")
    }
}

function showdata(data) {
    let cname = document.querySelector("#company_name")
    cname.value = data["companyName"]
    cname.readOnly = true
    let clogo = document.querySelector("#company-logo")
    clogo.value = data["avatar"]
    clogo.readOnly = true;
    let crole = document.querySelector("#company_job_role")
    crole.value = data["jobRole"]
    crole.readOnly = true
    let ccontact = document.querySelector("#company_contact")
    ccontact.value = data["contact"]
    ccontact.readOnly = true
    let cexp = document.querySelector("#company_exp")
    cexp.value = data["experience"]
    cexp.readOnly = true
    let csalary = document.querySelector("#company_salary")
    csalary.value = data["Salary"]
    csalary.readOnly = true
    let cloc = document.querySelector("#company_loca")
    cloc.value = data["location"]
    cloc.readOnly = true
    let cdesc = document.querySelector("#company_desc")
    cdesc.value = data["description"]
    cdesc.readOnly = true
}

let temp_data = document.querySelector("#edit_pge_btn")
if (dataId != null) {
    temp_data.addEventListener("click", (event) => {
        temp_data.innerText = "Editing In Process..."
        let cname = document.querySelector("#company_name")
        cname.readOnly = false
        let clogo = document.querySelector("#company-logo")
        clogo.readOnly = false
        let crole = document.querySelector("#company_job_role")
        crole.readOnly = false
        let ccontact = document.querySelector("#company_contact")
        ccontact.readOnly = false
        let cexp = document.querySelector("#company_exp")
        cexp.readOnly = false
        let csalary = document.querySelector("#company_salary")
        csalary.readOnly = false
        let cloc = document.querySelector("#company_loca")
        cloc.readOnly = false
        let cdesc = document.querySelector("#company_desc")
        cdesc.readOnly = false
    })
}

//Dùng để Edit
let save_data = document.querySelector("#save")
if (dataId != null) {
    save_data.addEventListener("click", (event) => {
        let temp_data = document.querySelector("#edit_pge_btn")
        temp_data.innerText = "Start Editing"
        event.preventDefault()
        let data = {}
        let cname = document.querySelector("#company_name")
        data["companyName"] = cname.value
        let clogo = document.querySelector("#company-logo")
        data["avatar"] = clogo.value;
        let crole = document.querySelector("#company_job_role")
        data["jobRole"] = crole.value;
        let ccontact = document.querySelector("#company_contact")
        data["contact"] = ccontact.value;
        let cexp = document.querySelector("#company_exp")
        data["experience"] = cexp.value;
        let csalary = document.querySelector("#company_salary")
        data["Salary"] = csalary.value;
        let cloc = document.querySelector("#company_loca")
        data["location"] = cloc.value;
        let cdesc = document.querySelector("#company_desc")
        data["description"] = cdesc.value
        cname.readOnly = true
        clogo.readOnly = true;
        crole.readOnly = true
        ccontact.readOnly = true
        cexp.readOnly = true
        csalary.readOnly = true
        cloc.readOnly = true
        cdesc.readOnly = true
        finalData(data)
    })
}



async function finalData(obj) {
    try {
        let edit_fetch = await fetch(`https://636d633891576e19e327545a.mockapi.io/companies/${dataId}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(obj)
        })
        if (edit_fetch.ok) {
            alert("Data edited and saved succefully!")
        } else {
            alert("Edited data not saved.")
        }
    } catch (error) {
        alert("Bad Request")
    }
}
