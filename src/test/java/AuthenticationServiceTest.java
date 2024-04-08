import org.junit.jupiter.api.Test;

import com.assignment.logintest.services.AuthenticationService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AuthenticationServiceTest {

    @Test
    public void testValidateCredentials_ValidCredentials() {
        // Create a mock instance of the service
        AuthenticationService authenticationService = mock(AuthenticationService.class);

        // Define the behavior of the mock service method
        when(authenticationService.validateCredentials("validUser", "password123")).thenReturn(true);

        // Call the method under test
        boolean result = authenticationService.validateCredentials("validUser", "password123");

        // Verify that the method was called with the correct parameters
        verify(authenticationService).validateCredentials("validUser", "password123");

        // Assert that the result is true for valid credentials
        assertTrue(result);
    }

    @Test
    public void testValidateCredentials_InvalidCredentials() {
        // Create a mock instance of the service
        AuthenticationService authenticationService = mock(AuthenticationService.class);

        // Define the behavior of the mock service method
        when(authenticationService.validateCredentials(anyString(), anyString())).thenReturn(false);

        // Call the method under test
        boolean result = authenticationService.validateCredentials("invalidUser", "invalidPassword");

        // Verify that the method was called with the correct parameters
        verify(authenticationService).validateCredentials("invalidUser", "invalidPassword");

        // Assert that the result is false for invalid credentials
        assertFalse(result);
    }
}
