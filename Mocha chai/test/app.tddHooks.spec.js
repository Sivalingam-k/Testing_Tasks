const{suite,test,setup,teardown,suiteSetup,suiteTeardown}=require('mocha')


suite('TDD Hooks',()=>{
    suiteSetup(()=>{
        console.log('one suiteSetup')
    });
    suiteTeardown(()=>{
        console.log('one suiteTeardown')
    });
    setup(()=>{
        console.log('one setup')
    });
    teardown(()=>{
        console.log('one teardown')
    });
 test('add(7,3) should return 10',()=>{
    console.log('one test')
 });
})