package ExcelDataDriven;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;


public class dataDriven {
	
	
	private static final NumberToTextConverter NumbertoTextConverter = null;

	//once coloum is identified then scan entire testcase to identify "Purchase" testcase.
	//after you grab purchase testcases row = pull all the data of that row and feed into test.
	
	public ArrayList<String> getData(String testcaseName) throws IOException 
	{
		
	ArrayList<String> a = new ArrayList<String>();
	FileInputStream fis = new FileInputStream("C://Users//Smruti.Samal//ExcelDataDriven.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	
	//Fetch the number of sheet count from the excel workbook.
	int totalnosheets= workbook.getNumberOfSheets();
	for (int i=0;i<totalnosheets;i++) 
	{
		if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
		{
		//We have grabbed the "testdata" sheet into "sheet".
		XSSFSheet sheet= workbook.getSheetAt(i);
		
		//Identify Testcases column by scanning the entire 1st row.
		
		Iterator<Row> rows= sheet.iterator();
		Row firstrow=rows.next();
		Iterator<Cell> ce=firstrow.cellIterator();
		int k=0;
		int coloum = 0;
		while(ce.hasNext()) 
		{
			Cell value= ce.next();
			if(value.getStringCellValue().equalsIgnoreCase(testcaseName)) 
			{
				//desired column
				coloum=k;
			}
			k++;
		
		}
		//System.out.println(coloum);
		while(rows.hasNext()) {
			Row r=rows.next();
			if(r.getCell(coloum).getStringCellValue().equalsIgnoreCase("Purchase")) 
			{
				//after you grab "purchase" testcase = pull all the data of that row and feed into test.
				Iterator<Cell> cv= r.cellIterator();
				while(cv.hasNext())
				{
					Cell c=cv.next();
					if(c.getCellType()==CellType.STRING) 
					{
						a.add(c.getStringCellValue());
					}
					else 
					{
						a.add(NumbertoTextConverter.toText(c.getNumericCellValue()));
					}
						
				
				}
			}
			
		}
		
		
		}
		
	}
	return a;
	}
}

