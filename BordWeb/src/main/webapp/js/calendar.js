/**
 * calendar.js
 */

//document.querySelectorAll(".container-fluid h3").forEach(item => item.remove());

//document.querySelectorAll(".container-fluid table.table").forEach(item => item.remove());

//document.getElementById("fruit").remove();

// 달력을 첫째날 계산하는 함수, 마지막날 계산 함수

function getFirstDay(month = 6){
    switch(month){
        case 5: return 4;
        case 7: return 2;
    }
    return 7;
}

function getLastDate(month = 6){
    switch(month){
        case 5: return 31;
        case 7: return 31;
    }
    return 30;
}

function makeCalendar(month = 6){
    let firstDay = getFirstDay(month);
    let lastDate = getLastDate(month);

    document.getElementById("show").innerHTML = " ";
    // table 생성. border = "2"
    let tbl = document.createElement("table");
    tbl.setAttribute("class", 'table');
    tbl.setAttribute("border", "2");

    let thd = document.createElement("thead");
    let tbd = document.createElement("tbody");

    // thead 하위요소
    let days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Set'];
    let tr = document.createElement("tr");
    days.forEach(day => {
        let th = document.createElement("th");
        if(day == 'Set'){
            th.setAttribute("style", "color : blue")
        }
        if(day == 'Sun'){
            th.setAttribute("style", "color : red")
        }
        th.innerHTML = day;
        tr.appendChild(th);
    })
    tbl.appendChild(tr);

    // tbody 하위요소
    tr = document.createElement("tr");
    // 빈날짜.
    for(let i = 1; i < firstDay; i++){        
        let td = document.createElement("td");
        tr.appendChild(td);
    }

    for(let d = 1; d <= lastDate; d++){
        let td = document.createElement("td");
        td.innerHTML = d;
        tr.appendChild(td);
        if((d + firstDay - 1) % 7 == 0){
            tbd.appendChild(tr);
            td.setAttribute("style", "color : blue")
            tr = document.createElement("tr");
        }	
        if((d + firstDay - 2) % 7 == 0){
            td.setAttribute("style", "color : red")
        }
    }
    tbd.appendChild(tr);


    tbl.appendChild(thd);
    tbl.appendChild(tbd);
    

    document.getElementById("show").appendChild(tbl);
}
makeCalendar();
document.getElementById("selectMonth").addEventListener("change", function(){
    
    makeCalendar(Number(this.value));
});