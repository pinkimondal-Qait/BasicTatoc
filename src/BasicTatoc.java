import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BasicTatoc {

	public static void main(String[] args) throws InterruptedException {
		String color2="null";
		//Initialize Chrome Driver
		    WebDriver driver = new ChromeDriver();
		    driver.get("http://10.0.1.86/tatoc/basic/grid/gate");
		    driver.findElement(By.cssSelector("div.greenbox")).click();
		    driver.switchTo().frame("main");
		    String color1= driver.findElement(By.cssSelector("#answer")).getAttribute("class");
		    //  System.out.println(color1);
		    driver.switchTo().frame("child");
		    color2= driver.findElement(By.cssSelector("#answer")).getAttribute("class");
		    // System.out.println(color2);
		    driver.switchTo().defaultContent();
		    driver.switchTo().frame("main");
		    while(!color1.equals(color2))
		    {   
		    	Thread.sleep(500);
		        driver.findElement(By.linkText("Repaint Box 2")).click();
		        // System.out.println(color1.equals(color2));
		        driver.switchTo().frame("child");
		        color2= driver.findElement(By.cssSelector("#answer")).getAttribute("class");
		        driver.switchTo().defaultContent();
		        driver.switchTo().frame("main");
     	    	if(color1.equals(color2))
     	    	{
		    		driver.findElement(By.linkText("Proceed")).click();
		    		break;
		    	}
		    }
		  WebElement element = driver.findElement(By.id("dragbox")); 
          WebElement target = driver.findElement(By.id("dropbox"));
		    (new Actions(driver)).dragAndDrop(element, target).perform();
		    driver.findElement(By.linkText("Proceed")).click();
		    driver.findElement(By.linkText("Launch Popup Window")).click();
		    String firstWinHandle = driver.getWindowHandle();
		    for(String webHand: driver.getWindowHandles()){
		    	driver.switchTo().window(webHand);
		     }
		   Thread.sleep(2000);
		    driver.findElement(By.cssSelector("input#name")).sendKeys("Username");
		    driver.findElement(By.cssSelector("input#submit")).click();
		    driver.switchTo().window(firstWinHandle);
		    driver.findElement(By.linkText("Proceed")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.linkText("Generate Token")).click();
		    Thread.sleep(2000);
		    String t=driver.findElement(By.cssSelector("span#token")).getText();
		    Cookie token = new Cookie("Token", t.substring(7));
		    driver.manage().addCookie(token);
		   // Set<Cookie> cookiesList =  driver.manage().getCookies();
			//for(Cookie getcookies :cookiesList) {
			  //  System.out.println(getcookies );
			//}
    	   driver.findElement(By.linkText("Proceed")).click();
		    }
		  }
	

