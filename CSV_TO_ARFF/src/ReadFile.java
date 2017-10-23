import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
	
	String fileDir = "C:\\Users\\user\\Downloads\\Compressed\\weather_nominal.csv";
	//String splitBy = ",";
	
	public ArrayList<String> readLine() {
		
		BufferedReader br = null;
		String line;
		ArrayList<String> lines = new ArrayList<String>();
		
		try {
			
			br = new BufferedReader(new FileReader(fileDir));
			while((line = br.readLine())!=null) {
				lines.add(line);				
			}
			
		} catch (FileNotFoundException e) {
			 e.printStackTrace();
			 
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
		return lines;
	}
	
}
