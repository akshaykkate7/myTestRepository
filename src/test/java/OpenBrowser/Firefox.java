package OpenBrowser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox {
//ok akshay kate
	public static void main(String[] args) {
		FirefoxDriver f= new FirefoxDriver();
		f.get("https://www.flipkart.com/");
		List<WebElement> AllLinks = f.findElements(By.tagName("//a"));
		
		int i=1;
		for(WebElement link:AllLinks){
			System.out.println(i+link.getAttribute("href"));
			i++;
		}
	}

}
