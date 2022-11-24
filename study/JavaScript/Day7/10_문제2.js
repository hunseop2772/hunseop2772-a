while(true){
    let cnt = 0;
    let pr = 0;
    let an = 0;
    for(let i=0;i<3;i++){
        let a = Math.round(Math.random()*50+1);
        let b = Math.round(Math.random()*50+1);
        pr = a + b;
        an = Number(prompt(`${a}+${b}=`));
        if(an == pr){
            cnt++;
            alert(`정답입니다. 현재점수: ${cnt}점`);
        }else{
            alert(`틀렸습니다. 현재점수: ${cnt}점`);
        }
    }
    if(cnt == 3){
        alert('모두 맞췄습니다. 종료합니다.');
        break;
    }else{
        alert(`${cnt}점입니다. 처음부터 다시하세요.`);
    }
}
