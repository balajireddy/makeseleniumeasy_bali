package SerializationDeserialization;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

public class SerializeJavaToJsonObjectUsingGSON {

	public static void main(String[] args) throws JsonIOException, IOException {
		
		// Create a Employee java object
		Employee employeeObject = new Employee();
		employeeObject.setFirstName("Amod");
		employeeObject.setLastName("Mahajan");
		employeeObject.setAge(29);
		employeeObject.setSalary(10987.77);
		employeeObject.setMarried(false);
		employeeObject.setGender("M");
		
		// Create a Gson object
		Gson gson = new Gson();
		// toJson(Object src) method converts Java object to JSON object
		String employeeJsonSring = gson.toJson(employeeObject);
		// Printing json string. It will be pretty print 
		System.out.println("Non-pretty JSON String :- ");
		System.out.println(employeeJsonSring);
		
		// We can create a configurable Gson instance using GsonBuilder class
		Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();
		String employeeJsonSringUsingJsonBuilder = gsonBuilder.toJson(employeeObject);
		System.out.println("Pretty JSON String :- ");
		System.out.println(employeeJsonSringUsingJsonBuilder);
		
		// To write Json object in to a file, we need to pass a FileWriter object which is in direct implementation of 
		// Appendable interface. Make sure you call flush() method otherwise json file will be empty.
		String userDir = System.getProperty("user.dir");
		File outputJsonFile = new File(userDir+ "\\src\\test\\resources\\EmployeePayloadUsingGson.json");
		FileWriter fileWriter = new FileWriter(outputJsonFile);
		gsonBuilder.toJson(employeeObject,fileWriter);
		fileWriter.flush();
		
	}
}
