//✔ 1. 함수의 기본 - 자바스크립트에서는 함수도 메모리로 인식
function sum(num1, num2){
    console.log('sum() 호출!');
    return num1 + num2;
}// 선언형

// sum() 호출!
// 13

const result = sum(10,3);
console.log(result);

//✔ 2.함수의 메모리
const add = sum;
console.log(sum(10,3));
console.log(add(10,3)); // 위와 동일한 결과 값

// sum() 호출!
// 13

//✔ 3. 함수 작성법(팁!)
function print(num){
    if(num <0 ){
        return // return은 값을 전달을 해주는 역할도 있지만 함수의 종료도 가능하다. return 하위에 있는것은 실행을 해주지 않는다. 위 상황에서는 return이 무엇을 돌려주는지 없기 때문에 undefined를 주고 아무것도 나오지 않는다.
    }
    console.log(num);
}

print(10);
print(-1);


// ✔ 4. 매개변수의 기본값은 무조건 undefined
function total(num1 =0, num2=0){
    console.log(num1);
    console.log(num2);
    console.log('arguments :',arguments);
    // 무엇이 들어왔는지 확인하기 위한 argument
    console.log('arguments[0] :',arguments[0]);
    return num1 + num2;
}

console.log(total()); //초기값을 선언해주면 undefined는 나오지 않는다.
console.log(total(10,3));


// ✔ 5. 콜백 함수 - 함수를 변수를 이용하여 사용
const calc_add = (a, b) => a+b; //return도 자동 화살표함수
const calc_multiply = (a, b) => a*b;
console.log(calc_add(10,5));
console.log(calc_multiply(10,5));

function calculator(num1, num2, action){
    if(num1<0 || num2<0){
        return;
    }
    const result = action(num1, num2);
    console.log(result);
    return result;
}

calculator(4, 2, calc_add); //함수 자체를 매개변수로 사용 
calculator(4, 2, calc_multiply);


console.log('-----------------------------')

// ✔ 문제.
// 1. num으로 전달받은 숫자를 1부터 출력 (만약 5를 전달했다면 1 2 3 4 5 출력)
// 2. num으로 전달받은 숫자의 제곱을 출력(만약 2를 전달했다면 4를 출력)
// function iterate(num, action){

// }

const calc_num = (a) => {for(let i=1; i<=a; i++){ console.log(i);}}  
const calc_d = (a) =>  console.log(a**2);

function iterate(num, action){
    action(num);
}

iterate(6, calc_num)
iterate(8,calc_d)

console.log('-----------------------------')

// ✔ 6. 원시값과 객체값의 비교
// 원시값 : 값에 의한 복사
// 객체값 : 참조에 의한 복사(메모리주소)

function display(num) {
    num =10;
    console.log(num); //10
}
const value = 5;
display(value);
console.log(value); //5


// 객체는 참조한 내용이 메모리에 저장되어 있어 주소값도 변경을 한다.
function displayObj(obj){
    obj.age =12; // 👿 이런 방식은 사용하지 말자!
    console.log(obj);//12
}
const dog = {name:'Kucy', age:24};
displayObj(dog);
console.log(dog);//12

// 복사
function changeAge(obj){
    return { ...obj,name:'sdfsd', age: 10}
}

dog2 = changeAge(dog);
console.log(dog2)
























