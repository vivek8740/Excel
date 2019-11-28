package Read.Json.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class Detect {

	public static String filePath = "D:/LAUNCH_StringFile_Latest_JBay_07.xls";
	public static HSSFWorkbook workbook;
	public static HSSFSheet sheet,temp_sheet;
	public static FileOutputStream fileOut;
	public static String  temp_sheet_name = null;
	public static void findTruncation() 
	{
		try 
		{
			
			HSSFRow row,row_head;
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File(filePath)));
			sheet = workbook.getSheetAt(0);
			for (int nrow = 0; nrow < 5 ; nrow++)
			{
				if(nrow > 0)
				{
					temp_sheet_name = sheet.getRow(nrow).getCell(0).getStringCellValue();
					temp_sheet = workbook.createSheet(temp_sheet_name);
					row_head = temp_sheet.createRow(0);
					row = temp_sheet.createRow(1);
					for(int ncell = 0 ; ncell < sheet.getRow(0).getPhysicalNumberOfCells() ; ncell++)
					{
						row_head.createCell(ncell).setCellValue(sheet.getRow(0).getCell(ncell).toString());
						if(sheet.getRow(nrow).getCell(ncell).getCellType() == CellType.STRING)
							row.createCell(ncell).setCellValue(sheet.getRow(1).getCell(ncell).toString());
						else
						{
							row.createCell(ncell, CellType.NUMERIC).setCellValue(sheet.getRow(nrow).getCell(ncell).getNumericCellValue());
							row.setHeightInPoints((float)(sheet.getRow(1).getCell(8).getNumericCellValue() * .75));
							
						}

					}
				}

			}
			fileOut = new FileOutputStream(filePath);
			workbook.write(fileOut);
			fileOut.close();
			workbook.close();
			System.out.println("Truncation Detected....");
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}

	}

}
