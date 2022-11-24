let arr1 = [];
let arr2 = [];
let temp;

arr1[0] = '1+1=';
arr1[1] = '1+2=';
arr1[2] = '1+3=';
arr1[3] = '1+4=';
arr1[4] = '1+5=';
arr1[5] = '1+6=';
arr1[6] = '1+7=';
arr1[7] = '1+8=';
arr1[8] = '1+9=';
arr1[9] = '1+10=';
arr1[10] = '1+11=';
arr1[11] = '1+12=';
arr1[12] = '1+13=';
arr1[13] = '1+14=';
arr1[14] = '1+15=';
arr1[15] = '1+16=';
arr1[16] = '1+17=';
arr1[17] = '1+18=';
arr1[18] = '1+19=';
arr1[19] = '1+20=';
arr2 = [2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21];

while(true){
    let cnt = 0;
    let ran;
    for(let i=0;i<3;i++){
        ran = Math.floor(Math.random()*20);
        func1();
        if(arr2[ran] == temp){
            cnt++;
            alert(`정답입니다. 현재점수: ${cnt}점`);
        }else{
            alert(`틀렸습니다. 현재점수: ${cnt}점`);
        }
    }
    if(cnt == 3){
        alert('모두 맞췄습니다.');
    }else{
        alert('틀렸습니다 처음부터 다시하세요.');
    }
}

function func1(){
    setTimeout(() => {
        temp = prompt(arr1[ran]);
    })
}