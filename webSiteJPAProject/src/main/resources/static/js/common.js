function chkData(selector, message){
    const element = document.querySelector(selector);
    const value = element.value.trim();

    if(value === "" || value === "0"){
        alert(`${message} 입력해 주세요.`);
        element.value = "";
        element.focus();
        return false;
    }
    return true;
}

const formSubmit = (selector, method, action) => {
    const form = document.getElementById(selector);
    form.method = method;
    form.action = action;
    form.submit();
}

const formReset = (selector) => {
    const form = document.getElementById(selector);
    form.reset();
}

const locationProcess = (url) => {
    location.href = url;
}

const chkFile = (item) => {
    const fileInput = typeof item === 'string' ? document.querySelector(item) : item;

    const fileName = fileInput.value;
    const ext = fileName.split('.').pop().toLowerCase();
    const allowedExts = ['gif', 'png', 'jpg'];  //허용 확장자 배열

    if (!allowedExts.includes(ext)){
        alert('업로드 가능한 파일 확장는 gif, png, jpg입니다.');
        fileInput.value = "";
        return false;
    }
    return true;
}

//enctype 속성의 기본 값은 "application/x-www-form-urlcencoded". POST바식 폼 전송에 기본 값으로 사용
const formFileSubmit = (selector, method, action) => {
    const form = document.getElementById(selector);
    form.method = method;
    form.enctype = "multipart/form-data";
    form.action = action;
    form.submit();
}
