package mccCountryCodes;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;



public class ccodesMain {


	@GET
	@Path("/api/v1/country/networkCountry")
	@Produces("application/json")
	public countryCodes getCcodes() {

		countryCodes cc = new countryCodes();
		cc.getCountryCode();
		cc.getTelco();
		
		return cc; 

	}
	
	
	@GET
	@Path("/api/v1/country/mmc/networks")
	@Produces("application/json")
	public countryCodes getMMC() {
		countryCodes cc = new countryCodes();
		cc.getCountryCode();
		cc.getTelco();
		
		return cc; 

	}
	
	@GET
	@Path("/api/v1/country/mnc/networks")
	@Produces("application/json")
	public countryCodes getMNC() {
		countryCodes cc = new countryCodes();
		cc.getCountryCode();
		cc.getTelco();
		
		return cc; 

	}
	
	

}
