// const expect=require('chai').expect
const {add,sub,mul,div}=require('../src/app')
let expect;
(async ()=>{
    const chai=await import('chai');//importing chai explictly
    expect=chai.expect;
})();

describe('HooksSuite 1',()=>{
    before(()=>{
        console.log('before')
    });
    after(()=>{
        console.log('After')
    });

    beforeEach(()=>{
        console.log('beforeEach')
    });
    afterEach(()=>{
        console.log('afterEach')
    });
    describe('Suite 1',()=>{
        it('add(3,3) should return 6',()=>{
            expect(add(3,3)).to.be.equal(6);
        })
    })

})