package io.cal;

public class CreateAnAccountPage {

	 public String yourName(String firstname,String Lastname) {
		 return (firstname+Lastname);
	 }
	 public String MobileNumberAndEmailId(String expectedMobNo,String EmailId) {
		 
		 return (expectedMobNo+""+EmailId);
	 }
	 public boolean CheckPassword(String pass) {
		 return pass.length()==6;
	 }
	 public boolean clickContinue(String name,String email,String password) {
		 return true;
	 }
}