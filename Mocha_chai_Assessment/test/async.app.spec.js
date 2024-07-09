const axios=require('axios')
// const expect=require('chai').expect

let expect;
(async ()=>{
    const chai=await import('chai');
    expect=chai.expect;
})();

    describe(' async test suite 1',()=>{
        it('Promised based way',()=>{
       axios.get("http://localhost:8888/users").then(res=>{
        expect(res.data[1].useremail).to.be.equal("siva123@gmail.com")
       expect(res.data[1].carname).to.be.equal("suzuki-nexa"),
        expect(res.data.data[1].username).to.be.equal("tempuser"),
        expect(res.data.data[1].password).to.be.equal("1234567890")
      })
        })
        it('done based way',(done)=>{
            axios.get("http://localhost:8888/users").then(res=>{
                expect(res.data[5].id).to.be.equal("9a44")
                done()
            }).catch(err=>{
                done(err)
            })
        })
        it('async based way',async ()=>{
                const res=await axios.get("http://localhost:8888/users")
                expect(res.data[6].username).to.be.equal("finaltesting06")
        });
    })
  