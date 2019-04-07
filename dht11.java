import java.io.BufferedReader;
import java.io.InputStreamReader;

public class dht11 {

	private static String line;
	private static String[] data;
	//static int humidity = 0;
	static int temperature = 0;
	
	public static void main(String[] args) throws Exception {
		
		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec("sudo python dht11.py");
		 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		 if((line = bufferedReader.readLine()) != null){
			 

		     data = line.split("\\n");
		     temperature = Integer.parseInt(data[0]);
		     System.out.println(data[0]);
	             //humidity=Integer.parseInt(data[1]);
		     //System.out.println(data[1]);
			 
		 } else {
			 
			System.out.println("Data Error");
			
			}
	  
	bufferedReader.close();
	process.waitFor();
	System.out.println("Temperature is : "+temperature);
      	//System.out.println("Temperature is : "+temperature+" 'C Humidity is :"+ humidity+" %RH");
	System.out.println("Done");
	
	}

}
