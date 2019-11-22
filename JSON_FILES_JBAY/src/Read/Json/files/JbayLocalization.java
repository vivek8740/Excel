package Read.Json.files;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonObject;

public class JbayLocalization {

	public static String identifier = null;
	public static String filePath = "D:/LAUNCH_StringFile_Latest_JBay_07.xls";
	public static Object object;

	public static int count = 0;
	public static int languageCount = 0;
	public static ArrayList<LanguagePojo> arrayList = new ArrayList<LanguagePojo>();

	public static void main(String[] args) {

		try {
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("StringSheet");
			JSONParser jsonParser = new JSONParser();
			arrayList.add(new LanguagePojo(null, null, (long) 0, (long) 0, null, (long) 0, (long) 0, null, null));
			
			if (languageCount == 0) {
				arrayList = Utils.getlanguages(workbook, sheet, jsonParser, "COCO_RD_Copy_10232019.json");
				create(filePath, workbook, sheet);
				languageCount++;
			}
//			if (languageCount == 1) {
//				arrayList = Utils.getlanguages(workbook, sheet, jsonParser, "COCO_RD_Copy_BR.json");
//				create(filePath, workbook, sheet);
//				languageCount++;
//			}
//			if (languageCount == 2) {
//				arrayList = Utils.getlanguages(workbook, sheet, jsonParser, "COCO_RD_Copy_CN.json");
//				create(filePath, workbook, sheet, arrayList);
//				languageCount++;
//			}
//			if (languageCount == 3) {
//				arrayList = Utils.getlanguages(workbook, sheet, jsonParser, "COCO_RD_Copy_DE.json");
//				create(filePath, workbook, sheet, arrayList);
//				languageCount++;
//			}
//			if (languageCount == 4) {
//				arrayList = Utils.getlanguages(workbook, sheet, jsonParser, "COCO_RD_Copy_ES.json");
//				create(filePath, workbook, sheet, arrayList);
//				languageCount++;
//			}
//			if (languageCount == 5) {
//				arrayList = Utils.getlanguages(workbook, sheet, jsonParser, "COCO_RD_Copy_FR.json");
//				create(filePath, workbook, sheet, arrayList);
//				languageCount++;
//			}
//			if (languageCount == 6) {
//				arrayList = Utils.getlanguages(workbook, sheet, jsonParser, "COCO_RD_Copy_IT.json");
//				create(filePath, workbook, sheet, arrayList);
//				languageCount++;
//			}
//			if (languageCount == 7) {
//				arrayList = Utils.getlanguages(workbook, sheet, jsonParser, "COCO_RD_Copy_JP.json");
//				create(filePath, workbook, sheet, arrayList);
//				languageCount++;
//			}
//			if (languageCount == 8) {
//				arrayList = Utils.getlanguages(workbook, sheet, jsonParser, "COCO_RD_Copy_KR.json");
//				create(filePath, workbook, sheet, arrayList);
//				languageCount++;
//			}
//			if (languageCount == 9) {
//				arrayList = Utils.getlanguages(workbook, sheet, jsonParser, "COCO_RD_Copy_RU.json");
//				create(filePath, workbook, sheet, arrayList);
//				languageCount++;
//			}
//			if (languageCount == 10) {
//				arrayList = Utils.getlanguages(workbook, sheet, jsonParser, "COCO_RD_Copy_SE.json");
//				create(filePath, workbook, sheet, arrayList);
//				languageCount++;
//			}
//			if (languageCount == 11) {
//				arrayList = Utils.getlanguages(workbook, sheet, jsonParser, "COCO_RD_Copy_TW.json");
//				create(filePath, workbook, sheet, arrayList);
//				languageCount++;
//			}
			
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	public static void create(String filename, HSSFWorkbook workbook, HSSFSheet sheet) {

		try {
			for (int i = 0; i < arrayList.size(); i++) {
				if (i == 0) {

					HSSFRow rowhead = sheet.createRow((short) 0);
					rowhead.createCell(count).setCellValue("Identifier");
					count++;
					rowhead.createCell(count).setCellValue("Default");
					count++;
					details(rowhead);

				} else {

					HSSFRow row = sheet.createRow((short) i);
					row.createCell(0).setCellValue(arrayList.get(i).getIdentifier());
					row.createCell(1).setCellValue(arrayList.get(i).getEnglish());
					row.createCell(2).setCellValue(arrayList.get(i).getFontName());
					row.createCell(3).setCellValue(arrayList.get(i).getFontSize());
					row.createCell(4).setCellValue(arrayList.get(i).getTextAlignment());
					row.createCell(5).setCellValue(arrayList.get(i).getMaxChar());
					row.createCell(6).setCellValue(arrayList.get(i).getMaxLine());
					row.createCell(7).setCellValue(
							"W: " + arrayList.get(i).getWidth() + " " + "H: " + arrayList.get(i).getHeight());

					System.out.println(row.getHeightInPoints() / 0.75);
				}
			}
			FileOutputStream fileOut = new FileOutputStream(filename);
			workbook.write(fileOut);
			fileOut.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}

		System.out.println("File has been generated...");
	}

	private static void details(HSSFRow rowhead) {

		rowhead.createCell(count).setCellValue("fontName");
		count++;
		rowhead.createCell(count).setCellValue("fontSize");
		count++;
		rowhead.createCell(count).setCellValue("textAlignment");
		count++;
		rowhead.createCell(count).setCellValue("maxChar");
		count++;
		rowhead.createCell(count).setCellValue("maxLine");
		count++;
		rowhead.createCell(count).setCellValue("size");
		count++;
		System.out.println(count);
	}

}
