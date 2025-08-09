package Aug08;
import java.io.*;

public class Lab1 {

	    public static void main(String[] args) {
	        String filePath = "src/main/java/Aug08/sample.txt"; 

	        try {
	            FileReader fr = new FileReader(filePath);
	            BufferedReader br = new BufferedReader(fr);

	            StringBuilder content = new StringBuilder();
	            String line;
	            while ((line = br.readLine()) != null) {
	                content.append(line).append(System.lineSeparator());
	            }
	            br.close();
	            
	            String reversedContent = content.reverse().toString();

	            FileWriter fw = new FileWriter(filePath);
	            BufferedWriter bw = new BufferedWriter(fw);
	            bw.write(reversedContent);
	            bw.close();

	            System.out.println("File content reversed successfully!");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}



