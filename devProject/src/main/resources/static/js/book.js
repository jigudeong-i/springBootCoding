document.getElementById("insertBtn").addEventListener("click", () => {
    if (!chkData("#title", "책제목을")) return;
    else if (!chkData("#author", "책저자를")) return;
    else if (!chkData("#publisher", "출판사를")) return;
    else if (!chkData("#publishDate", "출간연도를")) return;
    else if (!chkData("#price", "책가격을")) return;
    else {
        formSubmit("insertForm", "post", "/book/bookInsert");
    }
});

document.getElementById("cancelBtn").addEventListener("click", () => {
    formReset("insertForm");
});

document.addEventListener('click', (event) => {
    if (event.target.classList.contains('deleteBtn')){
        event.preventDefault();

        const row = event.target.closest('tr');
        const number = row.querySelector('th[scope="row"]').textContent.trim();

        //console.log(`선택한 번호: ${number}`};
        if(confirm("책정보를 삭제하시겠습니까?")){
                locationProcess(`/book/bookDelete?bookId=${number}`);
            }
        }
    });