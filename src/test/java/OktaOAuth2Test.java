import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.assignment.logintest.LogintestApplication;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = LogintestApplication.class)
@AutoConfigureMockMvc
public class OktaOAuth2Test {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "test@123.com", password = "admin@user", roles = "USER") // Mock a user for testing
    public void testSecureEndpointAccessibleWithAuthentication() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/secure")) // Assuming /secure is a secure endpoint
                .andExpect(MockMvcResultMatchers.status().isOk()); // Expect HTTP 200 OK
    }

    // @Test
    // public void testUnsecuredEndpointAccessibleWithoutAuthentication() throws Exception {
    //     mockMvc.perform(MockMvcRequestBuilders.get("/unsecuredEndpoint")) // Assuming /unsecured is an unsecured endpoint
    //             .andExpect(MockMvcResultMatchers.status().isOk()); // Expect HTTP 200 OK
    // }

}
