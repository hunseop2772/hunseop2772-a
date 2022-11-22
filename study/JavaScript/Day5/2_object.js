//dog은 객체이고, 어떤 클래스의 인스턴스도 아님
let dog = {
    name: 'Lucy',
    age:13,
    'dog-weight':30.5,
    ['dog-height']:0.8
}
console.log(dog);
console.log(dog.name);
console.log(dog['age']);

dog.family = 'firedog';
console.log(dog);
console.log(dog.family);

delete dog['dog-height'];
console.log(dog);
console.log(dog['dog-height']);

console.log('---------------------------------------------------------------------------');

// 동적으로 속성에 접근하고 싶을 때
function getValue(obj, key){
    //dog.name
    return obj[key]
}

console.log(getValue(dog, `name`));

console.log('---------------------------------------------------------------------------');


//문제. 
// 필드를 추가 - addKey - obj, 키, 값
// 필드를 삭제 - deleteKey - obj, 키

function addkey(obj, key, value){
    obj[key] = value;
}
function deleteKey(obj, key){
    delete obj[key]
}


addkey(dog, 'dog-heigh', 80);
deleteKey(dog, 'dog-heigh');
console.log(dog);

console.log('---------------------------------------------------------------------------');

const x = 0;
const y = 0;
// const coord = {x: x, y: y};
const coord = {x, y};
console.log(coord);


// 객체 생성 함수
function makeObj(name, age){
    return{ // 객체 생성
        name, age
    };
}
console.log(makeObj('apple', 20));

console.log('---------------------------------------------------------------------------');

// 생성자로 만들기
const apple = {
    name : 'apple',
    display : function() {
        console.log(`${this.name}: 🍎`);
    }
}// 그냥 객체

const orange = {
    name : 'orange',
    display : function() {
        console.log(`${this.name}: 🍊`);
    }
} // 그냥 객체

console.log(apple);
apple.display();
console.log(orange);
orange.display();

console.log('---------------------------------------------------------------------------');

function Fruit(name, emoji){
    this.name = name;//객체로 만들어주면 본인 객체를 의미함
    this.emoji = emoji;
    this.display = () =>{
        console.log(`${this.name}: ${this.emoji}`)
    }
    //return this; 생략가능 생성자를 이용한다면
} // 틀이나 생성자가 있고 이를 메모리에 올리는 것

const apple2 = new Fruit('appel', '🍎'); // 올린걸 복제하여 새로운 객체를 만드는 것을 인스턴스라고 한다. 
const orange2 = new Fruit('orange', '🍎');

console.log(apple2);
apple2.display();
console.log(orange2);
orange2.display();






























