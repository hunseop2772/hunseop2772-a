// number 형
const num1 =10;
const num2 =11.11;
const num3 =10e6;
console.log(num1);
console.log(num2);
console.log(num3);
console.log(typeof num1);
console.log(typeof(num2));
console.log(typeof(num3));

//문자형
const num4 = 10;
const num5 = 5;
const str1 = 'Hello JavaScript';
const str2 = 'Hello Word';
const str3 = '10';
console.log(num4 + num5); //15
console.log(num4 + str1);// 숫자 문자가 더해지면 문자형으로  10Hello JavaScript
console.log(str1 +" "+ str2);
console.log(`자바스크립트에서는 문자열을
쌍따옴표 또는 따옴표로 둘러싸인
문자의 집합을 의미합니다`);
console.log(`str1 :${str1}, str2:${str2}`);

console.log(num4+str3); // 1010
console.log(num4*str3); // 덧셈 + 을 제외한고는 자동형변환
console.log(num4-str3);
console.log(num4/str3);

//논리형
const b1 = true;
const b2 = false;
const b3 = (10 > 5);
const b4 = (10 < 3);
console.log(b1)
console.log(b2)
console.log(b3)
console.log(b4)

// undefined, null
let num;// 데이터가 없어서 형이나 아무것도 확인을 못함
console.log(num);// undefined
console.log(typeof(num));// undefined

let obj1 ={};//실체가 있지만 내용은 없음
console.log(obj1); // 자료가 없는 객체 {}
console.log(typeof(obj1)); //object

let obj2 = null;// 실체자체가 없음
console.log(obj2); //null
console.log(typeof(obj2)); //object

// symbol
const symbol1 = Symbol('apple');
const symbol2 = Symbol('apple');
console.log(symbol1);
console.log(symbol2);
console.log(symbol1 == symbol2);
// 내부적으로 아이덴티티한 값이 있어서 false
const symbol3 = Symbol('banana');
const symbol4 = symbol3;
console.log(symbol4 == symbol3);

//객체형
const apple = {'name':'김사과','age':20,'address':'서초구'}
console.log(apple); // {'name':'김사과','age':20,'address':'서초구'}
console.log(apple.name);// 김사과
console.log(apple.age);
console.log(apple.address);

apple.age = 21;
console.log(`2022년 김사과의 나이는 ${apple.age}살 입니다.`);
