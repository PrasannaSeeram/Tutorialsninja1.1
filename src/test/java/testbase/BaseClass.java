package testbase;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public Logger logger;
	public static WebDriver driver;
	public Properties properties;
	@BeforeClass(groups={"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setUp(String os,String br) throws IOException {
		
		FileReader file=new FileReader(".//src//test//resources//config.properties");
		properties=new Properties();
		properties.load(file);
		logger=LogManager.getLogger(this.getClass());
		
		if(properties.getProperty("environment_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities=new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WINDOWS);
			}else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}else if(os.equalsIgnoreCase("linux")) {
				capabilities.setPlatform(Platform.LINUX);
			}
			else {
				System.out.println("No Matching os");return;
			}
				
			if(br.equalsIgnoreCase("chrome")) {
				capabilities.setBrowserName("chrome");
			}else if(br.equalsIgnoreCase("edge")) {
				capabilities.setBrowserName("MicrosoftEdge");
			}else if(br.equalsIgnoreCase("firefox")) {
				capabilities.setBrowserName("firefox");
			}else {
				System.out.println("invalid browser"); return;
			}
			
			 driver=new RemoteWebDriver(new URL("http://192.168.1.231:4444/wd/hub"),capabilities);
		}
		
		if(properties.getProperty("environment_env").equalsIgnoreCase("local")) {
		switch(br.toLowerCase()) {
		case "chrome":driver=new ChromeDriver();break;
		case "firefox":driver=new FirefoxDriver(); break;
		case "edge": driver=new EdgeDriver(); break;
		default:System.out.println("invalid browser");return;
		}}
		
		driver.manage().deleteAllCookies();
		driver.get(properties.getProperty("appurl"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups={"Sanity","Regression","Master"})
	public void tearDown() {
		driver.quit();
	}
	
	public String randomString() {
		
	String text = RandomStringUtils.randomAlphabetic(5);
	return text;
	}
	
	public String randomNumber() {
		
		String num = RandomStringUtils.randomNumeric(5);
		return num;
		}
	
	public String randomAlphaNumber() {
		
		String text = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(3);
		return (text+num);
		}
	
	public String captureScreen(String sname) throws IOException{
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot) driver;
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);
		String targetfilepath=(System.getProperty("user.dir")+"\\Screenshots\\"+sname+"-"+timeStamp+".png");
		File targetFile=new File(targetfilepath);
		sourcefile.renameTo(targetFile);
		return targetfilepath;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
