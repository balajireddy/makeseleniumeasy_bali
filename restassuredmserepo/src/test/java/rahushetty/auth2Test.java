package rahushetty;
import static io.restassured.RestAssured.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class auth2Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://accounts.google.com/o/oauth2 v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
		driver.findElement(By.className("ss")).click();
		String currentURL=driver.getCurrentUrl();
		String partialcode=currentURL.split("code=")[1];
		String code=partialcode.split("scope=")[0];
		
		System.out.println(code);
		
		
		
		
		 String accestokenresponse=given().urlEncodingEnabled(false)
		.queryParam("code", code)
		.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("grant_type", "authorization_code")
        .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
        .when().log().all()
        .post("https://www.googleapis.com/oauth2/v4/token").asString();
		 
		 JsonPath js =new JsonPath(accestokenresponse);
		 String accestoken_variable=js.getString("access_token");
		 
		 
		 
		
		
		
		String response=given().queryParam("access_token", accestoken_variable)
		.when().log().all()
		.get("https://rahulshettyacademy.com/getCourse.php").asString();
		
		System.out.println(response);
		
		String response=given().queryParam("access_token12", accestoken_variable)
		.when().log().all()
		.get("https://rahulshettyacademy.com/getCourse.php12").asString();
		
		getcourses gc=((RequestSpecification) given().queryParam("access_token", accestoken_variable).expect().defaultParser(Parser.JSON)
				.when()).log().all()
				.get("https://rahulshettyacademy.com/getCourse.php").as(getcourses.class);
				
		System.out.println(gc.getLinkedin());
		System.out.println(gc.getLinkedin());
		gc.getCourses().getApi().get(1).getCoursetitle();
		
		
		List<api> apicorses=gc.getCourses().getApi();
		for(int i=0;i<=apicorses.size();i++)
		{
			if(apicorses.get(i).getCoursetitle().equalsIgnoreCase("Soap ui testing")){
				
				System.out.println(apicorses.get(i).getPrice());
			}
			}
		}

		
		
		
	}


