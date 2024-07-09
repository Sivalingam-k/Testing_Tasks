const axios=require('axios')
// const expect=require('chai').expect

let expect;
(async ()=>{
    const chai=await import('chai');
    expect=chai.expect;
})();

    describe(' Retrive test suite 1',function(){
        this.retries(3);//Retry all tests in this suite up to 1 times
        it('Promised based way',()=>{
             //retry the specific testcase upto 2 times
       axios.get('http://localhost:8888/users').then(res=>{
        expect(res.data[1].useremail).to.be.equal('siva123@gmail.com')
       // expect(res.data[1].carname).to.be.equal("suzuki-nexa"),
        // expect(res.data.data[1].username).to.be.equal('tempuser'),
        // expect(res.data.data[1].carprice).to.be.equal('34567')
      }).catch(err=>{
        console.error('Error during test:',err);
        throw err;
      });
    });
});