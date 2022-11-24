function getBanana(){
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve('🍌');
        }, 1000);
    })
}

function getApple(){
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve('🍎');
        }, 3000);
    })
}

function getOrange(){
    return Promise.reject(new Error('오렌지는 없음'));
}

// 바나나와 사과를 동시에 가지고 오기
// 바나나와 사과를 배열에 저장해서 콘솔에 출력
// 순차적으로 처리 -> 총 4초가 걸림

// 바나나와 사과를 같이 가지고 오기
async function fetchFruits(){
    const banana = await getBanana();
    const apple = await getApple();
    return [banana,apple];
}

fetchFruits()
    .then((fruit) => console.log(fruit));

// getBanana()
//     .then((banana) =>
//     getApple()
//         .then((apple) => [banana, apple]))
//         .then(console.log);





// // Promise.all 병렬적으로 한번에 모든 Promise들을 실행
// Promise.all([getBanana(),getApple()])
//     .then((fruits) => console.log('✔ Promise.all: ', fruits));

// // Promise.race: 주어진 Promise중에 가장 빨리 수행된 것이 출력
// Promise.race([getBanana(),getApple()])
//     .then((fruit) => console.log('✔ Promise.race: ',fruit));

// Promise.all([getBanana(), getApple(), getOrange()])
//     .then((fruits) => console.log('✔ Error: ', fruits))
//     .catch(console.log);

// Promise.allSettled([getBanana(),getApple(),getOrange()])
//     .then((fruits) => console.log('✔ Promise.allSettle: ', fruits))
//     .catch(console.log);