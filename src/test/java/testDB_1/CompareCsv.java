package testDB_1;

import java.io.*;
import java.util.ArrayList;

/* file1 - file2 = file3*/
public class CompareCsv {
	public void Comapre(String file1,String file2,String file3) throws FileNotFoundException, IOException
		{
		    ArrayList <String> al1=new ArrayList();
		    ArrayList <String> al2=new ArrayList();
		    ArrayList <String> al3=new ArrayList();

		    BufferedReader CSVFile1 = new BufferedReader(new FileReader(file1));
		    String dataRow1 = CSVFile1.readLine();
			String Titles=dataRow1;
		    while (dataRow1 != null)
		    {
		        al1.add(dataRow1);
		        dataRow1 = CSVFile1.readLine(); // Read next line of data.
		    }

		     CSVFile1.close();

		    BufferedReader CSVFile2 = new BufferedReader(new FileReader(file2));
		    String dataRow2 = CSVFile2.readLine();
		    while (dataRow2 != null)
		    {
		    	al2.add(dataRow2);
		        dataRow2 = CSVFile2.readLine(); // Read next line of data.
		    }
		     CSVFile2.close();

		     for(String bs:al2)
		     {
		         al1.remove(bs);
		     }

		     int size=al1.size();
		     System.out.println(size);

		     try
		        {
		            FileWriter writer=new FileWriter(file3);
		            writer.append(Titles);
		            writer.append("\n");
		            while(size!=0)
		            {
		                size--;
		                writer.append(al1.get(size));
		                writer.append('\n');
		            }
		            writer.flush();
		            writer.close();
		        }
		        catch(IOException e)
		        {
		            e.printStackTrace();
		        }		
		
	}
}
