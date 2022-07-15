package com.example.pnc_assessment;

import javax.validation.Valid;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class UserController {
	@PostMapping("/user")
	public ResponseEntity<Output> user(@Valid @RequestBody User user, BindingResult result){
		
		RestTemplate restTemplate = new RestTemplate();
		Output output = new Output();
		String city = "";
		String ipAddressURL = "http://ip-api.com/json/";
		JSONObject jsonObject;
		try {
			ResponseEntity<String> response = restTemplate.getForEntity(ipAddressURL+user.getIpAddress(), String.class);
			String apiResponse = response.getBody();
			jsonObject = new JSONObject(apiResponse);
			// Assignment said Canada - using US currently
			String country = (String)jsonObject.get("country");
			if (country.equals("United States")) {
				city = (String)jsonObject.get("city");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			output.setStatus("Failed");
			output.setErrors(result.getFieldErrors());
			// IP doesn't exist - not sure how to throw an error for this
			return new ResponseEntity<Output>(output, HttpStatus.BAD_REQUEST);
		}
		
		if (result.hasErrors()){
			output.setStatus("Failed");
			output.setWelcomeMessage("Check errors log!");
			output.setErrors(result.getFieldErrors());		
			return new ResponseEntity<Output>(output, HttpStatus.BAD_REQUEST);
		}
		else {
			output.setStatus("Success");
			output.setWelcomeMessage("Welcome!");
			output.setUuid(user.getUuid());
			output.setCity(city);			
			return new ResponseEntity<Output>(output, HttpStatus.OK);
		}
	}
}
	
