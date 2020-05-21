package com.persona.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestBirthdayController {
	
	 @Autowired
	 private MockMvc mockMvc;
	 
	 private static final String JSON = "{\"name\":\"Nombre\",\"lastName\":\"ApellidoPaterno ApellidoMaterno\",\"dateOfBirth\":\"2010-01-09\"}";
	 
	 private static final String JSON_ERROR = "{\"name\":null,\"lastName\":\"ApellidoPaterno ApellidoMaterno\",\"dateOfBirth\":\"2010-01-09\"}";
	 
	 
	@Test
    public void testCreatePerson() throws Exception {
        String uriTest = "/api/people";
        this.mockMvc.perform(post(uriTest).content(JSON).contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
	
	@Test
    public void testCreatePersonError() throws Exception {
        String uriTest = "/api/people";
        this.mockMvc.perform(post(uriTest).content(JSON_ERROR).contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
