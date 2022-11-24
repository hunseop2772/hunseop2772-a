function func1(){
    for(let i=0;i<100;i++);
    return 1;
}

function func2(){
    return func1() + 1;
}

function func3(){
    return func2() + 1;
}

console.log('프로그램을 시작합니다');
const result = func3();
console.log(result);
