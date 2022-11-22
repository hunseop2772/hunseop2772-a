const num = 10; // number 원시 타입
console.log(typeof(num));
console.log(num);//num뒤에 .을 찍는 순간 이는 객체가 되면서 메소드를 사용한다.
// 객체가 아닌데 왜 메소드를 호출 할 수 있지?
console.log(num.toString()); // num object -> 기능 사용 .을 사용한 순간만
console.log(num); // number 원시 타입


// 지수 표기법
const num2 = 102;
console.log(num2.toExponential());

// 반올림하여 문자열로 변환
const num3 = 1234.12;
console.log(num3.toFixed());

// 로컬형식(각 나라)의 문자형으로 변환
console.log(num3.toLocaleString('ar-EG'));

const num4 = 0.1 + 0.2 - 0.2;
console.log(num4);

// 브라우저 밖(node.js) 
console.log(globalThis); // 기본 속성으로 무엇을 사용할 수 있는지
// 브라우저 안(browser) 



const URL = 'https://코리아아이티아카데미.com';
const encoded = encodeURI(URL);
console.log(encoded);

const decoded = decodeURI(encoded);
console.log(decoded);

const part = '코리아아이티아카데미.com';
console.log(encodeURIComponent(part));

