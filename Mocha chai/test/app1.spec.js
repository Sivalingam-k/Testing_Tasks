const {suite,test}=require('mocha')
const {area_Of_Circle}=require('../src/app1')
//const expect=require('chai').expect

let expect;
(async ()=>{
    const chai=await import('chai');//importing chai explictly
    expect=chai.expect;
})();

//1.TDD -'Context' and 'Specify'
context('Suite 1',()=>{
    specify('area_Of_Circle(10) should return 314',()=>{
        expect(area_Of_Circle(10)).to.be.equal(314);
    })
})