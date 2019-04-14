package scripts;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;
public class TestValidLogin extends BaseTest {
	@Test
	public void testValidLogin(){
		LoginPage lp = new LoginPage(driver);
		String username = Lib.getCellValue("ValidLogin", 1, 0);
		String password = Lib.getCellValue("ValidLogin", 1, 1);
		//enter username
		lp.setUsername(username);
		//etner password
		lp.setPassword(password);
		//click on login button
		lp.clickLogin();
		WebDriverWait wait = new WebDriverWait(driver,8);
		wait.until(ExpectedConditions.titleIs("actiTIME - Enter Time-Track"));
		
		String actualHPTitle = driver.getTitle();
		Assert.assertEquals(actualHPTitle, "actiTIME - Enter Time-Track");
		/*if (actualHPTitle.equals("I dont know")) {
			System.out.println("Login successfull");
		} else {
			System.out.println("Login failed..");
		}*/
	}
}
