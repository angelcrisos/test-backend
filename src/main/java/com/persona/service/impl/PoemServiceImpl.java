package com.persona.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persona.Client.PoemClient;
import com.persona.response.Poem;
import com.persona.service.PoemService;

@Service
public class PoemServiceImpl implements PoemService {
	
	@Autowired
	private PoemClient client;

	@Override
	public List<Poem> getPoems() {
		// TODO Auto-generated method stub
		return client.getPoems();
	}

}
