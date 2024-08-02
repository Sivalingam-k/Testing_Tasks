const {add,sub,mul,div}=require('../src/app')
//const expect=require('chai').expect

let expect;
(async ()=>{
    const chai=await import('chai');//importing chai explictly
    expect=chai.expect;
})();

//1.BDD -'describe and 'it'
describe('Suite 1',()=>{
    it('add(3,3) should return 6',()=>{
        expect(add(3,3)).to.be.equal(6);
    })
})

describe('Suite 2',()=>{
    it('sub(2,3) should return -1',()=>{
        expect(sub(2,3)).to.be.equal(-1);
    })
})

describe('Suite 3',()=>{
    it('mul(2,3) should return 6',()=>{
        expect(mul(2,3)).to.be.equal(6);
    })
})

describe('Suite 4',()=>{
    it('div(3,1) should return 3',()=>{
        expect(div(3,1)).to.be.equal(3);
    })
})


























