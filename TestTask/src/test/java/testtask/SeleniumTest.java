package testtask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SeleniumTest {

	@Test
	public void exists() {

		WebDriver driver = new HtmlUnitDriver();

		driver.get("http://localhost:8080/testtask/");

		assertEquals("Test Task", driver.getTitle());

		driver.quit();
	}
}
