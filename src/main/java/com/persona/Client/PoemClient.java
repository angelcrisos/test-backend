package com.persona.Client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.persona.response.Poem;

@Service
public class PoemClient {

	@Autowired
	private RestTemplate restTemplate;

	public List<Poem> getPoems() {

		UriComponentsBuilder builder = UriComponentsBuilder.newInstance().scheme("https").host("www.poemist.com")
				.path("api/v1/randompoems");
		ResponseEntity<List<Poem>> responseEntity = restTemplate.exchange(builder.build().toUri(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Poem>>() {
				});
		return responseEntity.getBody();
	}

}
