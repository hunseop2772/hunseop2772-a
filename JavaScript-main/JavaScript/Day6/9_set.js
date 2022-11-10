//set 순서가 없는 중복되지 않은 집합
const set = new Set([1,2,3,4,5]);
console.log(set) // Set(5) { 1, 2, 3, 4, 5 }


// 사이즈 확인
console.log(set.size) // 5


// 데이터가 존재하는지 확인
console.log(set.has(2)) //true
console.log(set.has(7)) // false


// 순회
set.forEach((item) => console.log(item))
// == 위 아래 동일한 문장이다.
for(let value of set.values()){
    console.log(value)
}
// set에 있는 데이터를 하나씩 넘겨주는 기능으로 
//set에 있는 데이터 수만큼 반복 출력하는 것이다.

//추가
set.add(6)
console.log(set)
set.add(6);
console.log(set) // set은 중복값 불가

//삭제
set.delete(6)
console.log(set)

// 전부삭제
set.clear()
console.log(set)

// 오브젝트 세트
const obj1 = {name:'사과', emoji:'😈', price : 1000};
const obj2 = {name:'바나나', emoji:'🍌', price : 2000};
const set2 = new Set([obj1,obj2]);
console.log(set2)

obj1.price = 1500;
set2.add(obj1); // true 수정은 가능하나
console.log(set2) //false set은 동일한 명(주소)은 추가가 안된다.

const obj3 = {name:'사과', emoji:'😈', price : 1000};
set2.add(obj3);
console.log(set2)