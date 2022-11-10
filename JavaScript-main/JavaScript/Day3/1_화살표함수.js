const func1 = () => console.log('안녀와세요 javascript!');

func1();

const func2 = (x,y) => console.log(`두수의 합 ${x+y}`);

func2(10,3);

const func3= (x) =>x*x;
const result = func3(4);
console.log(`4의 제곱 : ${result}`); //4의 제곱 : 16

const func4 = (x,y) => {
    let sum =0;
    for(let i=x; i<=y;i++){
        sum+=i;
    }
    return sum;
}
const total = func4(1,100);
console.log(total);//5050

const age = 20;
const isAdult = (age >18) ? ()=> console.log(`성인입니다.`) : () => console.log("미성년입니다.");
// 함수 자체가 저장이 가능하다 - 화살표 함수를 사용하여 -> 
isAdult();