document.getElementById("updateFormBtn").addEventListener("click", function(){
    formSubmit("dataForm", "get", "/board/updateForm");
});

document.getElementById("boardDeleteBtn").addEventListener("click", function(){
    if(confirm("정말 삭제하시겠습니까?")){
        formSubmit("dataForm", "post", "/board/boardDelete");
    }
});

document.getElementById("insertFormBtn").addEventListener("click", function(){
    locationProcess("/board/insertForm");
});

document.getElementById("boardListBtn").addEventListener("click", function(){
    locationProcess("/board/boardList");
})