//❗❗ 논리연산자
// &&, ||
const obj1 = {name: '김사과'};
const obj2 = {name : '반하나', lover : '이메론'}

if(obj1 || obj2){ // 값이 있으면  true로 취급하기 때문에 결과적으로 true가 나온다.
    console.log('둘다 true!')
} // 비교문일때는 참, 거짓을 확인하고

let result = obj1 && obj2;
console.log(result);
// 대입문일 경우에는 앞이 참이면 뒤의 값을 변수에 넣어준다.
// 그렇기 때문에 결과값은 { name: '반하나', lover: '이메론' }
// &&는 앞이 참이여도 뒤의 값을 확인하기 위해 뒤값이 넘어간다
result = obj1 || obj2;
console.log(result)
// ||는 앞이 참이면 뒤가 무엇이든지 참이기 때문에 obj1이 변수에 들어간다.

function changeLover(obj){
    if(!obj.lover){
        throw new Error('애인이 없어!');
    }
    obj.lover = '애인바뀜'
}

function makeNewLover(obj){
    if(obj.lover){
        throw new Error('애인이 있다!');
    }

    obj.lover = '새로운 애인 생성'
}

obj1.lover && changeLover(obj1);
console.log(obj1);

obj2.lover && changeLover(obj2);
console.log(obj2);


//❗❗ null 또는 undefined인 경우를 확인할 때
let item = {price: 1000}; //null이나 undefinied를 선언해주고 변수를 줘야한다.
const price = item && item.price;
console.log(price);


//❗ 기본값을 설정
// default parameter : undefined해결
// 0, -0, null, '' 해결하지 못한다.
function print(message){
    const text = message || 'hello' // 이런 방식으로 default parameter의 예외상황들을 해결할 수 있다.
    console.log(text);
}

print('안녕');
print();//hello
print(undefined);//hello
print(null)//null
print('') // 아무것도 안찍힘


console.log('--------------------------')

let item2 = {price:10000};
const price2 = item?.price; // item && item.price; 동일
console.log(price2)


let banana ={name : '반하나' , lover : {name:'오렌지'}};

function printLoverName(obj){
    const loverName = obj ?.lover?.name//obj && lover && lover.name;
    console.log(loverName)
}

printLoverName(banana);

let num =0;
console.log(num || '-1'); // -1
console.log(num ?? '-1'); // 0 -> null, undefined 에서만










