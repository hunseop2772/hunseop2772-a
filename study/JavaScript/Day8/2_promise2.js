function fetchEgg(chicken) {
    return Promise.resolve(`${chicken} => 🥚`);
}

function fryEgg(egg){
    return Promise.resolve(`${egg} => 🍳`);
}

function getChicken(){
    // return Promise.resolve(`🐔 => 🐓`)
    return Promise.reject(new Error('치킨이 다 떨어졌음!'));
}


// getChicken()
//     .then((chicken) => {
//         return fetchEgg(chicken)
//     })
//     .then((egg) => fryEgg(egg))
//     .then((friedEgg) => console.log(friedEgg))
//     .catch((error) => console.log(error.name));

// getChicken()
//     .catch(() => '🐥')
//     .then((chicken) => {
//         return fetchEgg(chicken)
//     })
//     .then((egg) => fryEgg(egg))
//     .then((friedEgg) => console.log(friedEgg));

// 축약형
getChicken()
    .catch(() => '🐥')
    .then(fetchEgg)
    .then(fryEgg)
    .then(console.log);