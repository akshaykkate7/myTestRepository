package OpenBrowser;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class ExtractLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver d= new ChromeDriver();
d.get("https://www.flipkart.com/");
List<WebElement> links = d.findElements(By.xpath("//a"));

int i=1;
for(WebElement l:links) {
	System.out.println(i+l.getAttribute("href"));
	i++;
}
d.quit();
	}

}
