function readFile(path){
    throw new Error('파일 경로를 찾을 수 없음');
    return '파일의 내용을 리턴함';
}

function processFile(path){
    let content;
    try{
        content = readFile(path);
    }catch(error){
        console.log(error);
        content = '기본내용';
    }finally{
        console.log('에러의 발생 여부와 관계없이 실행할 문장을 작성함');
    }
    const result = '결과: ' + content;
    return result;
}

const result = processFile('경로');
console.log(result);