import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ARFFbuilder {
	
	private int attributeNO;
	private ArrayList<String> attributes;
	private ArrayList<ArrayList<String>> data;
	private String space = " ";
	private String fileDir = "C:\\Users\\user\\Downloads\\Compressed\\";
	private HashMap<String,ArrayList<String>> attrType;
	
	
	
	public ARFFbuilder(int attributeNO, ArrayList<String> attributes, ArrayList<ArrayList<String>> data,
			HashMap<String, ArrayList<String>> attrType) {
		super();
		this.attributeNO = attributeNO;
		this.attributes = attributes;
		this.data = data;
		this.attrType = attrType;
	}

	public void writeFile() {
		BufferedWriter bw = null;
		String fileName = userInput();
		String fullDir = fileDir +fileName + ".arff";
				//System.out.println(fileName);
		try {
			bw = new BufferedWriter(new FileWriter(new File(fullDir)));
			
			bw.write("@relation"+space+fileName);
			bw.newLine();
			bw.newLine();
			String line;
			for(int i = 0;i < attributeNO;i++) {
				line = "@attribute" + space + attributes.get(i) + space;
				ArrayList<String> list = attrType.get(attributes.get(i));
				
				if(list.size() == 1) {
					line += list.get(0);
				}
				else {
					line += "{";
					for(int j = 0;j < list.size();j++) {
						line = line + list.get(j);
						if(j != list.size()-1) {
							line = line + ",";
						}
					}
					line = line + "}";
				}
				
				bw.write(line);
				bw.newLine();
				
			}
			bw.newLine();
			bw.newLine();
			bw.write("@Data");
			bw.newLine();
			
			for(int i = 0;i < data.size();i++) {
				line = "";
				for(int j = 0;j < data.get(i).size();j++) {
					line = line + data.get(i).get(j);
					if(j != data.get(i).size()-1) {
						line += ",";
					}
				}
				bw.write(line);
				bw.newLine();
			}
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	public static String userInput() {
		String fileName = null;
		BufferedReader br = null;
		try {
			
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter ARFF filename to save:");
			fileName = br.readLine();
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
		}
		
		return fileName;
	}
	
	
}
