function showTable(value) {
    if (value === "Search") {
        var div = document.getElementById("containerSearch");
        if (div.style.display === "none") {
            div.style.display = "block";
            document.getElementById("tableInsert").style.display = "none";
        }
    } else if (value === "Insert") {
        var div = document.getElementById("tableInsert");
        if (div.style.display === "none") {
            div.style.display = "block";
            document.getElementById("containerSearch").style.display = "none";
        }
    }
}

function ajaxInsert() {
    var empId = document.getElementById("emp_id").value;
    var fname = document.getElementById("fname").value;
    var lname = document.getElementById("lname").value;
    var jobId = document.getElementById("job_id").value;
    var jobLvl = document.getElementById("job_lvl").value;

    var urlReWriting = "insert?" + "empId=" + empId + "&fname=" + fname 
            + "&lname=" + lname + "&jobId=" + jobId 
            + "&jobLvl=" + jobLvl;

    var xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            document.getElementById("tableInsert").innerHTML = xhttp.responseText;            
        }
    };
    xhttp.open("GET", urlReWriting, true);
    xhttp.send();
}

function ajaxSearch(value) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("tableSearch").innerHTML = xhttp.responseText;
        }
    };
    xhttp.open("GET", "search?searchValue=" + value, true);
    xhttp.send();
}

function ajaxDelete(value) {
    var chk = document.getElementById("id_" + value).value;
    var searchValue  = document.getElementById("searchValue").value;
    var urlRewritting = "delete?searchValue=" + searchValue + "&id=" + chk;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("tableSearch").innerHTML = xhttp.responseText;
        }
    };
    xhttp.open("GET", urlRewritting, true);
    xhttp.send();
}

function ajaxUpdate(value) {
    console.log(value);
    var id = document.getElementById("id_" + value).value;
    var fname = document.getElementById("fname_" + value).value;
    var lname = document.getElementById("lname_" + value).value;
    var searchValue = document.getElementById("searchValue").value;
    
    var urlRewritting = "update?searchValue=" + searchValue 
            + "&id=" + id 
            + "&fname=" + fname 
            + "&lname=" + lname 
            + "&postfix=" + value;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("tableSearch").innerHTML = xhttp.responseText;
        }
    };
    xhttp.open("GET", urlRewritting, true);
    xhttp.send();
}