package OpenBrowser;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle_Multiplr {

	public static void main(String[] args) {
		WebDriver d= new ChromeDriver();
		d.get("https://omayo.blogspot.com/");
		String p_id = d.getWindowHandle();
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("window.scrollBy(0,1600)");
		d.findElement(By.xpath("//a[contains(text(),'Open a popup window')]")).click();
		d.findElement(By.xpath("//a[@id='link1']")).click();
		Set<String> All_id = d.getWindowHandles();
		
		for(String id:All_id) {
			d.switchTo().window(id);
			
			if(d.getTitle().equals("New Window")) {
				WebElement pop_up_text = d.findElement(By.xpath("//div[@class='example']/h3"));
				String text = pop_up_text.getText();
				System.out.println(text);
				d.close();
			}
			else if(d.getTitle().equals("Selenium143")) {
				WebElement e1 = d.findElement(By.xpath("//a[contains(text(),'Dynamic Method Dispatch')]"));
				String text1 = e1.getText();
				System.out.println(text1);
				
				String title = d.getTitle();
				System.out.println(title);
				d.close();
				
			}
		}
		
		d.switchTo().window(p_id);
		String text2 = d.findElement(By.xpath("//textarea[contains(text(),'The cat was playing in the garden.')]")).getText();
		System.out.println(text2);
		d.quit();
		

	}

}
