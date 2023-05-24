let work = JSON.parse(localStorage.getItem("detailwork"));
detailworkAPI = "http://192.168.138.1:8080/api/v1/detailwork/find-detailwork?id=" + work.detailworkID
typeworkAPI = "http://192.168.138.1:8080/api/v1/typework/find-typework?id=" + work.typeworkID

async function fetchdata(){
    try {
        let restw = await fetch(typeworkAPI)
        let typework = await restw.json()

        let restdw = await fetch(detailworkAPI)
        let detailwork = await restdw.json()

        let reslocation = await fetch('https://provinces.open-api.vn/api/?depth=2')
        let data_location = await reslocation.json()

        renderDetails(typework, detailwork, data_location)

    } catch (error) {
        alert(error)
    }
}


function renderDetails(typework, detailwork, data_location) {
    let data = document.querySelector(".data");

    let city_location = data_location.filter((item) => {
        return item.codename === work.city
    })


    let district_location = city_location[0].districts.filter((item) => {
        return item.codename === work.district
    })

    data.innerHTML = "";
    data.innerHTML = `
        <img src=${work.image} alt="">
        <h2>${work.workname}</h2>
        <p>Location : ${work.address} ${district_location[0].name} ${city_location[0].name}</p>
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