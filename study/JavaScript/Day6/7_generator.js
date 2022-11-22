function* multipleGenerator(){
    try{
        for(let i=0; i<10; i++){
            console.log(i);
            yield i**2; //next 가 나와야 실행
            //yield는 한번만 돌고 다음 next가 다시 와야 한번 더 돈다
            
        }
    }catch(error){// callback으로 사용
        console.log(error);
    }
}

const multiple = multipleGenerator();
let next = multiple.next();
console.log(next.value, next.done);
// 끝이 아닐경우 next.done은 false가 나온다
next = multiple.next();
console.log(next.value, next.done);
next = multiple.next();
console.log(next.value, next.done);










