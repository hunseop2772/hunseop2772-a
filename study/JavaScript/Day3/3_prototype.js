function Dog(color, name, age){
    this.color =color;
    this.name = name;
    this.age=age;
}

const Rucy = new Dog(`white`, `lucy`, 13);
console.log(`이름 : ${Rucy.name}`)
console.log(`색상 : ${Rucy.color}`)
console.log(`나이 : ${Rucy.age}`)
Rucy.family = `포메`; // 본인 객체에 프로토타입을 생성하였기 때문에 자기에게만 변경이 되고 다른 곳에서는 포함되지 않는다.
Rucy.getFamily = function(){
    return this.family;
}

console.log(`종 : ${Rucy.family}`)
console.log(Rucy.getFamily())

const PPomi = new Dog(`black`, `뽀미`, 4)
console.log(`이름 : ${PPomi.name}`)
console.log(`색상 : ${PPomi.color}`)
console.log(`나이 : ${PPomi.age}`)
console.log(`종 : ${PPomi.family}`)
// console.log(PPomi.getFamily())

console.log(`----------------------------------`);

Dog.prototype.birthday = `20091210`;
Dog.prototype.run = function(){
    return this.name + '달립니다.'; 
} // 앞으로 객체를 만들때마다 prototype에 만들어 주었기 때문에 이 후 객체들은 이 내용이 포함된 상태이다.

const PPory = new Dog(`white`, `bory`, 6)
console.log(`이름 : ${PPory.name}`)
console.log(`색상 : ${PPory.color}`)
console.log(`나이 : ${PPory.age}`)
console.log(`생일 : ${PPory.birthday}`)
console.log(PPory.run())


















