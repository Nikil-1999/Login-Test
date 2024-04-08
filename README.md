**LoginTest Application**

---

**Description:**

LoginTest is a Spring Boot application designed to demonstrate OAuth2 Single Sign-On (SSO) functionality using Okta as the identity provider. It allows users to securely log in, access protected resources, and handle authentication errors gracefully.

---

**Setup Instructions:**

1. **Clone Repository:**
   Clone the LoginTest repository to your local machine using the following command:
   ```
   git clone <repository_url>
   ```

2. **Configuration:**
   - Update `application.properties` with your Okta configuration details.
   - Set `okta.oauth2.issuer` to your Okta issuer URI.
   - Specify `login.username` and `login.password` with the credentials for authentication.

3. **Build and Run:**
   - Build the application using Maven:
     ```
     mvn clean install
     ```
   - Run the application using the generated JAR file:
     ```
     java -jar target/login-test.jar
     ```

4. **Accessing the Application:**
   - Once the application is running, access it via `http://localhost:8080`.
   - Navigate to `/login` to initiate the login process.

---

**Endpoints:**

- **/index:** Home page of the application.
- **/login-success:** Redirects to the index page after successful login.
- **/secure:** Secure endpoint accessible only to authenticated users.
- **/logout:** Logs out the current user and redirects to the Okta end session endpoint.

---

**Components:**

1. **Security Configuration:**
   - `SecurityConfiguration` class configures basic security settings.
   - `OktaOAuth2Configuration` class configures OAuth2 Single Sign-On using Okta.

2. **Controllers:**
   - `LoginController` manages login, logout, and secure resource access.
   - `CustomErrorController` handles custom error pages.
   - `LogoutController` manages user logout functionality.

3. **Services:**
   - `AuthenticationService` validates user credentials.

---

**Dependencies:**

- **Spring Boot Starter Web:** For handling web requests.
- **Spring Security:** For implementing security features.
- **Spring Boot OAuth2 Client:** For OAuth2 Single Sign-On integration.
- **Spring Boot Starter Test:** For testing the application.

---

**Notes:**

- Ensure proper configuration of Okta settings for seamless integration.
- Customize error handling and security configurations as per project requirements.

---

**Contributors:**

- Nikil Suresh Raaju

---