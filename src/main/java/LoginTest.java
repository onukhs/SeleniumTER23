import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest extends TestBase {

    private final String EXPECTED_BLOCKED_USER_ERROR_MESSAGE = "Epic sadface: Sorry, this user has been locked out.";
    private final String EXPECTED_UNEXISTED_USER_ERROR_MESSAGE = "Epic sadface: Username and password do not match any user in this service";

    @Test
    public void validLoginTest() {
        LoginFlow.doLogin("standard_user");
        LoginFlow.verifyCartIsVisible();
    }

    @Test
    public void blockedUserLoginTest() {
        LoginFlow.doLogin("locked_out_user");
        String errorMessage = LoginFlow.getErrorMessage();

        assertEquals(EXPECTED_BLOCKED_USER_ERROR_MESSAGE, errorMessage);
    }

    @Test
    public void unexistedUserLoginTest() {
        LoginFlow.doLogin("sjkdfjvksldkfh");
        String errorMessage = LoginFlow.getErrorMessage();

        assertEquals(EXPECTED_UNEXISTED_USER_ERROR_MESSAGE ,errorMessage);
    }
}
