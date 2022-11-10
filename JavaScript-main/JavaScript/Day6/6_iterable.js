const arr = [1,2,3,4,5];
console.log(arr.values());
console.log(arr.entries());
console.log(arr.keys());
//iterable을 이용하여 values,entry,key를 사용할 수 있으며 next사용도 가능하다.
const iterator = arr.values(); // 값이 들어 있는지 확인이 가능하다
while(true){
    const item = iterator.next(); // 다음 줄 내용을 뽑을 경우 반복
    if(item.done) break;// 데이터가 없으면 break, 데이터가 있는지 확인
    console.log(item.value) 
}

for(let item of arr){ // for문간에 of를 사용할 수 있는 것들은 거이 iterator한 것이다.
    console.log(item);
}

for(let item of arr.values()){
    console.log(item)
}
