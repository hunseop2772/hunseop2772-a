// map 
const map =new Map([
    ['key1', '🍎'],
    ['key2', '🍌']
]);
console.log(map)

//사이즈 확인
console.log(map.size);

//존재하는지 확인
console.log(map.has('key1'))
console.log(map.has('key6'))

// 순회
map.forEach((value, key) => console.log(key,value));

// 찾기
console.log(map.get('key1'));
console.log(map.get('key2'));
console.log(map.get('key3'));

obj ={'key1':'🍎', 'key2' : '🍌'};
console.log(obj['key1']) // 🍎
console.log(map['key1']) // undefined


// 추가
map.set('key3', '🍊')
console.log(map)


// 삭제
map.delete('key3')
console.log(map)


// 전부삭제
map.clear();
console.log(map)


console.log('-------------------------------------------')


const fruits = ['🍎','🍌','🍊' ,'🍌', '🍊', '🍎','🍑']

function removeDuplication(array){
    return [...new Set(array)]
}

console.log(removeDuplication(fruits))


// 주어진 두 세트의 공통된 아이템만 담고 있는 세트를 생성해보자

const set3 = new Set([1,2,3,4,5])
const set4 = new Set([1,2,3])

function findIntersection(set1,set2){ 
    return new Set([...set3].filter((item) => set2.has(item)))
}//filter 트루인 경우만 반환하고 has를 사용해서 비교하기!

console.log(findIntersection(set3,set4));



