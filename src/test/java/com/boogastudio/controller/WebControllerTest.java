package com.boogastudio.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.RestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebControllerTest {

	/** REST docs configuration */
    @Rule
    public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation(
            "target/generated-snippets");
 
    /** REST document handler */
    private RestDocumentationResultHandler document;
    
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private MockMvc mockMvc;

	@Before
	public void setUp() {
//		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
//				.apply(documentationConfiguration(this.restDocumentation)).build();
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	    
	}
	
	@Test
	public void test() throws Exception {
//		this.mockMvc.perform(get("/save").accept(
//                MediaType.APPLICATION_JSON)).andExpect(
//        status().isOk());
		
		this.mockMvc.perform(
				get("/findall").accept(
                        MediaType.APPLICATION_JSON)).andExpect(
                status().isOk());
	}

}
