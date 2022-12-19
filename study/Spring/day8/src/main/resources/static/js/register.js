window.onload = function (){
    const btn = document.getElementById('registBtn');
    btn.addEventListener('click',sendit);
}

function sendit(){
    const userid = document.getElementById('userid');
    const userpw = document.getElementById('userpw');
    const name = document.getElementById('name');

    if(userid.value ==''){
        alert('아이디를 입력하세요');
        userid.focus();
        return false;
    }
    if(userpw.value ==''){
        alert('비밀번호를 입력하세요');
        userpw.focus();
        return false;
    }
    if(name.value ==''){
        alert('이름을 입력하세요');
        name.focus();
        return false;
    }


    return true;
}