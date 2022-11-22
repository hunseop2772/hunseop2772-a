// const str;
// str = '김사과'; (X)

const str = '김사과'; // "" , '' 혼용사용 가능
console.log(str);

// str ='바나나'; 중복 사용X

const obj = {id: 'apple', name: 'banana'}; // 객체 생성
// obj = 10;

// 참조변수를 바꾸지 못하는 것이지 해당 필드를 바꾸지 못하는것은 아니다!!!!
obj.id ="cherry";
obj.name ="apple";

console.log(obj.id);
console.log(obj.name);