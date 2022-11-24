function func1() {
    console.log('func1이 호출되었어요!');
    throw new Error('에러발생');
}

function func2(){
    try{
        func1();
    }catch(error){
        console.log('예외처리완료!');
        throw error;
    }
    
}

function func3(){
    try{
    func2();
    }catch(error){
        console.log('여기에서 예외처리 또 완료!');
    }
}

func3();
console.log('프로그램이 정상적으로 종료되었습니다!');