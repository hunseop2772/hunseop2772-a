const dog = {
    name: '루시',
    age: 13,
    eat: () => {
        console.log('먹고있음!')
    }
};

const json = JSON.stringify(dog);
console.log(json);
console.log(dog);

const obj = JSON.parse(json);
console.log(obj);