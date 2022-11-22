// const dan = Number(prompt('원하는 단을 입력하세요'))
// console.log(`${dan}단`)

// let i =1;// const인 경우에는 i가 변화하기 때문에 한번 반복 후 오류발생!!!
// while(i<=9){
//     console.log(`${dan} * ${i} = ${dan*i}`);
//     i++
// }

const dan = Number(prompt('원하는 단을 입력하세요'))
console.log(`${dan}단`)

for(let i =1; i <= 9; i++){
    console.log(`${dan} * ${i} = ${dan*i}`);
}