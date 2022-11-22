function func1(){
    console.log('func1() 호출')
}

const func2 = function(){
    console.log(`func2() 호출`)
}
func1();
func2();

function func3(num){
    console.log(`전달받은 매개변수의 값 : ${num}`)
}

func3(10)
func3(`apple`)
func3(true)


function func4(start, end){
    let sum=0;
    for(let i=start; i<=end; i++){
        sum += i;
    }
    console.log(`${start}부터 ${end}까지의 총합${sum}`)
}

func4(1,100)
func4(1);// 2개의 매개변수에서 1개만 넣을경우 0이 나온다 undefined 때문이다.


function func5(){
    return '🍎';
}

func5(); // consol도 없고 아무것도 없어 미출력
console.log(func5())
const presents = func5()
console.log(presents)

console.log(`-------------`)

function func6( x1, ...x2){
    console.log(`x1의 값: ${x1}`) // x1의 값: 30
    console.log(`x2의 값: ${x2}`) // x2의 값: 50,60,90,100,20,40
    
    for(i in x2){
        console.log(`i의 값 : ${i}, x2[i] : ${x2[i]}`)
    }

}
func1(30, 50,60,90,100,20,40)


console.log(`-------------`)


function func7(num1=1, num2 =1){
    console.log(`num1의 값 : ${num1}, num2의 값 : ${num2}`);    
    console.log(`${num1} * ${num2} = ${num1*num2}`);    
}

func7(2,8)
func7();// 아무것도 넣지 않으면 그저 1로 취급


// 보너스!

(function(){
    console.log(`함수를 만들고 바로 호출합니다!`)
})()// 생성과 동시에 생기고 삭제


