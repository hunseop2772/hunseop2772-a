const str1 = '안녕하세요 JavaScript!';
console.log(str1);;
console.log(str1.length);

console.log(str1.indexOf('J'));
console.log(str1.indexOf('Java'));
console.log(str1.indexOf('j')); // -1 찾는게 없으면
console.log(str1.indexOf('a')); // 동일한게 있으면 가장 앞에있는 것
console.log(str1.lastIndexOf('a'));// 가장 뒤

console.log(str1.charAt(7));

console.log(str1.includes('Java')); // t
console.log(str1.includes('java')); // f

console.log(str1.substring(7)); // 7부터 끝까지
console.log(str1.substring(7, 11)); // 1~(11-1) 까지

console.log(str1.substr(7,4)); //뒤에 숫자 4자리만 7부터

const str2 =  '김사과,오렌지,반하나,이메론,배애리,채리'
const students = str2.split(','); // 배열로 저장하게 한다.
console.log(students)

 for(let s in students){ // 배열이니깐 사용이 가능하다.
    console.log(s, students[s]);
 }

console.log(str1.replace('안녕하세요', 'Hello'));

const str3 = '                 JavaScript                    ';

console.log(`👺${str3}👺`);
console.log(`👺${str3.trim()}👺`);






