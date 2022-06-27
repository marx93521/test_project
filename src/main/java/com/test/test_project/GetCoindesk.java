package com.test.test_project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.test_project.entity.Coindesk;

import ch.qos.logback.core.pattern.Converter;

import org.springframework.util.Assert;

@RestController
public class GetCoindesk {
	String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
	String inputLine;
    StringBuffer content = new StringBuffer();
    Coindesk coindesk = new Coindesk();
    String data ;
	@RequestMapping(value="/getCoin/", method=RequestMethod.GET)
	public Coindesk GetCoindeskInfo() {
		URL getUrl;
		
		try {
			getUrl = new URL(url);
			HttpURLConnection http = (HttpURLConnection)getUrl.openConnection();
			http.setRequestMethod("GET");
			http.setDoOutput(true);
			http.setRequestProperty("Accept", "application/html");
			http.setRequestProperty("Content-Type", "application/javascript");
			http.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36");
			
			if (http.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ http.getResponseCode());
			}
			

		    BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));
		    
		    while ((inputLine = in.readLine()) != null) {
		    	content.append(inputLine);
		    }
		    in.close();
		    http.disconnect();
		    
			ObjectMapper objectMapper = new ObjectMapper(); 
		    //String jsonString = objectMapper.writeValueAsString(content);
		    coindesk = objectMapper.readValue(content.toString(), Coindesk.class);
		    System.out.println(coindesk.toString());
		    data = coindesk.toString();
//		    ParseCoin parseCoin = new ParseCoin();
//			parseCoin.ParseData(coindesk);
//		    Map<String,String> coinTime = coindesk.getTime();
//		    String jsonString = objectMapper.writeValueAsString(coinTime);
//		    System.out.println(jsonString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return coindesk;
	}

}
