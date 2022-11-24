function runInDelay(seconds){
    return new Promise((resolve, reject) => {
        if(!seconds || seconds < 0){
            reject(new Error('seconds가 0보다 작음!'));
        }
        setTimeout(resolve, seconds * 2000);
    })
}


// runInDelay(2)
//     .then(() => console.log('타이머가 완료되었습니다!')) // 정상 - resolve
//     .catch(console.error) // 에러 - reject
//     .finally(() => console.log('모든 작업이 끝났습니다'));

runInDelay()
    .then(() => console.log('타이머가 완료되었습니다!')) // 정상 - resolve
    .catch(console.error) // 에러 - reject
    .finally(() => console.log('모든 작업이 끝났습니다'));