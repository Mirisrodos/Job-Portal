// let topworkAPI ="https://636d633891576e19e327545a.mockapi.io/companies"
let topworkAPI = "http://192.168.138.1:8080/api/client/top10-work"
let detailworkAPI = "http://192.168.138.1:8080/api/client/detailwork?id=1"


document.getElementById("searchbtn").addEventListener("click",
    () => {
        window.location.href = "companies.html"
    })


let login = document.getElementById("loginbtn").addEventListener("click", () => {
    window.location.href = "signin.html"
})
let register = document.getElementById("registerbtn").addEventListener("click", () => {
    window.location.href = "signup.html"
})

//fetching
let realData = []
async function fetchdata() {
    try {
        let res = await fetch(topworkAPI)
        let data = await res.json()
        console.log(data)
        //renderdata(data)
        //rendercompanydata(data)
        //render_featurecard(data)

        realData = data;
        //    renderData(realData)
        renderData2(realData)
    } catch (error) {
        alert(error)
    }
}


//Search Section 
let companyobj = [{
    name: "Hồ Chí Minh >",
    img: "https://static.naukimg.com/s/0/0/i/trending-naukri/mnc.svg"

}, {
    name: "Hà nội >",
    img: "https://static.naukimg.com/s/0/0/i/trending-naukri/mnc.svg"
},
{
    name: "Vũng Tàu >",
    img: "https://static.naukimg.com/s/0/0/i/trending-naukri/mnc.svg"
},
{
    name: "Cần thơ >",
    img: "https://static.naukimg.com/s/0/0/i/trending-naukri/mnc.svg"
},
{
    name: "Bình Định >",
    img: "https://static.naukimg.com/s/0/0/i/trending-naukri/mnc.svg"
},
{
    name: "Bình Dương >",
    img: "https://static.naukimg.com/s/0/0/i/trending-naukri/mnc.svg"
}]

rendercompanycarddata(companyobj)

function rendercompanycarddata(arr) {
    let renderCard = document.querySelector("#jobcard")
    arr.forEach(element => {
        let card = document.createElement("div")
        card.classList.add("companydatacard")
        card.addEventListener("click", () => {
            window.location.href = "companies.html"
        })
        let name = document.createElement("h4");
        name.innerText = element.name;
        //console.log(name)
        let image = document.createElement("img");
        image.setAttribute("src", element.img)

        card.append(image, name)
        renderCard.append(card)
        // console.log()


    })
}

// Top Job
let featurecompany = document.querySelector("#featureslide");
function renderData2(comData) {
    // render data
    featurecompany.innerHTML = "";
    featurecompany.innerHTML = comData.map((item) => {
        return `
            <div class="combox" data-id=${item.workID}>
                <div>
                    <img
                    // Type Job Avatar (Create Obj Store Img Order By Type Job)
                        src="https://static.naukimg.com/s/0/0/i/trending-naukri/mnc.svg"
                        alt="image"
                    />
                </div>
                <div>
                    <h3>${item.workname}</h3>
                    <p><i class="fa-solid fa-star"></i>Lương: ${item.income}$</p>
                    <p>Địa điểm: ${item.location}</p>
                    <p>Số lượng: ${item.quantity}</p>
                </div>
            </div>
        `
    }).join(" ");
    // company detail
    let comboxes = document.querySelectorAll(".combox");
    for (let combox of comboxes) {
        combox.addEventListener("click", (event) => {
            for (let i = 0; i < comData.length; i++) {
                if (String(comData[1].workID) === combox.dataset.id) {
                    localStorage.setItem("detailCompany", JSON.stringify(comData[i]));
                    window.location.href = "com_detail.html";
                }
            }
        });
    }
}

// function render_featurecard(arr){
//     let featurecard = document.querySelector("#featureslide");
//     arr.forEach(element=>{
//         let card = document.createElement("div");
//         let img = document.createElement("image");
//         img.setAttribute("src",element.avatar)
//         let subcard = document.createElement("div")

//         let name = document.createElement("h4");
//         name.innerText=element.companyName;
//         console.log(name)
//         let rating = document.createElement("p");
//         rating.innerText = element.rating;
//         console.log(rating)
//         let review = document.createElement("p");
//         review.innerText = "Reviews"
//         let desc = docuument.createElement("p");
//         desc.innerText=element.description
//         let job = document.createElement("button");
//         job.innerText="View Job"

//         subcard.append(name,rating,review,desc,job)
//         card.append(img,subcard)
//         featurecard.append(card)

//     })
// }

//Job Across Popular roles 

//Sponsered Companies  

//Interview Prepration Section  

//Grow your Career through Learning  

//Video Profile  

//Footer  

// testing

fetchdata();


function renderdata(arr) {
    let renderCard = document.querySelector("#searchsection")
    arr.forEach(element => {
        let card = document.createElement("div")
        let name = document.createElement("h3");
        name.innerText = element.companyName;
        //console.log(name)
        let image = document.createElement("img");
        image.setAttribute("src", element.avatar)

        card.append(name, image)
        renderCard.append(card)
        // console.log()


    })
}