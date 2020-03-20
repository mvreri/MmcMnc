package mccCountryCodes;
//this class contains the setters and getters for the scrapped data
public class countryCodes {
	
	String countrycode;
	String telco;
	
	ccodesReadWrite ccrw = new ccodesReadWrite();

public String getCountryCode() {
	ccrw.ReadFromFile();
	return countrycode;
}

public void setCountryCode(String countrycode) {
	
	this.countrycode = countrycode;
}

public String getTelco() {
	return telco;
}

public void setTelco(String telco) {
	this.telco = telco;
}

}
