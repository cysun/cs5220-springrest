package springrest.api.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@Test
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:springrest-servlet.xml",
    "classpath:applicationContext.xml" })
class UserControllerTests
    extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeClass
    void setup()
    {
        this.mockMvc = MockMvcBuilders.webAppContextSetup( wac ).build();
    }

    @Test
    void getUser() throws Exception
    {
        this.mockMvc.perform( get( "/users/1" ) )
            .andExpect( status().isOk() )
            .andExpect( jsonPath( "username" ).value( "admin" ) );
    }

    @Test
    void getUsers() throws Exception
    {
        this.mockMvc.perform( get( "/users" ) )
            .andExpect( status().isOk() )
            .andExpect( jsonPath( "$[0].username" ).value( "admin" ) );
    }

}
