// ✔ 상속(Extends)
class Animal{
    constructor(color){
        this.color = color;
    }
    eat() {
        console.log('먹는다!');
    }
    sleep() {
        console.log('잔다!');
    }
}

class Dog extends Animal{
    play(){
        console.log('논다!')
    }
}

class Cat extends Animal {
    constructor(color, name){
        super(color);
        this.name = name;
    }
    // 오버라이딩
    eat() {
        console.log('맛나게 먹는다!!!')
    }
}

const Rucy = new Dog('white');
console.log(Rucy);
Rucy.eat();
Rucy.sleep();
Rucy.play();

const Tom = new Cat('black','톰');
console.log(Tom);
Tom.eat();

console.log('----------------------------');

class Counter {
    #value;
    constructor(value){
        if(isNaN(value) || value < 0){
            this.#value = 0;
        }else{
            this.#value = value;
        }
        
    }
    get value(){
        return this.#value;
    }
    increment(){
        this.#value++;
    }
}

const counter = new Counter(0);
counter.increment();
counter.increment();
counter.increment();
console.log(counter.value); // 벨류가 찍힐려면 get을 사용

console.log('----------------------------');







class Employee{
    constructor(name, emp, time, pay){
        this.name = name;
        this.emp = emp;
        this.time = time;
        this.pay = pay;
    }
    calculatePay(){
        return this.time *this.pay;
    }

}

class FullTimeEmployee extends Employee{
    static PAY_RATE = 20000;
    constructor(name, emp, time){
        super(name, emp, time, FullTimeEmployee.PAY_RATE);
    }
}

class PartTimeEmployee extends Employee{
    static PAY_RATE = 10000;
    constructor(name, emp, time){
        super(name, emp, time, PartTimeEmployee.PAY_RATE);
    }
}


const Kim = new FullTimeEmployee('김사과', '개발자', 160);
const Ban = new PartTimeEmployee('반하나', '디자이너', 100);


console.log(Kim.calculatePay());
console.log(Ban.calculatePay());






