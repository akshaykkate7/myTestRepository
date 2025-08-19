package OpenBrowser;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle_2 {

	public static void main(String[] args) {
WebDriver d= new ChromeDriver();
d.get("https://omayo.blogspot.com/");
JavascriptExecutor js = (JavascriptExecutor) d;
js.executeScript("window.scrollBy(0,1600)");
d.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
String P_id = d.getWindowHandle();
d.findElement(By.xpath("//a[contains(text(),'Open a popup window')]")).click();
Set<String> W_id = d.getWindowHandles();

for(String id:W_id) {
	if(!id.equals(P_id)) {
		d.switchTo().window(id);
		WebElement pop_up_text = d.findElement(By.xpath("//div[@class='example']/h3"));
		String text = pop_up_text.getText();
		System.out.println(text);
		d.close();
		break;
		}
		}
d.switchTo().window(P_id);
WebElement name = d.findElement(By.xpath("//textarea[@id=\"ta1\"]"));
	name.sendKeys("ballubhai");
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	String text2 = d.findElement(By.xpath("//textarea[contains(text(),\"The cat was playing in the garden.\")]")).getText();
	System.out.println(text2);
	d.quit();
	}

}
