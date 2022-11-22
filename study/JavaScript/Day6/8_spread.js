function add(num1, num2, num3){
    return num1 + num2 + num3;
}

function sum(num1,num2, ...nums){
    console.log(nums); //[ 3, 2, 5, 6, 7 ]
    // 앞에 두개는 이미 다른곳에
}

const nums = [10,20,30];
console.log(add(nums[0], nums[1], nums[2]))
console.log(add(...nums))

sum(1,2,3,2,5,6,7);

//배열(concat)
const fruits1 =['🍎', '🍊'];
const fruits2 =['🍓', '🍌'];

let arr = fruits1.concat(fruits2);
console.log(arr);
arr = [...fruits1,...fruits2];
console.log(arr);

// fruits1과 fruits2  사이에 😈를 넣어보자
arr = [...fruits1, '😈' ,...fruits2];
console.log(arr);


// 객체(object)
const apple = {name :'김사과', age:20, address: {si : 'seoul'} };
console.log(apple);
// apple.job = '프로그래머';
const apple_update ={...apple, job : '프로그래머'};
console.log(apple_update);

console.log('--------------------');


// 구조분해
const fruits = [ '🍎', '🍊','🍓', '🍌' ];
const [fruit1, fruit2, ...others] = fruits;
console.log(fruit1)// 🍎
console.log(fruit2)// 🍊
console.log(others)// [ '🍓', '🍌' ] 남은 나머지는 배열로 저장된다.

const point = [1,2];
const [x,y,z=0] = point;
console.log(x) // 1
console.log(y) // 2
console.log(z) // 0 -undefined가 나오는게 싫어서 z=0을 초기 선언

function sendEmoji(){
    return [ '🍎', '🍊','🍓', '🍌' ];
}

const [berry,apple2,banana,orange] = sendEmoji();

console.log(berry)  //🍎
console.log(apple2) //🍊
console.log(banana) //🍓
console.log(orange) //🍌



console.log('--------------------');

console.log(apple_update);

// function display(apple){
//     console.log('이름', apple.name)
//     console.log('나이', apple.age)
//     console.log('직업', apple.job)
// }

function display({name, age, job}){
    console.log('이름', name)
    console.log('나이', age)
    console.log('직업', job)
}

display(apple_update);

const {name, age, pet='루시', job: hobby} = apple_update;
console.log(name);
console.log(age);
console.log(pet);
console.log(hobby);

console.log('--------------------');


const component = {
    name : 'Button',
    style : {
        size :20,
        color : 'black'
    }
};
// 두 가지 방법

function changeColor({style : {color}}){
    console.log(color);
}


// function changeColor(component){
//     console.log(component.style.color);
// }

changeColor(component)


























