 document.getElementById("subjectAllListBtn").addEventListener("click", function() {

    fetch("/subject/subjectAllList")
    .then(response => response.json())
    .then(data => {
        let subjectList = document.getElementById("subjectList");
        subjectList.textContent = "";

        if(data.length === 0) {
            subjectList.textContent = "<tr><td colspan='3'>등록된 학과 정보가 존재하지 않습니다.</td></tr>";
    } else {
        data.forEach((subject) => {
        const tr = document.createElement("tr");

        const tdNo = document.createElement("td");
        tdNo.textContent = subject.no;

        const tdNumber = document.createElement("td");
        tdNumber.textContent = subject.subjectNumber;

        const tdName = document.createElement("td");