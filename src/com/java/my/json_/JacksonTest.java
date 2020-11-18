package my.json_;

import java.io.IOException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author  : J
 * @version : Jun 29, 2017  9:43:29 AM
 * explain  : 
 */
public class JacksonTest {
	public static void main(String args[]){
	      ObjectMapper mapper = new ObjectMapper();
	      String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";
	      try {
	         Student student = mapper.readValue(jsonString, Student.class);
	         System.out.println(student);
//	         mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
	        
	         Student s = new Student();
	         s.setName("张三");
	         s.setAge(24);
	         String str = mapper.writeValueAsString("s++++++ "+s);
	         System.out.println(str);

	      } catch (JsonParseException e) {
	         e.printStackTrace();
	      } catch (JsonMappingException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }
	}

	class Student {
	   private String name;
	   private int age;
	   public Student(){}
	   public String getName() {
	      return name;
	   }
	   public void setName(String name) {
	      this.name = name;
	   }
	   public int getAge() {
	      return age;
	   }
	   public void setAge(int age) {
	      this.age = age;
	   }
	   public String toString(){
	      return "Student [ name: "+name+", age: "+ age+ " ]";
	   }	

}
