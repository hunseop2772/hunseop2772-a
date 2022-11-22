// 자동형변환
const a= 10 + ' 문자열';
console.log(a);//10문자열
const b ='3'*'5';
console.log(b);//15
const c= 1- '문자열';
console.log(c);//NAN

//타입변환 함수
const num1 = '10';
const num2 ='5';
console.log(`현재 num1의 타입 : ${typeof(num1)} `);
console.log(`num2 + num1 = ${num2 + num1} `);
console.log(`Number(num2) + Number(num1) = ${Number(num2) + Number(num1)} `);
console.log(`parseInt(num2) + parseInt(num1) = ${parseInt(num2) + parseInt(num1)} `);
console.log(`Boolean(num1): ${Boolean(num1)}`)
console.log(`Object(num1): ${Object(num1)}`)