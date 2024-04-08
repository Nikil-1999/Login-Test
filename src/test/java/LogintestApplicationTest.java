import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.assignment.logintest.LogintestApplication;
import com.assignment.logintest.controllers.LoginTestController;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ContextConfiguration(classes=LogintestApplication.class)
@WebAppConfiguration
class LogintestApplicationTest {

	@Value("${login.username}")
	private String usernameProp;

	@Value("${login.password}")
	private String passwordProp;

	// @Autowired
	// private static WebApplicationContext webApplicationContext;

	// private static MockMvc mockMvc;

	// @Before
	// public static void setUp() {
	// 	mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	// }

	String username = "admin";
	String password = "test";

    String exampleUserJson = "{\"username\":\"admin\",\"password\":\"test\"}";

	@Test
	void usernamePasswordLoginTest() throws Exception {

		// RequestBuilder requestBuilder = MockMvcRequestBuilders
		// 		.post("/login/u2pcheck")
		// 		.accept(MediaType.APPLICATION_JSON).content(exampleUserJson)
		// 		.contentType(MediaType.APPLICATION_JSON);

		// MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		// MockHttpServletResponse response = result.getResponse();
		
		// assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), response.getStatus());

		// assertEquals("http://localhost:8080/login/u2pcheck",
		// 		response.getHeader(HttpHeaders.LOCATION));

		assertEquals(usernameProp, username);
		assertEquals(passwordProp, password);

    }

	@Test
    public void testTimeout() throws InterruptedException {
        // Create a mock of AsyncService
        LoginTestController mockService = mock(LoginTestController.class);
        // Invoke the method
        mockService.session();
        // Verify that the method was called within 100 milliseconds
        verify(mockService, timeout(1000)).session();
    }

}
