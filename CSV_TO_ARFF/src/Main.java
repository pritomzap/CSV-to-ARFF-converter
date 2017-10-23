
public class Main {
	
	public static void main(String [] args) {
		
		ReadFile readfile = new ReadFile();
		Split split = new Split(readfile.readLine());
		
		ARFFbuilder arff = new ARFFbuilder(split.getAttributeNum()
				,split.getAttribute()
				,split.getData()
				,split.getAttributeTypes());
		
		arff.writeFile();
	}
}
