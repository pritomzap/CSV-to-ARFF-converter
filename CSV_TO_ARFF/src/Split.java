import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Split {
	
	String commaSpliter = ",";
	ArrayList <String> lines;
	ArrayList<String> attributes;
	ArrayList<ArrayList<String>> data = new ArrayList<>();
	int attributeNum;
	
	public Split(ArrayList<String> lines) {
		this.lines = lines;
	}

	
	public int getAttributeNum() {
		attributeNum = lines.get(0).split(commaSpliter).length;
		return attributeNum;
	}
	
	public ArrayList<String> getAttribute(){
		
		attributes = new ArrayList<String>(Arrays.asList(lines.get(0).split(commaSpliter)));
		return attributes;
		
	}
	
	public ArrayList<ArrayList<String>> getData(){
		
		for(int i = 1;i < lines.size();i++) {
			data.add(new ArrayList<>(Arrays.asList(lines.get(i).split(commaSpliter))));
			//String temp = lines.get(i).toString();
			
		}
		return data;
	}
	
	public HashMap<String,ArrayList<String>> getAttributeTypes(){
		
		HashMap<String,ArrayList<String>> hashmap = new HashMap<>();
		String temp;
		ArrayList<String> types;
		
		for(int i = 0;i < attributeNum;i++) {
			types = new ArrayList<>();
			
			for(int j = 0;j < data.size();j++) {
				
				if(data.get(j).get(i).chars().allMatch(Character::isDigit) == true) {
					types.add("numeric");
					break;
				}
				else {
					if(j == 0) {
						
						temp = data.get(j).get(i);
						types.add(temp);
		
					}
					else {
						temp = data.get(j).get(i);
						
						if(!types.contains(temp)) {
							types.add(temp);
						}
					}
				}
				
			}
			hashmap.put(attributes.get(i),types);
		}
		//System.out.println(hashmap.toString());
		return hashmap;
	}
}
