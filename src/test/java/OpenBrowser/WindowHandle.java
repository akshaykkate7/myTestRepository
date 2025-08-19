package OpenBrowser;

import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) {
		WebDriver d= new ChromeDriver();
		d.get("https://www.flipkart.com/");
		String mainWindow = d.getWindowHandle();
		WebElement become_a_seller = d.findElement(By.xpath("(//img[@alt='Become a Seller'])[1]"));
		become_a_seller.click();
		Set<String> ALLWindow = d.getWindowHandles();
		for(String id:ALLWindow) {
			if(!id.equals(mainWindow)) {
				d.switchTo().window(id);
				System.out.println("switched to new window");
			 d.findElement(By.xpath("//img[@alt='Cart']")).click();
				WebElement text1= d.findElement(By.xpath("//div[@class='s2gOFd']"));
				String text = text1.getText();
				System.out.println(text);
				d.quit();
				break;
			}
		}
			d.switchTo().defaultContent();
			WebElement login = d.findElement(By.xpath("(//span['login'])[1]"));
			login.click();
//		search_box.sendKeys("iphone");
//		search_box.sendKeys(Keys.ENTER);
		d.quit();
		
	}

}
