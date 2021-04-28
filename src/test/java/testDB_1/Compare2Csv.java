package testDB_1;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;

public class Compare2Csv {

	@Test
	public void test1() {
		SimpleTblExporter temp =new SimpleTblExporter();
		temp.ExportOrderBy();
		CompareCsv compare=new CompareCsv();
		try {
			compare.Comapre("Export.csv","ExpectedResult.csv","Difference.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test2() {
		SimpleTblExporter temp =new SimpleTblExporter();
		temp.ExportOrderBy();
		CompareCsv compare=new CompareCsv();
		try {
			compare.Comapre("Export1.csv","ExpectedResult1.csv","Difference1.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
