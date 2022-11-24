// function timer1(){
//     try{
//     setTimeout(() => {
//         console.log('타이머 완료');
//     }, 3000);
// }catch(error){
//     console.log('에러');
// }
// }

// function timer2(){
//     setTimeout(() => {
//         console.log('시작');
//         timer1();
//     }, 3000);
// }

// timer2();

function runInDelay(callback, seconds){
    if(!callback){
        throw new Error('callback함수를 전달해야 합니다');
    }
    if(!seconds || seconds < 0){
        throw new Error('seconds는 0보다 커야합니다');
    }
    setTimeout(callback, seconds * 1000);
}

try{
    runInDelay(() => {
        console.log('타이머 완료!');
    }, 2);
}catch(error){
    console.log(error);
}