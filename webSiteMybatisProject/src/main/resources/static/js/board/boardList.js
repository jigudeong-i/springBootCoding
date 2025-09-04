document.addEventListener('click', (event) => {
    const target = event.target.closest('.goDetail');
    if(!target) return;

    const tr = target.closest('tr');
    const boardNumber = tr.dataset.num;
    // console.log("글번호 : " + boardNumber); //확인 후 삭제

    locationProcess(`/board/${boardNumber}`);
});

document.getElementById("insertFormBtn").addEventListener("click", () => {
    locationProcess("/board/insertForm");
});