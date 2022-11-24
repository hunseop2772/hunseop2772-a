// default가 있을 경우
// import increase from './count.js';
// increase();

// dafault가 없는 경우
// import { increase } from "./count.js";
// increase();
// import { increase, getCount } from "./count.js";
// increase();
// increase();
// increase();
// increase();
// console.log(getCount());

// import { increase as add } from "./count.js";
// add();

import * as cnt from './count.js';
cnt.increase();
cnt.increase();
console.log(cnt.getCount());