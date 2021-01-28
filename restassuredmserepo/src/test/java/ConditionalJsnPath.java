import io.restassured.RestAssured;

public class ConditionalJsnPath {
	
	public static void main(String[] args) {
		
		String s = RestAssured.get("http://dummy.restapiexample.com/api/v1/employees")
		.then()
		.extract()
		.jsonPath()
		.get("data.find{it.id=='1'}.employee_name");
		System.out.println(s);
	}

}
