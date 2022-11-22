// 객체를 만드는 켐플릿
// 1. 생성자 함수
// 2. 틀래스
//     static : 정적 프로퍼티 및 메서드
class Fruit {
    // eng = 'noname';
    static count_fruits = 0;
    constructor(name, emoji){
        this.name = name;
        this.emoji = emoji;
    }
    display = () => {
        console.log(`${this.name} : ${this.emoji}`);
    };

    static makeBanana() {
        // return 'banana';// class이름으로 바로 접근가능
        return new Fruit('banana', '🍌');
        // 클래스 레벨 메서드에서는 this를 참조할 수 없음
    }

}
// apple은 Fruit 클래스의 인스턴스
const apple = new Fruit('apple','🍎');
// orange는 Fruit 클래스의 인스턴스
const orange = new Fruit('orange','🍊');

console.log(apple);
console.log(orange);
console.log(apple.name);
console.log(orange.emoji);
apple.display();

const banana = Fruit.makeBanana();
console.log(banana);
console.log(Fruit.count_fruits);

console.log('--------------------------------------')



class Dog{
    #name; //외부에서 내 내용을 변경불가능하게 # = private
    #color;
    constructor(name, color){
        this.#name = name;
        this.#color = color;
    }
    get info(){
        return `이름 :${this.#name}, 색상 : ${this.#color}`;
    }
    set info(value){// 가격을 받아 처리
        console.log(`set`,value);
        this.#name = value;
    }
    run = () => {
        console.log(`${this.#color} 색상의 상아지 ${this.#name}는 달립니다.`)
    }
    #eat = () =>{
        console.log(` ${this.#name}는 먹습니다.`)
    }
}
const Rucy = new Dog('루시', 'white');
console.log(Rucy);
Rucy.name = '개똥이'; //public으로 새롭게 만들어짐
// Rucy.#name = 'asd'// private은 밖에서 사용 불가능하다
//#field는 외부에서 접근이 불가능하다.
console.log(Rucy);
Rucy.run();
// Rucy.eat();
console.log(Rucy.name);
// console.log(Rucy.info());
console.log(Rucy.info); //get사용시, 출력만하면 get
Rucy.info = '뽀미'; //set을 부름, 입력하면 set
console.log(Rucy.info); //get



































