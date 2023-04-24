let work = JSON.parse(localStorage.getItem("detailwork"));
detailworkAPI = "http://192.168.138.1:8080/api/work/detailwork?id=" + work.detailworkID
typeworkAPI = "http://192.168.138.1:8080/api/work/typework?id=" + work.typeworkID

async function fetchdata(){
    try {
        let restw = await fetch(typeworkAPI)
        let typework = await restw.json()

        let restdw = await fetch(detailworkAPI)
        let detailwork = await restdw.json()

        renderDetails(typework, detailwork)

    } catch (error) {
        alert(error)
    }
}

function renderDetails(typework, detailwork) {
    let data = document.querySelector(".data");
    
    data.innerHTML = "";
    data.innerHTML = `
        <img src=${work.image} alt="">
        <h2>${work.workname}</h2>
        <p>Location : ${work.location}</p>
        <p>Date : ${work.date}h</p>
        <p>Hours : ${detailwork.hours}h</p>
        <p>Contact : ${detailwork.contact}</p>
        <p>Salary : ${detailwork.income}$</p>
        <p>Quantity:  ${work.involved}/${work.quantity}</p>
        <p>Type work : ${typework.nametypework}</p>
        <p>Description: ${detailwork.description}</p>
    `
}
fetchdata();