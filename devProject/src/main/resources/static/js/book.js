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
