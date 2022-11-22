console.log(new Date()); // 내 OS 시간을 가저온다.
console.log(new Date(22,11,7)); // 년도를 2자리로 사용하면 1900년도
// 1922-12-06
// console.log(new Date(2022,10,7,13,40,00)); 
const current_time  = new Date(2022,10,7,13,40,00);
console.log(current_time);
console.log(current_time.toString()); //표준시로 출력


console.log(`현재 년도 : ${current_time.getFullYear()}`);
console.log(`현재 월 : ${current_time.getMonth()+1}`);
console.log(`현재 일 : ${current_time.getDate()}`);
console.log(`현재 시간 : ${current_time.getHours()}`);
console.log(`현재 분 : ${current_time.getMinutes()}`);
console.log(`현재 초 : ${current_time.getSeconds()}`);

console.log(new Date(1700000000000));






