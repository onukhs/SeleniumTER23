import org.openqa.selenium.By;

public class LoginFlow extends TestBase{

    public static void doLogin(String username){
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@data-test='login-button']")).click();
    }

    public static void verifyCartIsVisible(){
        driver.findElement(By.xpath("//div[@class='shopping_cart_container']"));
    }

    public static String getErrorMessage(){
        return driver.findElement(By.xpath("//div[@class='error-message-container error']")).getText();
    }
}
